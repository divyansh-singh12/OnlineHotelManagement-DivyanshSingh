import React, { useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../../pages/Header";

const ViewStaffByCode = () => {
    useEffect(() => {
        document.title = "Search Staff Data";
    }, []);
    const handleForm = (e) => {
        console.log(code);
        let a = 'http://localhost:3000/manager/viewstaffbycode/result/';
        let b = a + code;
        window.open(b, "_top");
        e.preventDefault();
    }
    var code;
    return (
        <div>
            <Header />

            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View Staff By Code</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" style={{ width: "70%" }} onSubmit={handleForm}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " for="staffId">Enter Staff code</label>
                        <Input
                            type="number"
                            placeholder="Enter code here"
                            name="staffId"
                            id="staffId"
                            onChange={(e) => {
                                code = e.target.value;
                            }}
                        />

                    </FormGroup>

                    <Container className="text-center my-4">
                        <Button type="submit" color="success bt">
                            Search
                        </Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default ViewStaffByCode;