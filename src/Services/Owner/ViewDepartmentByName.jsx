import React, { useEffect } from "react";
import Header from '../../pages/Header';
import { Button, Container, Form, FormGroup, Input } from "reactstrap";

const ViewDepartmentByName = () => {
    useEffect(() => {
        document.title = "Search Department";
    }, []);
    const handleForm = (e) => {
        console.log(name);
        let a = 'http://localhost:3000/owner/viewdepartmentbyName/result/';
        let b = a + name;
        window.open(b, "_top");
        e.preventDefault();
    }
    var name = "";
    return (
        <div>
            < Header />

            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View Department By Name</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form onSubmit={handleForm} className="form" style={{ width: "70%" }}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " htmlFor="departmentId">Enter Department Name</label>
                        <Input
                            type="text"
                            placeholder="Enter Name here"
                            name="departmentName"
                            id="departmentName"
                            onChange={(e) => {
                                name = e.target.value;
                            }}
                        />

                    </FormGroup>
                    <Container className="text-center my-4">
                        <Button type="submit" color="success bt">Search</Button>
                    </Container>
                </Form>
            </Container>
        </div>
    )
}

export default ViewDepartmentByName;