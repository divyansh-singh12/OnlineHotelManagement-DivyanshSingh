import React, { useEffect, useState } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import { useParams } from "react-router-dom";
import base_url from "../../api/bootapi";
import axios from "axios";
import Header from "../../pages/Header";

const Reservation = () => {
    useEffect(() => {
        document.title = "Make Reservation";
    }, []);
    const [reservation, setReservation] = useState();
    var val = useParams().roomno;
    // reservation.roomno = val.roomno;
    const handleForm = (e) => {
        console.log(reservation);
        postDataToServer(reservation);
        e.preventDefault();
    };

    // function to post data on backend
    const postDataToServer = (data) => {
        axios.post(`${base_url}MakeReservation/doreservation`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data === "Room Booked Successfully") {
                    console.log(response);
                    console.log("success");
                    alert("Reservation Done successfully");
                } else {
                    alert("can't book this room. please check details once.");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    };
    return (
        <div>
            <Header />
            <div className="div2">
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Reservation Details</h2>
                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label htmlFor="roomno">Room No </label>
                        <Input
                            type="number"
                            placeholder={val}
                            name="roomno"
                            id="roomno"
                            onChange={(e) => {
                                setReservation({ ...reservation, roomno: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="noOfChildren">No of Children</label>
                        <Input
                            type="number"
                            placeholder="Enter here"
                            name="noOfChildren"
                            id="noOfChildren"
                            onChange={(e) => {
                                setReservation({ ...reservation, noOfChildren: e.target.value });
                            }}

                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="noOfAdults">No of Adults</label>
                        <Input
                            type="number"
                            placeholder="Enter here"
                            name="noOfAdults"
                            id="noOfAdults"
                            onChange={(e) => {
                                setReservation({ ...reservation, noOfAdult: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="checkIn">Checkin Date </label>
                        <Input
                            type="date"
                            placeholder="Enter here"
                            name="checkIn"
                            id="checkIn"
                            onChange={(e) => {
                                setReservation({ ...reservation, checkIn: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="checkOut">Checkout Date </label>
                        <Input
                            type="date"
                            placeholder="Enter here"
                            name="checkOut"
                            id="checkOut"
                            onChange={(e) => {
                                setReservation({ ...reservation, checkOut: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="status">Status </label>
                        <Input
                            type="text"
                            placeholder="Staying"
                            name="status"
                            id="status"
                            onChange={(e) => {
                                setReservation({ ...reservation, status: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="noOfNight">No of Nights</label>
                        <Input
                            type="number"
                            placeholder="Enter here"
                            name="noOfNight"
                            id="pnoOfNight"
                            onChange={(e) => {
                                setReservation({ ...reservation, noOfNight: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="guestEmail">Guest Email </label>
                        <Input
                            type="email"
                            placeholder="Enter email here"
                            name="guestEmail"
                            id="guestEmail"
                            onChange={(e) => {
                                setReservation({ ...reservation, guestEmail: e.target.value });
                            }} />
                    </FormGroup>

                    <FormGroup>
                        <label htmlFor="guestPhoneNo">Phone No </label>
                        <Input
                            type="number"
                            placeholder="Enter here"
                            name="guestPhoneNo"
                            id="guestPhoneNo"
                            onChange={(e) => {
                                setReservation({ ...reservation, guestPhoneNo: e.target.value });
                            }} />
                    </FormGroup>
                    <Container className="text-center">
                        <Button type="submit" className=" col-2 bt" color="success">
                            Confirm
                        </Button>
                        <Button type="reset" className="col-2 bt" color="dark" style={{ margin: '15px' }}>
                            clear
                        </Button>


                    </Container>
                </Form>
            </div>
        </div>
    )
}

export default Reservation;