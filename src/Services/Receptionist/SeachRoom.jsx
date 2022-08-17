import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../pages/Header";

const SearchRoom = () => {
    useEffect(() => {
        document.title = "Search Rooms";
    }, []);
    const [room, setroom] = useState({});
    return (
        <div>
            <Header />
            <br></br>
            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Search Room</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" style={{ width: "70%" }}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2" htmlFor="roomType">Room Type</label>
                        <Input
                            type="text"
                            placeholder="Enter type here"
                            name="roomType"
                            id="roomType"
                            onChange={(e) => {
                                setroom({ ...room, type: e.target.value });
                            }}
                        />

                    </FormGroup>
                    <FormGroup>
                        <label className="my-2" htmlFor="checkIn">Check in Date</label>
                        <Input
                            type="date"
                            placeholder="Enter date here"
                            name="checkIn"
                            id="checkIn"
                            onChange={(e) => {
                                setroom({ ...room, check_in: e.target.value });
                            }}
                        />

                    </FormGroup>
                    <FormGroup>
                        <label className="my-2" htmlFor="noOfGuest">No of Guest</label>
                        <Input
                            type="number"
                            placeholder="Enter type here"
                            name="noOfGuest"
                            id="noOfGuest"
                            onChange={(e) => {
                                setroom({ ...room, no_of_guest: e.target.value });
                            }}
                        />

                    </FormGroup>
                    <Container className="text-center my-4">
                        <Button color="success" className="bt" style={{ margin: 8 }}>
                            <Link className="list-group-item list-group-item-action" tag="a" to={`/receptionist/searchroom/result?type=${room.type}&checkin=${room.check_in}&noofguest=${room.no_of_guest}`}>Search</Link>
                        </Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default SearchRoom;