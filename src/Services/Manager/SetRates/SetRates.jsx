import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import Header from "../../../pages/Header";

const SetRates = () => {
    useEffect(() => {
        document.title = "Set Room Rates";
    }, []);

    const [roomRates, setRoomRates] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(roomRates);
        putDataToServer(roomRates);
        e.preventDefault();
    };

    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}ManageRoom/setrates`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data === "set rates done") {
                    console.log(response);
                    console.log("success");
                    alert("Room Rate set successfully");
                } else {
                    alert("please fill correct data");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Set Rates Here</h2>
                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label htmlFor="type">Room Type</label>
                        <Input
                            type="text"
                            placeholder="Enter type here"
                            name="type"
                            id="type"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, type: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="capacity">Capacity </label>
                        <Input
                            type="text"
                            placeholder="Enter capacity here"
                            name="capacity"
                            id="capacity"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, capacity: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="check_in_time">Check In Time </label>
                        <Input
                            type="text"
                            placeholder="Enter here"
                            name="check_in_time"
                            id="check_in_time"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, check_in_time: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="check_out_time">Check out Time </label>
                        <Input
                            type="text"
                            placeholder="Enter here"
                            name="check_out_time"
                            id="check_out_time"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, check_out_time: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="first_night_rate">First Night Rates </label>
                        <Input
                            type="number"
                            placeholder="Enter rates here"
                            name="first_night_rate"
                            id="first_night_rate"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, first_night_rate: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="extension_rate">Extension Rates </label>
                        <Input
                            type="number"
                            placeholder="Enter rates here"
                            name="extension_rate"
                            id="extension_rate"
                            onChange={(e) => {
                                setRoomRates({ ...roomRates, extension_rate: e.target.value });
                            }} />
                    </FormGroup>

                    <Container className="text-center ">
                        <Button type="submit" color="success" className="bt">Submit</Button>
                        <Button type="reset" color="dark " className="bt" style={{ margin: 8 }}>clear</Button>
                    </Container>
                </Form>
            </div>
        </div>
    )
}

export default SetRates;