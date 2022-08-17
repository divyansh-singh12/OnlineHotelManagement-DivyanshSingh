import axios from "axios";
import { Link } from "react-router-dom";
import React from "react";
import {
    Card,
    CardBody,
    CardText,
    CardSubtitle,
    Button,
    Container,
} from "reactstrap";
import base_url from "../../../api/bootapi";

const Staff = ({ staff }) => {

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
                    window.open("http://localhost:3000/manager/viewstaff", "_top");
                }
            },
            (error) => {
                console.log(error);
            }
        );
    };

    return (
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
                    <CardText>Street Name: {staff.address.streetName}</CardText>
                    <CardText>House No: {staff.address.houseNo}</CardText>
                    <CardText>City: {staff.address.city}</CardText>
                    <CardText>State: {staff.address.state}</CardText>
                    <CardText>Country: {staff.address.country}</CardText>
                    <CardText>Pincode: {staff.address.pincode}</CardText>
                    <CardText>Address Id: {staff.address.id}</CardText>

                    <Container className="text-center">
                        <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}><Link className="list-group-item list-group-item-action" tag="a" to={"/manager/viewstaff/update/" + staff.code}>Update</Link></Button>
                        <Button className="mx-2 bt btdelete" style={{ color: "white" }} onClick={() => { deleteStaff(staff.code); }}>Delete</Button>
                    </Container>
                </CardBody>
            </Card>
        </div>
    );

};

export default Staff;