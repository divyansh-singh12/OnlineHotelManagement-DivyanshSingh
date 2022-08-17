import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import axios from "axios";
import base_url from "../api/bootapi";


const Login = () => {
    useEffect(() => {
        document.title = "Login";
    }, []);

    const [loginData, setLoginData] = useState({});
    const [jwtData] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(loginData);
        sendDataToServer(loginData);
        e.preventDefault();
    };


    // function to post data on backend
    const sendDataToServer = (data) => {
        axios.post(`${base_url}ManageLogin/authenticate`, data, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data.jwt != null) {
                    // alert("jwt created successfully");
                    jwtData.jwt = response.data.jwt;
                    axios.get(`${base_url}ManageLogin/login`, {
                        headers: {
                            "Access-Control-Allow-Headers": "Content-Type",
                            "Access-Control-Allow-Methods": "*",
                            "Authorization": `Bearer ${response.data.jwt}`
                        }
                    }
                    ).then(
                        (response) => {
                            console.log(response);
                            console.log("success");
                            var role = response.data;
                            console.log(role);
                            if (role === "ROLE_OWNER") {
                                axios.post(`${base_url}ManageJwt/addjwt`, { "id": 1, "jwt": `${jwtData.jwt}` }, {
                                    headers: {
                                        "Access-Control-Allow-Headers": "Content-Type",
                                        "Access-Control-Allow-Methods": "*"
                                    }
                                }).then(
                                    (response) => {
                                        //success
                                        console.log(response.data);
                                    },
                                    (error) => {
                                        console.log(error);
                                    })
                                window.open("http://localhost:3000/owner", "_top");

                            }
                            else if (role === "ROLE_MANAGER") {
                                window.open("http://localhost:3000/manager", "_top");
                            }
                            else if (role === "ROLE_RECEPTIONIST") {
                                window.open("http://localhost:3000/receptionist", "_top");
                            }
                            else {
                                window.open("http://localhost:3000", "_top");
                            }


                        }, (error) => {
                            console.log(error);
                            console.log("error");
                        }
                    )

                } else {
                    alert("Please fill in the correct data");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    };

    return (
        <div >
            <div style={{ width: "100%", height: "720px", backgroundColor: "#99E2EB" }}>

                <br></br>
                <br></br>
                <br></br>
                <div className="card bgimage" style={{ margin: "0px auto", width: "35%", padding: "90px", boxShadow: "0px 0px 10px 0px grey", borderRadius: "10px" }}>
                    <h1 className="text-center">Hotel Management</h1>
                    <h1 className="text-center">Login</h1>
                    <Form onSubmit={handleForm} style={{ width: "90%", margin: "0px auto" }}>
                        <FormGroup>
                            <label for="username">Username</label>
                            <Input
                                type="email"
                                placeholder="Enter email here"
                                name="username"
                                id="username"
                                onChange={(e) => {
                                    setLoginData({ ...loginData, username: e.target.value });
                                }}
                            //style={{width: 400}}
                            />
                        </FormGroup>
                        <FormGroup>
                            <label for="password">Password </label>
                            <Input
                                type="password"
                                placeholder="Enter here"
                                name="password"
                                id="password"
                                onChange={(e) => {
                                    setLoginData({ ...loginData, password: e.target.value });
                                }}
                            />
                        </FormGroup>


                        <Container className="text-center my-5" >

                            <Button type="submit" className="col-4" style={{ color: "white", backgroundColor: "#6c6c6c" }}>Login</Button>


                            <Button type="reset" style={{ color: "white", backgroundColor: "#000000" }} className="mx-3 col-4">Reset</Button>
                        </Container>
                        <br></br>
                    </Form>
                </div>
            </div>
        </div>

    )
}

export default Login;