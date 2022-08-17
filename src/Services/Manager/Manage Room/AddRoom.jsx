import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import Header from "../../../pages/Header";

const AddRoom = () => {
    useEffect(() => {
        document.title = "Add Room";
    }, []);

    const [room, setroom] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(room);
        postDataToServer(room);
        e.preventDefault();
    };

    // function to post data on backend
    const postDataToServer = (data) => {
        axios.post(`${base_url}ManageRoom/addroom`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.roomno != null) {
                    console.log(response);
                    console.log("success");
                    alert("Room added successfully");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Room Details</h2>
                <Form onSubmit={handleForm} className="form">
                    <FormGroup>
                        <label htmlFor="roomno">Room No</label>
                        <Input
                            type="number"
                            placeholder="Enter number here"
                            name="roomno"
                            id="roomno"
                            onChange={(e) => {
                                setroom({ ...room, roomno: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="type">Room Type-(Standard/Luxury) </label>
                        <Input
                            type="text"
                            placeholder="Enter type here"
                            name="type"
                            id="type"
                            onChange={(e) => {
                                setroom({ ...room, type: e.target.value });
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
                                setroom({ ...room, capacity: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="status">Room Status-(Available/Under Maintenance) </label>
                        <Input
                            type="text"
                            placeholder="Enter status here"
                            name="status"
                            id="status"
                            onChange={(e) => {
                                setroom({ ...room, status: e.target.value });
                            }}
                        />
                    </FormGroup>

                    <Container className="text-center">
                        <Button type="submit" color="success" className="bt">Submit</Button>
                        <Button type="reset" color="dark " className="bt" style={{ margin: 8 }}>clear</Button>
                    </Container>
                </Form>
            </div>
        </div>
    )
}

export default AddRoom;