import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import { useParams } from 'react-router-dom';
import Header from "../../../pages/Header";
const UpdateStaff = () => {
    useEffect(() => {
        document.title = "Update Staff";
    }, []);

    useEffect(() => {
        getdata(val.code);
    }, []);
    var val = useParams();
    console.log(val.code);
    const getdata = (cc) => {
        axios.get(`${base_url}ManageStaff/viewstaff/${cc}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.code != null) {
                    console.log(response.data);
                    setStaff(response.data);
                    setAddress(response.data.address);
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [staff, setStaff] = useState({});
    const [address, setAddress] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(staff);
        staff.address = address;
        putDataToServer(staff);
        e.preventDefault();
    };

    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}ManageStaff/updatestaff`, data, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.code != null) {
                    console.log(response);
                    console.log("success");
                    alert("Staff Data updated successfully");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Update Staff Details</h2>
                <Form onSubmit={handleForm} className="form">
                    <FormGroup>
                        <label htmlFor="staffId">Code</label>
                        <Input
                            type="number"
                            defaultValue={staff.code}
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
                            defaultValue={staff.firstname}
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
                            defaultValue={staff.lastname}
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
                            defaultValue={staff.salary}
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
                            defaultValue={staff.joinedon}
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
                            defaultValue={staff.age}
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
                            defaultValue={staff.occupation}
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
                            defaultValue={staff.email}
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
                        <Button type={"reset"} color="dark " style={{ margin: 8 }} onClick={() => { getdata(val.code) }}>Reset</Button>
                    </Container>
                </Form>
            </div>
        </div>
    );
};

export default UpdateStaff;