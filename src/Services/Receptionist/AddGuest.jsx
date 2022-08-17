import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../api/bootapi";
import Header from "../../pages/Header";

const AddGuest = () => {
    useEffect(() => {
        document.title = "Add Guest";
    }, []);

    const [guest, setguest] = useState({});
    const [address, setAddress] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(guest);
        guest.address = address;
        postDataToServer(guest);
        e.preventDefault();
    };

    // function to post data on backend
    const postDataToServer = (data) => {
        axios.post(`${base_url}ManageGuest/addguest`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.id != null) {
                    console.log(response);
                    console.log("success");
                    alert("Guest Details added successfully");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Guest Details</h2>
                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label for="guestId">Guest Id</label>
                        <Input
                            type="number"
                            placeholder="Enter Id here"
                            name="guestId"
                            id="guestId"
                            onChange={(e) => {
                                setguest({ ...guest, id: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label for="firstName">First Name </label>
                        <Input
                            type="text"
                            placeholder="Enter First Name here"
                            name="firstName"
                            id="firstName"
                            onChange={(e) => {
                                setguest({ ...guest, firstName: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="lastName">Last Name </label>
                        <Input
                            type="text"
                            placeholder="Enter last Name here"
                            name="lastName"
                            id="lastName"
                            onChange={(e) => {
                                setguest({ ...guest, lastName: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="phoneNumber">Phone No</label>
                        <Input
                            type="tel"
                            placeholder="Enter Salary here"
                            name="phoneNumber"
                            id="phoneNumbery"
                            onChange={(e) => {
                                setguest({ ...guest, phoneNumber: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="company">Company </label>
                        <Input
                            type="text"
                            placeholder="Enter company here"
                            name="company"
                            id="company"
                            onChange={(e) => {
                                setguest({ ...guest, company: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="guestEmail">Email </label>
                        <Input
                            type="email"
                            placeholder="Enter email here"
                            name="guestEmail"
                            id="guestEmail"
                            onChange={(e) => {
                                setguest({ ...guest, email: e.target.value });
                            }} />
                    </FormGroup>

                    <FormGroup>
                        <label for="gender">Gender </label>
                        <Input
                            type="text"
                            placeholder="Enter Gender here"
                            name="gender"
                            id="gender"
                            onChange={(e) => {
                                setguest({ ...guest, gender: e.target.value });
                            }} />
                    </FormGroup>


                    <br></br>

                    <h5 >Address </h5>

                    <FormGroup>
                        <label for="addressId">Address Id </label>
                        <Input
                            type="number"
                            placeholder="enter here"
                            name="addressId"
                            id="addressId"
                            onChange={(e) => {
                                setAddress({ ...address, id: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="streetName">StreetName </label>
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
                        <label for="houseNo">House No </label>
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
                        <label for="city">City </label>
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
                        <label for="country">Country </label>
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
                        <label for="pincode">Pincode </label>
                        <Input
                            type="number"
                            placeholder="enter here"
                            name="pincode"
                            id="pincode"
                            onChange={(e) => {
                                setAddress({ ...address, pincode: e.target.value });
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
export default AddGuest;