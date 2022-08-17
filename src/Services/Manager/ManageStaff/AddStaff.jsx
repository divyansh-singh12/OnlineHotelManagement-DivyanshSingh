import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import Header from "../../../pages/Header";

const AddStaff = () => {
    useEffect(() => {
        document.title = "Add Staff";
    }, []);

    const [staff, setStaff] = useState({});
    const [address, setAddress] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(staff);
        staff.address = address;
        postDataToServer(staff);
        e.preventDefault();
    };

    // function to post data on backend
    const postDataToServer = (data) => {
        axios.post(`${base_url}ManageStaff/addstaff`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.code != null) {
                    console.log(response);
                    console.log("success");
                    alert("staff added successfully");
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

                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Staff Details</h2>
                <Form onSubmit={handleForm} className="form">
                    <FormGroup>
                        <label htmlFor="staffId">Code</label>
                        <Input
                            type="number"
                            placeholder="Enter Id here"
                            name="staffId"
                            id="staffId"
                            onChange={(e) => {
                                setStaff({ ...staff, code: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="firstName">First Name </label>
                        <Input
                            type="text"
                            placeholder="Enter First Name here"
                            name="firstName"
                            id="firstName"
                            onChange={(e) => {
                                setStaff({ ...staff, firstname: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="lastName">Last Name </label>
                        <Input
                            type="text"
                            placeholder="Enter last Name here"
                            name="lastName"
                            id="lastName"
                            onChange={(e) => {
                                setStaff({ ...staff, lastname: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="staffSalary">Salary </label>
                        <Input
                            type="number"
                            placeholder="Enter Salary here"
                            name="staffSalary"
                            id="staffSalary"
                            onChange={(e) => {
                                setStaff({ ...staff, salary: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="joinedOn">Joining Date </label>
                        <Input
                            type="date"
                            placeholder="Enter date here"
                            name="joinedOn"
                            id="joinedOn"
                            onChange={(e) => {
                                setStaff({ ...staff, joinedon: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="staffAge">Age </label>
                        <Input
                            type="number"
                            placeholder="Enter Age here"
                            name="staffAge"
                            id="staffAge"
                            onChange={(e) => {
                                setStaff({ ...staff, age: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="staffOccupation">Occupation </label>
                        <Input
                            type="text"
                            placeholder="Enter occupation here"
                            name="staffOccupation"
                            id="staffOccupation"
                            onChange={(e) => {
                                setStaff({ ...staff, occupation: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="staffEmail">Email </label>
                        <Input
                            type="email"
                            placeholder="Enter email here"
                            name="staffEmail"
                            id="staffEmail"
                            onChange={(e) => {
                                setStaff({ ...staff, email: e.target.value });
                            }} />
                    </FormGroup>
                    <br></br>

                    <h5 >Address </h5>
                    <FormGroup>
                        <label htmlFor="streetName">Street Name </label>
                        <Input
                            type="text"
                            placeholder="enter here"
                            name="streetName"
                            id="streetName"
                            onChange={(e) => {
                                setAddress({ ...address, streetName: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="houseNo">House No </label>
                        <Input
                            type="text"
                            placeholder="enter here"
                            name="houseNo"
                            id="houseNo"
                            onChange={(e) => {
                                setAddress({ ...address, houseNo: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="city">City </label>
                        <Input
                            type="text"
                            placeholder="enter here"
                            name="city"
                            id="city"
                            onChange={(e) => {
                                setAddress({ ...address, city: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="state">State </label>
                        <Input
                            type="text"
                            placeholder="enter here"
                            name="state"
                            id="state"
                            onChange={(e) => {
                                setAddress({ ...address, state: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="country">Country </label>
                        <Input
                            type="text"
                            placeholder="enter here"
                            name="country"
                            id="country"
                            onChange={(e) => {
                                setAddress({ ...address, country: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="pincode">Pincode </label>
                        <Input
                            type="number"
                            placeholder="enter here"
                            name="pincode"
                            id="pincode"
                            onChange={(e) => {
                                setAddress({ ...address, pincode: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="addressId">Address Id </label>
                        <Input
                            type="number"
                            placeholder="enter here"
                            name="addressId"
                            id="addressId"
                            onChange={(e) => {
                                setAddress({ ...address, id: e.target.value });
                            }} />
                    </FormGroup>

                    <Container className="text-center">
                        <Button type="submit" color="success" className="bt">Submit</Button>
                        <Button type="reset" color="dark " className="bt" style={{ margin: 8 }}>clear</Button>
                    </Container>
                </Form>
            </div>
        </div>
    )
}

export default AddStaff;