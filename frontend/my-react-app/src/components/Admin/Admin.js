import React from 'react'
import "./admin.css"
import Card from '../../Layout/Card/Card'
import { Link } from 'react-router-dom';
import img1 from '../../assets/C1.png';
import img2 from '../../assets/C2.png';
import img3 from '../../assets/C3.jpeg';
import img4 from '../../assets/C4.png';
import img5 from '../../assets/C5.jpg';
import img6 from '../../assets/C6.jpeg';
export const Admin = () => {

    const username = localStorage.getItem('username')
    const cardsData = [
        {
          id: 1,
          image: img1,
          title: 'Profile',
          // description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          link:`/admindashboard/profile/${username}`
        },
       
        {
          id: 2,
          image: img3,
          title: 'Add Employee',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          link:`/admindashboard/addEmployee`
        },
      
        {
          id: 3,
          image: img2,
          title: 'Add Vendor',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          link:`/admindashboard/addVendor`
        },
        {
          id: 4,
          image: img4,
          title: 'View Employees',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          link:`/admindashboard/viewEmployee`
        },
        {
          id: 5,
          image: img6,
          title: 'View Vendors',
          description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
          link:`/admindashboard/viewVendor`
        }
      ];
  return (
    <>

    <div className="card-grid" style={{ minHeight: "100vh" }}>
      {cardsData.map(card => (
        <Link to={card.link} style={{ textDecoration: 'none' }}>
            <Card
            key={card.id}
            image={card.image}
            title={card.title}
            buttonText={card.buttonText}
            />
        </Link>
      ))}
    </div>
    </>
  )
}
