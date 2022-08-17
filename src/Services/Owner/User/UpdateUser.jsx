import React, { useEffect, useState } from "react";
import Header from "../../../pages/Header";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import axios from "axios";




const UpdateUser = () => {
    useEffect(() => {
        document.title = "Update User";
    }, []);
    function getJwt() {
        axios.get(`${base_url}ManageJwt/getjwt`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data != null) {
                    // console.log(response.data);
                    //console.log("success");
                    jwt = response.data;
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    };

    const [user, setUser] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(user);
        putDataToServer(user);
        e.preventDefault();
    };
    var jwt;
    getJwt();
    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}owner/ManageUser/updateuser`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*",
                "Authorization": `Bearer ${jwt}`
            }
        }).then(
            (response) => {
                if (response.data.username != null) {
                    console.log(response);
                    console.log("success");
                    alert("User update successfully");
                } else {
                    alert("please fill correct data");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
                alert("Access Denied");
            }
        )
    };
    return (
        <div>
            < Header />
            <div className="div2">
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Fill Updated User Details</h2>
                <Form className="form" onSubmit={handleForm}>
                    <FormGroup>
                        <label for="userName">Name</label>
                        <Input
                            type="text"
                            placeholder="Enter Name here"
                            name="userName"
                            id="userName"
                            onChange={(e) => {
                                setUser({ ...user, name: e.target.value });
                            }}
                        //style={{width: 400}}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label for="username">User Name </label>
                        <Input
                            type="email"
                            placeholder="Enter email here"
                            name="username"
                            id="username"
                            onChange={(e) => {
                                setUser({ ...user, username: e.target.value });
                            }} />
                    </FormGroup>
                    <FormGroup>
                        <label for="userPassword">Password </label>
                        <Input
                            type="password"
                            placeholder="Enter Password here"
                            name="userPassword"
                            id="userPassword"
                            onChange={(e) => {
                                setUser({ ...user, password: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label for="userRole">User Role</label>
                        <Input
                            type="text"
                            placeholder="Enter Role here"
                            name="userRole"
                            id="userRole"
                            onChange={(e) => {
                                setUser({ ...user, role: e.target.value });
                            }} />
                    </FormGroup>
                    <Container className="text-center">
                        <Button type="submit" color="success" className="bt">Submit</Button>
                        <Button type="reset" color="dark " className="bt" style={{ margin: 8 }}>clear</Button>
                    </Container>
                </Form>
            </div>
        </div>
    );
};

export default UpdateUser;