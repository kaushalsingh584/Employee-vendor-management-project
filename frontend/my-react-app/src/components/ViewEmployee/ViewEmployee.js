import React from 'react'
import { useNavigate } from 'react-router'
import { useState } from 'react';
import axios from 'axios';
import { useEffect } from 'react';

function ViewEmployee() {
    const navigateObject = new useNavigate();
    const [Employees, setEmployees] = useState([]);
    const role = localStorage.getItem('role')
    useEffect(() => {
      console.log("use effect comes into effect -- view Employee");
      getAllEmployees()
    }, []);
  
  
    const getAllEmployees = async (e) => {
     const auth = 'Basic ' + btoa(localStorage.getItem("username") + ':' + localStorage.getItem("password"));
      const resp = await axios.get(`http://localhost:8080/app/emp/getAllEmployee`,
        {
          headers:
          {
            "Content-Type": "application/json",
            Authorization: auth
          },
          withCredentials: true,
        }
      ).catch((err) => {
        alert("error occured")
        return
      })
  
      console.log(resp.data);
      setEmployees(resp.data)
      console.log(resp.data);
    }
  
    const EmployeesRows = Employees.map((Employee, index) => {
      var status = "true"
      if (Employee.user.status === false) {
        status = "false"
      }
      return (
        <tr style={{ color: 'white' }}>
          <td>{Employee.username}</td>
          <td>{Employee.email}</td>
          <td>{Employee.name}</td>
          <td>{Employee.ctc}</td>
          <td>{Employee.designation}</td>
        </tr>
      )
    })
  
    const addNewEmployee = async (e) => {
      console.log("addEmployee Hitt");
      navigateObject(`/admindashboard/addEmployee`)
    }
  return (
    <>
     <div className='container' style={{ minHeight: "100vh" }} >
        <div style={{ overflowX: 'scroll', }}>
          <p style={{ color: 'white' }}><h1>View Employees</h1></p>
          {role == "admin" && (
            <button className="float-end" onClick={(e) => {
            
              navigateObject('/admindashboard/addEmployee')
            }} >add new Employee</button>)}
          <br />
          <br />
          <table class="table mt-4" style={{ overflow: "hidden", backgroundColor: 'rgba(20, 20, 20, 0.95)' }}>
            <thead>
              <tr style={{ color: 'coral' }}>
                <th scope="col">Employee Name</th>
                <th scope="col">Employee Email</th>
                <th scope="col">Employee Username</th>
                <th scope="col">Employee CTC</th>
                <th scope="col">Employee Designation</th>
              </tr>
            </thead>
            <tbody>
              {EmployeesRows}
            </tbody>
          </table>

        </div>
        </div>
    </>
  )
}

export default ViewEmployee