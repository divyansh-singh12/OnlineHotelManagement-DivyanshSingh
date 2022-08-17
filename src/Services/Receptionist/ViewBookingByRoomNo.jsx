import React, { useEffect } from "react";
import {
    Button, Container, Form, FormGroup, Input
} from "reactstrap";
import Header from '../../pages/Header';
const ViewBookingByRoomNo = () => {
    useEffect(() => {
        document.title = "View Booking";
    }, []);
    const handleForm = (e) => {
        console.log(roomno);
        let a = 'http://localhost:3000/receptionist/viewbookings/result/';
        let b = a + roomno;
        window.open(b, "_top");
        e.preventDefault();
    }
    var roomno = "";
    return (
        <div>
            < Header />
            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View All Bookings of Roomno</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form onSubmit={handleForm} className="form" style={{ width: "70%" }}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " htmlFor="departmentId">Enter Room No.</label>
                        <Input
                            type="Number"
                            placeholder="Enter Room No. here"
                            name="roomno"
                            id="roomno"
                            onChange={(e) => {
                                roomno = e.target.value;
                            }}
                        />

                    </FormGroup>
                    <Container className="text-center">
                        <Button type="submit" color="success bt">Search</Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default ViewBookingByRoomNo;