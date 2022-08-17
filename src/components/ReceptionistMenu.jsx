import React, { useState } from 'react';
import {
    FaBars,
    FaHome,
    FaSearch,
    FaMoneyCheck
} from "react-icons/fa";
import { MdLogout, MdOutlinePersonPin, MdOutlineBookmarks } from "react-icons/md";
import { NavLink, Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';


const ReceptionistMenu = ({ children }) => {
    const [isOpen, setIsOpen] = useState(false);
    const toggle = () => setIsOpen(!isOpen);
    const menuItem = [
        {
            path: "/receptionist/home",
            name: "Home",
            icon: <FaHome />
        },



        {
            path: "/receptionist/addguest",
            name: "Add Guest",
            icon: <MdOutlinePersonPin />
        },
        {
            path: "/receptionist/viewguestbyid",
            name: "View Guest By Id",
            icon: <MdOutlinePersonPin />
        },
        {
            path: "/receptionist/searchroom",
            name: "Search Rooms",
            icon: <FaSearch />
        },

        {
            path: "/receptionist/reservation",
            name: "Make Reservation",
            icon: <MdOutlineBookmarks />
        },
        {
            path: "/receptionist/viewbookings",
            name: "View All Reservation",
            icon: <MdOutlineBookmarks />
        },
        {
            path: "/receptionist/issuebill",
            name: "Issue Bill",
            icon: <FaMoneyCheck />
        }

    ]
    return (
        <div className="container1 recepbar" >

            <div style={{ width: isOpen ? "300px" : "50px" }} className="sidebar">
                <div className="top_section">
                    <h1 style={{ display: isOpen ? "block" : "none" }} className="logo">Receptionist </h1>
                    <div style={{ marginLeft: isOpen ? "35px" : "0px" }} className="bars">
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
                <Container className="text-center my-1" >

                    <Link tag="a" to="/login">
                        <Button color="danger" className="my-3 col-4 bt2">
                            {/* Logout */}
                            <MdLogout style={{ overflow: "auto", width: "100%", float: "none", display: "block" }} />
                        </Button></Link>
                </Container>

            </div>
            <main className='bgimage '>
                {children}
            </main>
        </div>
    );
};

export default ReceptionistMenu;