import { Link } from "react-router-dom";
import Header from "../../../pages/Header";
import React, { useState, useEffect } from "react";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";
import axios from "axios";
import base_url from "../../../api/bootapi";
import { useParams } from 'react-router-dom';

const ViewStaffResult = () => {
    useEffect(() => {
        document.title = "Searched Staff";
    }, []);

    useEffect(() => {
        getdata(val.code);
    }, []);

    var val = useParams();

    const getdata = (data) => {
        axios.get(`${base_url}ManageStaff/viewstaff/${data}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.code != null) {
                    console.log(response.data);
                    setStaff(response.data);
                    setAddress(response.data.address);
                } else {
                    alert("Invalid Staff code");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [staff, setStaff] = useState({});
    const [address, setAddress] = useState({});

    // for deleting data from server by delete button
    const deleteStaff = (code) => {
        axios.delete(`${base_url}ManageStaff/deletestaff/${code}`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                if (response.data === "Successfully deleted") {
                    window.open("http://localhost:3000/manager", "_top");
                }
            },
            (error) => {
                console.log(error);
            }
        );
    };
    return (
        <div>
            < Header />
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Staff Data</h2>
            <br></br>
            <div className="div2">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>Staff Code: {staff.code}</CardSubtitle>
                        <br></br>
                        <CardText>First Name: {staff.firstname}</CardText>
                        <CardText>Last Name: {staff.lastname}</CardText>
                        <CardText>Salary: {staff.salary}</CardText>
                        <CardText>Joined On: {staff.joinedon}</CardText>
                        <CardText>Age: {staff.age}</CardText>
                        <CardText>Occupation: {staff.occupation}</CardText>
                        <CardText>Email: {staff.email}</CardText>
                        <CardSubtitle className="fw-bold">Address</CardSubtitle>
                        <CardText>Street Name: {address.streetName}</CardText>
                        <CardText>House No: {address.houseNo}</CardText>
                        <CardText>City: {address.city}</CardText>
                        <CardText>State: {address.state}</CardText>
                        <CardText>Country: {address.country}</CardText>
                        <CardText>Pincode: {address.pincode}</CardText>
                        <CardText>Address Id: {address.id}</CardText>

                        <Container className="text-center">
                            <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}><Link className="list-group-item list-group-item-action" tag="a" to={"/manager/viewstaffbycode/result/update/" + staff.code}>Update</Link></Button>
                            <Button className="mx-2 bt btdelete" style={{ color: "white" }} onClick={() => { deleteStaff(staff.code); }}>Delete</Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}

export default ViewStaffResult;