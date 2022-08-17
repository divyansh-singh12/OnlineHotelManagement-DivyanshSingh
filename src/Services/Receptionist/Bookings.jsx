import React from "react";
import {
    Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";

const Bookings = ({ bookings }) => {
    return (
        <div className="div2">
            <Card className="text-center bg-transparent text-dark">
                <CardBody className="form">
                    <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>{bookings.code}</CardSubtitle>
                    <br></br>
                    <CardText>Room No. : {bookings.roomno}</CardText>
                    <CardText>No of Children : {bookings.noOfChildren}</CardText>
                    <CardText>No of Adults : {bookings.noOfAdult}</CardText>
                    <CardText>Check-in Date : {bookings.checkIn}</CardText>
                    <CardText>Check-Out Date : {bookings.checkOut}</CardText>
                    <CardText>Status : {bookings.status}</CardText>
                    <CardText>No Of Night : {bookings.noOfNight}</CardText>
                    <CardText>Guest Email : {bookings.guestEmail}</CardText>
                    <CardText>Guest Phone No. : {bookings.guestPhoneNo}</CardText>
                </CardBody>
            </Card>
        </div>
    );

};

export default Bookings;