import { Link } from "react-router-dom";
import Header from "../../../pages/Header";
import React, { useState, useEffect } from "react";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle,
} from "reactstrap";
import axios from "axios";
import base_url from "../../../api/bootapi";
import { useParams } from 'react-router-dom';

const SearchRoomNoResult = () => {
    useEffect(() => {
        document.title = "Searched Room";
    }, []);

    useEffect(() => {
        getdata();
    }, []);

    var url = useParams();

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
                } else {
                    alert("Invalid Room No");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [room, setRoom] = useState({});

    // for deleting data from server by delete button
    const deleteRoom = (roomno) => {
        axios.delete(`${base_url}ManageRoom/deleteroom/${roomno}`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                if (response.data === "Successfully deleted") {
                    alert("Successfully deleted");

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
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Room Result</h2>
            <br></br>
            <div className="div2">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>{room.roomno}</CardSubtitle>
                        <br></br>
                        <CardText>Type : {room.type}</CardText>
                        <CardText>Capacity : {room.capacity}</CardText>
                        <CardText>Status : {room.status}</CardText>
                        <CardText>Check_in Time : {room.check_in_time} </CardText>
                        <CardText>Check_out Time : {room.check_out_time}</CardText>
                        <CardText>First Night Rate : {room.first_night_rate}</CardText>
                        <CardText>Extension Rate : {room.extension_rate}</CardText>
                        <CardText>Booked Till : {room.bookedtill}</CardText>

                        <Container className="text-center">
                            <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}><Link className="list-group-item list-group-item-action" tag="a" to={"/manager/viewroombyroomno/result/update/" + room.roomno}>Update</Link></Button>
                            <Button className="mx-2 bt btdelete" style={{ color: "white" }} onClick={() => { deleteRoom(room.roomno); }}>Delete</Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}
export default SearchRoomNoResult;