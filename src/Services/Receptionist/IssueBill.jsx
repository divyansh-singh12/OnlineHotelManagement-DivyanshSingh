import React, { useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../pages/Header";

const IssueBill = () => {
    useEffect(() => {
        document.title = "Issue Bill";
    }, []);
    const handleForm = (e) => {
        console.log(roomno);
        let a = 'http://localhost:3000/receptionist/issuebill/result/';
        let b = a + roomno;
        window.open(b, "_top");
        e.preventDefault();
    }
    var roomno = "";
    return (
        <div>
            <Header />

            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Enter the Room No to Issue Bill</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" style={{ width: "70%" }} onSubmit={handleForm}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " for="departmentId">Enter Room No</label>
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

                    <Container className="text-center">
                        <Button type="submit" color="success" className="bt">
                            Generate Bill
                        </Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default IssueBill;