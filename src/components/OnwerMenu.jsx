import axios from 'axios';
import React, { useState } from 'react';
import {
    FaBars,
    FaUserAlt,
    FaRegChartBar,
    FaShoppingBag,
    FaRegBell,
    FaHome
} from "react-icons/fa";
import { MdLogout } from "react-icons/md";
import { Link, NavLink } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import base_url from '../api/bootapi';


const OwnerMenu = ({ children }) => {
    const [isOpen, setIsOpen] = useState(false);
    const toggle = () => setIsOpen(!isOpen);

    const handleClick = () => {
        deleteJwt();
    };

    const deleteJwt = () => {
        axios.delete(`${base_url}ManageJwt/deletejwt`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                if (response.data === "Successfully deleted") {
                    window.open("http://localhost:3000/login", "_top");
                }
                else {
                    alert("You have to login first");
                }
            },
            (error) => {
                console.log(error);
                alert("error occured");
            }
        );
    };


    const menuItem = [
        {
            path: "/owner/home",
            name: "Home",
            icon: <FaHome />
        },

        {
            path: "/owner/adddepartment",
            name: "Add Department",
            icon: <FaShoppingBag />
        },
        {
            path: "/owner/viewdepartmentbyName",
            name: "View Dept. by Name",
            icon: <FaShoppingBag />
        },
        {
            path: "/owner/viewall",
            name: "View All Dept.",
            icon: <FaShoppingBag />
        },

        {
            path: "/owner/adduser",
            name: "Add User",
            icon: <FaUserAlt />
        },
        {
            path: "/owner/updateuser",
            name: "Update User",
            icon: <FaUserAlt />
        },
        {
            path: "/owner/deleteuser",
            name: "Delete User",
            icon: <FaUserAlt />
        },

        {
            path: "/owner/retrievereport",
            name: "Retrieve Report",
            icon: <FaRegChartBar />
        },


    ]
    return (
        <div className="container1">

            <div style={{ width: isOpen ? "300px" : "60px" }} className="sidebar">
                <div className="top_section">
                    <h1 style={{ display: isOpen ? "block" : "none" }} className="logo">Owner </h1>
                    <div style={{ marginLeft: isOpen ? "85px" : "0px" }} className="bars">
                        <FaBars onClick={toggle} />
                    </div>
                </div>
                {
                    menuItem.map((item, index) => (
                        <NavLink to={item.path} key={index} className="link" activeclassname="active" style={{ textDecoration: "none" }}>
                            <div className="icon">{item.icon}</div>
                            <div style={{ display: isOpen ? "block" : "none" }} className="link_text">{item.name}</div>
                        </NavLink>

                    ))
                }
                <br></br>
                <br></br>
                <br></br>

                <Container className="text-center my-1" >
                    <Link tag="a" to="/owner/notifications">
                        <Button className="col-4 bt2" style={{ color: "white", backgroundColor: "#330033" }}>
                            {/* Notifications */}

                            <FaRegBell style={{ overflow: "auto", width: "100%", float: "none", display: "block" }} />

                        </Button>
                    </Link>
                    <br></br>

                    <Button color="danger" className="my-3 col-4 bt2" onClick={handleClick}>
                        {/* Logout */}
                        <MdLogout style={{ overflow: "auto", width: "100%", float: "none", display: "block" }} />
                    </Button>
                </Container>


            </div>
            <main className='bgimage '>
                {children}
            </main>
        </div>
    );
};

export default OwnerMenu;