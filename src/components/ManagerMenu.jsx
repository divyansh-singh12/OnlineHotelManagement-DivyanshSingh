import React, { useState } from 'react';
import {
    FaBars,
    FaHome,
    FaChild,
    FaBorderAll,
    FaTools
} from "react-icons/fa";
import { MdLogout } from "react-icons/md";
import { NavLink, Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';


const ManagerMenu = ({ children }) => {
    const [isOpen, setIsOpen] = useState(false);
    const toggle = () => setIsOpen(!isOpen);
    const menuItem = [
        {
            path: "/manager/home",
            name: "Home",
            icon: <FaHome />
        },

        {
            path: "/manager/addinventory",
            name: "Add Inventory",
            icon: <FaTools />
        },
        {
            path: "/manager/viewinventorybyname",
            name: "View Inventory By Name",
            icon: <FaTools />
        },
        {
            path: "/manager/viewinventory",
            name: "View All Inventory",
            icon: <FaTools />
        },

        {
            path: "/manager/addstaff",
            name: "Add Staff",
            icon: <FaChild />
        },
        {
            path: "/manager/viewstaffbycode",
            name: "View Staff By Code",
            icon: <FaChild />
        },
        {
            path: "/manager/viewstaff",
            name: "View All Staff",
            icon: <FaChild />
        },

        {
            path: "/manager/addroom",
            name: "Add Room",
            icon: <FaBorderAll />
        },
        {
            path: "/manager/viewroombyroomno",
            name: "View Room By Room no",
            icon: <FaBorderAll />
        },
        {
            path: "/manager/setrates",
            name: "Set Room Rates",
            icon: <FaBorderAll />
        },


    ]
    return (
        <div className="container1"  >

            <div style={{ width: isOpen ? "300px" : "50px" }} className="sidebar">
                <div className="top_section" >
                    <h1 style={{ display: isOpen ? "block" : "none" }} className="logo">Manager </h1>
                    <div style={{ marginLeft: isOpen ? "50px" : "0px" }} className="bars">
                        <FaBars onClick={toggle} />
                    </div>
                </div>
                {
                    menuItem.map((item, index) => (
                        <NavLink to={item.path} key={index} className="link" activeclassname="active" style={{ textDecoration: "none" }} >
                            <div className="icon">{item.icon}</div>
                            <div style={{ display: isOpen ? "block" : "none" }} className="link_text">{item.name}</div>
                        </NavLink>

                    ))
                }
                <Container className="text-center my-1" >

                    <Link tag="a" to="/login">
                        <Button color="danger" className="my-3 col-4 bt2">
                            {/* Logout */}
                            <MdLogout style={{ overflow: "auto", width: "100%", float: "none", display: "block" }} />
                        </Button></Link>
                </Container>

            </div>
            <main className='bgimage ' >
                {children}
            </main>
        </div>
    );
};

export default ManagerMenu;