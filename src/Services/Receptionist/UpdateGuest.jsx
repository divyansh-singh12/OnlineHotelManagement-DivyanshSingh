import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';
import Header from "../../pages/Header";

const UpdateGuest = () => {
    useEffect(() => {
        document.title = "Update Guest";
    }, []);

    useEffect(() => {
        getdata(val.id);
    }, []);
    var val = useParams();
    console.log(val.id);
    const getdata = (cc) => {
        axios.get(`${base_url}ManageGuest/viewguest/id/${cc}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.id != null) {
                    console.log(response.data);
                    setGuest(response.data);
                    setAddress(response.data.address);
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [guest, setGuest] = useState({});
    const [address, setAddress] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(guest);
        guest.address = address;
        putDataToServer(guest);
        e.preventDefault();
    };

    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}ManageGuest/updateguest`, data, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.id != null) {
                    console.log(response);
                    console.log("success");
                    alert("Guest Data updated successfully");
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

                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Update Guest Details</h2>
                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label htmlFor="guestId">Guest Id</label>
                        <Input
                            type="number"
                            defaultValue={guest.id}
                            name="guestId"
                            id="guestId"
                            onChange={(e) => {
                                setGuest({ ...guest, id: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="firstName">First Name </label>
                        <Input
                            type="text"
                            defaultValue={guest.firstName}
                            name="firstName"
                            id="firstName"
                            onChange={(e) => {
                                setGuest({ ...guest, firstName: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="lastName">Last Name </label>
                        <Input
                            type="text"
                            defaultValue={guest.lastName}
                            name="lastName"
                            id="lastName"
                            onChange={(e) => {
                                setGuest({ ...guest, lastName: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="phoneNumber">Phone No</label>
                        <Input
                            type="tel"
                            defaultValue={guest.phoneNumber}
                            name="phoneNumber"
                            id="phoneNumbery"
                            onChange={(e) => {
                                setGuest({ ...guest, phoneNumber: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="company">Company </label>
                        <Input
                            type="text"
                            defaultValue={guest.company}
                            name="company"
                            id="company"
                            onChange={(e) => {
                                setGuest({ ...guest, company: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="guestEmail">Email </label>
                        <Input
                            type="email"
                            defaultValue={guest.email}
                            name="guestEmail"
                            id="guestEmail"
                            onChange={(e) => {
                                setGuest({ ...guest, email: e.target.value });
                            }} />
                    </FormGroup>

                    <FormGroup>
                        <label htmlFor="gender">Gender </label>
                        <Input
                            type="text"
                            defaultValue={guest.gender}
                            name="gender"
                            id="gender"
                            onChange={(e) => {
                                setGuest({ ...guest, gender: e.target.value });
                            }} />
                    </FormGroup>

                    <br></br>

                    <h5 >Address </h5>
                    <FormGroup>
                        <label htmlFor="streetName">Street Name </label>
                        <Input
                            type="text"
                            defaultValue={address.streetName}
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
                            defaultValue={address.houseNo}
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
                            defaultValue={address.city}
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
                            defaultValue={address.state}
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
                            defaultValue={address.country}
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
                            defaultValue={address.pincode}
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
                            defaultValue={address.id}
                            name="addressId"
                            id="addressId"
                            onChange={(e) => {
                                setAddress({ ...address, id: e.target.value });
                            }} />
                    </FormGroup>

                    <Container className="text-center">
                        <Button type="submit" color="success">Submit</Button>
                        <Button type={"reset"} color="dark " style={{ margin: 8 }} onClick={() => { getdata(val.id) }}>Reset</Button>
                    </Container>
                </Form>
            </div>
        </div>
    );
};

export default UpdateGuest;