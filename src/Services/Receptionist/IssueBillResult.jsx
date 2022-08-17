import { Link } from "react-router-dom";
import React, { useState, useEffect } from "react";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";
import Header from "../../pages/Header";
import axios from "axios";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';

const IssueBillResult = () => {
    useEffect(() => {
        document.title = "Bill";
    }, []);

    useEffect(() => {
        generateBill(val.roomno);
    }, []);

    var val = useParams();

    const generateBill = (data) => {
        axios.get(`${base_url}IssueBill/${data}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.billid != null) {
                    console.log(response.data);
                    setBill(response.data);
                } else {
                    alert("No Booking found");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
                alert("No Booking found");
            }
        )
    }
    const [bill, setBill] = useState({});
    const payment = () => {
        window.open("http://localhost:8085/");
    }
    return (
        <div>
            <Header />
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Generated Bill </h2>
            <br></br>
            <div className="div2">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>Total Amount : {bill.totalBill}</CardSubtitle>
                        <br></br>
                        <CardText>Bill ID : {bill.billid}</CardText>
                        <CardText>Guest Name : {bill.guestName}</CardText>
                        <CardText>Guest Email : {bill.guestEmail} </CardText>
                        <CardText>Room No : {bill.roomno}</CardText>
                        <CardText>Room Type : {bill.roomType}</CardText>
                        <CardText>Bill Date : {bill.billDate}</CardText>
                        <CardText>Total Days : {bill.days}</CardText>
                        <CardText>Rate : {bill.rate}</CardText>
                        <CardText>Extension Days : {bill.extensiondays}</CardText>
                        <CardText>Extension Rate : {bill.extensionRate}</CardText>
                        <CardText>Tax : {bill.tax}</CardText>

                        <Container className="text-center">
                            <Button className="my-1 col-3 bt" style={{ color: "white", backgroundColor: "#009BCD", marginLeft: "30px" }} onClick={() => { payment() }}>
                                Pay Online
                            </Button>
                            <Button className="col-3 mx-3 bt" style={{ color: "white", backgroundColor: "#1F6D03" }}>
                                <Link className="list-group-item list-group-item-action" tag="a" to="/receptionist">Pay Cash</Link>
                            </Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}
export default IssueBillResult;