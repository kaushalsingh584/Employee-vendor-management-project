import React, { useEffect, useRef, useState } from "react";
import "./login.css"
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Login = () => {
  const navigateObject = new useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  // const [token, setToken] = useState("kaushal");
  const token = useRef("")


  const handleMyLogin = async (e) => {
    e.preventDefault();

    if (username === "" && password === "") {
      alert("Username or Password is empty");
      return;
    }

    console.log(username, password);

    const response = await axios
      .post(
        `http://localhost:8080/app/login`,
        JSON.stringify({ username, password }),
        {
          headers: { "Content-Type": "application/json" },
          withCredentials: true,
        }
      )
      .catch((err) => {
        console.log(err);

      });

    console.log("response: "+JSON.stringify(response.data) + "authenticated: "+ response.data.authenticated)
    if(response.data.authenticated === false){
      alert("Invalid credentials");
      return;
    }

    console.log("logged in!!");
    const role = response.data.authority.toLowerCase();

    console.log("set 2!");
    // console.log(temp);
    console.log("passs 1!!");
    const response2 = await axios
    .get(`http://localhost:8080/app/${role}/${username}`, {
    })
    .catch((err) => {
      alert(err.message);
    });

    console.log(response2.data);
    
    // if( response2.data.user.status ===  false)
    // {
    //   alert("user does not exist");
    //   return
    // }
    localStorage.setItem('username',username)
    localStorage.setItem('password',"{noop}"+password)
    // localStorage.setItem('data',JSON.stringify(response2.data))
    // console.log("token ",JSON.parse(localStorage.getItem('data')))


    console.log("pass 2!!");
    if (role === "admin") {
      console.log(`/admindashboard/${username}/${role}`);
      navigateObject(
        `/admindashboard/${username}/${role}`);
    }
    else if (role === "employee") {
      navigateObject(
        `/employeedashboard/${username}/${role}`
      );
      return
    }
    else if (role === "VENDOR") {
      navigateObject(
        `/vendordashboard/${username}/${role}`
      );
      return
    }
  };
  return (
    <>
    <div className='loginhm' style={{ minHeight: "100vh" }}>
      <div className="login-form" style={{minHeight: "100vh"}}>
        
        <form>
          <h2>Login</h2>
          
          <div className="form-group">
            <label htmlFor="username">Username:</label>
            <input type="text" id="username" name="username"  onChange={(e) => setUsername(e.target.value)} required />
          </div>
          <div className="form-group">
            <label htmlFor="password">Password:</label>
            <input type="password" id="password" name="password" onChange={(e) => setPassword(e.target.value)} required />
          </div>
          <button onClick={handleMyLogin}>Login</button>
        </form>
      </div>
    </div>
    </>
  )
}


export default Login