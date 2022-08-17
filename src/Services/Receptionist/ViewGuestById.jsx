import React, { useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../pages/Header";

const ViewGuestById = () => {
    useEffect(() => {
        document.title = "Search Guest";
    }, []);
    const handleForm = (e) => {
        console.log(id);
        let a = 'http://localhost:3000/receptionist/viewguestbyid/result/';
        let b = a + id;
        window.open(b, "_top");
        e.preventDefault();
    }
    var id;
    return (
        <div>
            <Header />
            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View Guest By Id</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" style={{ width: "70%" }} onSubmit={handleForm}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " htmlFor="departmentId">Enter guest Id</label>
                        <Input
                            type="number"
                            placeholder="Enter Id here"
                            name="guestId"
                            id="guestId"
                            onChange={(e) => {
                                id = e.target.value;
                            }}
                        />

                    </FormGroup>
                    <Container className="text-center">
                        <Button type="submit" color="success bt" >
                            Search
                        </Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default ViewGuestById;