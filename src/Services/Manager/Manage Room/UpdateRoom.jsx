import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import { useParams } from 'react-router-dom';
import Header from "../../../pages/Header";

const UpdateRoom = () => {
    useEffect(() => {
        document.title = "Update Room";
    }, []);

    useEffect(() => {
        getdata();
    }, []);
    var url = useParams();
    console.log(url.roomno);
    const getdata = () => {
        axios.get(`${base_url}ManageRoom/viewroom/${url.roomno}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.roomno != null) {
                    console.log(response.data);
                    setRoom(response.data);
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [room, setRoom] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(room);
        putDataToServer(room);
        e.preventDefault();
    };

    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}ManageRoom/updateroom`, data, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.roomno != null) {
                    console.log(response);
                    console.log("success");
                    alert("Room updated successfully");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Update Room Details</h2>
                <Form onSubmit={handleForm} className="form">
                    <FormGroup>
                        <label htmlFor="roomno">Room No</label>
                        <Input
                            type="number"
                            defaultValue={room.roomno}
                            name="roomno"
                            id="roomno"
                            onChange={(e) => {
                                setRoom({ ...room, roomno: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="type">Room Type-(Standard/Luxury) </label>
                        <Input
                            type="text"
                            defaultValue={room.type}
                            name="type"
                            id="type"
                            onChange={(e) => {
                                setRoom({ ...room, type: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="capacity">Capacity </label>
                        <Input
                            type="text"
                            defaultValue={room.capacity}
                            name="capacity"
                            id="capacity"
                            onChange={(e) => {
                                setRoom({ ...room, capacity: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="status">Room Status-(Available/Under Maintenance) </label>
                        <Input
                            type="text"
                            defaultValue={room.status}
                            name="status"
                            id="status"
                            onChange={(e) => {
                                setRoom({ ...room, status: e.target.value });
                            }}
                        />
                    </FormGroup>

                    <Container className="text-center">
                        <Button type="submit" color="success">Submit</Button>
                        <Button type="reset" color="dark " style={{ margin: 8 }} onClick={() => { getdata() }} >Reset</Button>
                    </Container>
                </Form>
            </div>

        </div >
    );
};

export default UpdateRoom;