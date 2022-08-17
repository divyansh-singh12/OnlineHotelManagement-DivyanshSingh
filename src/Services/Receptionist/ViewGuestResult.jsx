import { Link } from "react-router-dom";
import React, { useState, useEffect } from "react";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";
import axios from "axios";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';
import Header from "../../pages/Header";

const ViewGuestResult = () => {
    useEffect(() => {
        document.title = "Searched Guest";
    }, []);

    useEffect(() => {
        getdata(val.id);
    }, []);

    var val = useParams();

    const getdata = (data) => {
        axios.get(`${base_url}ManageGuest/viewguest/id/${data}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.id != null) {
                    console.log(response.data);
                    setGuest(response.data);
                    setAddress(response.data.address);
                } else {
                    alert("Invalid Guest code");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [guest, setGuest] = useState({});
    const [address, setAddress] = useState({});
    return (
        <div>
            < Header />
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Guest Result</h2>
            <br></br>
            <div className="carddiv">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>{guest.firstName} {guest.lastName}</CardSubtitle>
                        <br></br>
                        <CardText>ID : {guest.id}</CardText>
                        <CardText>Phone No. : {guest.phoneNumber}</CardText>
                        <CardText>Company : {guest.company}</CardText>
                        <CardText>Email : {guest.email}</CardText>
                        <CardText>Gender : {guest.gender}</CardText>
                        <CardText>Address Id : {address.id}</CardText>
                        <CardText>Street Name : {address.streetName}</CardText>
                        <CardText>House No. : {address.houseNo}</CardText>
                        <CardText>City : {address.city}</CardText>
                        <CardText>State : {address.state}</CardText>
                        <CardText>Country : {address.country}</CardText>
                        <CardText>Pincode : {address.pincode}</CardText>

                        <Container className="text-center">
                            <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}>
                                <Link className="list-group-item list-group-item-action" tag="a" to={"/receptionist/viewguestbyid/result/update/" + guest.id}>Update</Link></Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}

export default ViewGuestResult;