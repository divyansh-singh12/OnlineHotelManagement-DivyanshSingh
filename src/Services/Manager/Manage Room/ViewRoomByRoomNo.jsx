import React, { useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../../pages/Header";

const ViewRoomByRoomNo = () => {
    useEffect(() => {
        document.title = "Search Room Data";
    }, []);
    const handleForm = (e) => {
        console.log(roomno);
        let a = 'http://localhost:3000/manager/viewroombyroomno/result/';
        let b = a + roomno;
        window.open(b, "_top");
        e.preventDefault();
    }
    let roomno;
    return (
        <div>
            <Header />
            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View Room by Room Number</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" style={{ width: "70%" }} onSubmit={handleForm}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2" for="roomno">Enter Room No</label>
                        <Input
                            type="number"
                            placeholder="Enter here"
                            name="roomno"
                            id="roomno"
                            onChange={(e) => {
                                roomno = e.target.value;
                            }}
                        />

                    </FormGroup>

                    <Container className="text-center my-4 ">
                        <Button type="submit" color="success bt">
                            Search
                        </Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default ViewRoomByRoomNo;