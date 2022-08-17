import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../api/bootapi";
import Header from '../../pages/Header';

const AddDepartment = () => {
    useEffect(() => {
        document.title = "Add Department";
    }, []);

    const [department, setDepartment] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(department);
        postDataToServer(department);
        e.preventDefault();
    };

    // function to post data on backend
    const postDataToServer = (data) => {
        axios.post(`${base_url}ManageDepartment/adddepartment`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.id != null) {
                    console.log(response);
                    console.log("success");
                    alert("Department added successfully");
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
        <div >
            < Header />

            <div className="div2">
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Department Details</h2>

                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label htmlFor="departmentId">Department Id</label>
                        <Input
                            type="number"
                            placeholder="Enter Id here"
                            name="departmentId"
                            id="departmentId"
                            onChange={(e) => {
                                setDepartment({ ...department, id: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="departmentName">Department Name </label>
                        <Input
                            type="text"
                            placeholder="Enter Name here"
                            name="departmentName"
                            id="departmentName"
                            onChange={(e) => {
                                setDepartment({ ...department, name: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="departmentSize">Department Size </label>
                        <Input
                            type="number"
                            placeholder="Enter Size here"
                            name="departmentSize"
                            id="departmentSize"
                            onChange={(e) => {
                                setDepartment({ ...department, sizeOfDepartment: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="hodName">HOD Name</label>
                        <Input
                            type="text"
                            placeholder="Enter Hod Name here"
                            name="hodName"
                            id="hodName"
                            onChange={(e) => {
                                setDepartment({ ...department, hodName: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="hodPhoneNo">HOD Phone No</label>
                        <Input
                            type="tel"
                            placeholder="Enter Phone here"
                            name="hodPhoneNo"
                            id="hodPhoneNo"
                            onChange={(e) => {
                                setDepartment({ ...department, hodPhoneNo: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <Container className="text-center">
                        <Button type="submit" color="success" className="bt">Submit</Button>
                        <Button type="reset" color="dark" className="bt" style={{ margin: 8 }}>clear</Button>
                    </Container>
                </Form>
            </div>

        </div>
    );
};

export default AddDepartment;