import React, { useEffect } from "react";
import Header from "../../../pages/Header";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../../api/bootapi";
import axios from "axios";

const DeleteUser = () => {
    useEffect(() => {
        document.title = "Delete User";
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

    var username;

    // form handler function
    const handleForm = (e) => {
        console.log(username);
        deleteUser(username);
        e.preventDefault();
    };
    var jwt;
    getJwt();
    // function to post data on backend
    const deleteUser = (data) => {
        axios.delete(`${base_url}owner/ManageUser/deleteuser/${data}`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*",
                "Authorization": `Bearer ${jwt}`
            }
        }).then(
            (response) => {
                if (response.data === "Successfully deleted") {
                    console.log(response);
                    console.log("success");
                    alert("User Deleted Successfully");
                } else {
                    alert("Can't Delete");
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

            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Delete User</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form className="form" onSubmit={handleForm} style={{ width: "70%" }}>
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2" for="username">Enter Username/Email</label>
                        <Input
                            type="email"
                            placeholder="Enter here"
                            name="username"
                            id="username"
                            onChange={(e) => {
                                username = e.target.value;
                            }}
                        />

                    </FormGroup>

                    <Container className="text-center my-3">
                        <Button type="submit" className="mx-2 bt btdelete" style={{ color: "white" }}>Delete</Button>
                    </Container>
                </Form>
            </Container>
        </div>

    )

}

export default DeleteUser;