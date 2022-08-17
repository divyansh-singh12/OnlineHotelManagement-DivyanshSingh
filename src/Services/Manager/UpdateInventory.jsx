import axios from "axios";
import React, { useState, useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';
import Header from "../../pages/Header";

const UpdateInventory = () => {
    useEffect(() => {
        document.title = "Update Inventory";
    }, []);

    useEffect(() => {
        getdata();
    }, []);
    var name = useParams();
    console.log(name.name);
    const getdata = () => {
        axios.get(`${base_url}ManageInventory/viewinventory/${name.name}`, {
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
                    setinventory(response.data);
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [inventory, setinventory] = useState({});

    // form handler function
    const handleForm = (e) => {
        console.log(inventory);
        putDataToServer(inventory);
        e.preventDefault();
    };

    // function to post data on backend
    const putDataToServer = (data) => {
        axios.put(`${base_url}ManageInventory/updateinventory`, data, {
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
                    alert("Inventory updated successfully");
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
                <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Update Inventory Details</h2>
                <Form onSubmit={handleForm} className="form">
                    <FormGroup>
                        <label htmlFor="inventoryId">Inventory Id</label>
                        <Input
                            type="number"
                            defaultValue={inventory.id}
                            name="inventoryId"
                            id="inventoryId"
                            onChange={(e) => {
                                setinventory({ ...inventory, id: e.target.value });
                            }}

                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="itemName">Item Name </label>
                        <Input
                            type="text"
                            defaultValue={inventory.itemname}
                            name="itemName"
                            id="itemName"
                            onChange={(e) => {
                                setinventory({ ...inventory, itemname: e.target.value });
                            }}
                        />
                    </FormGroup>
                    <FormGroup>
                        <label htmlFor="itemQuantity">Quantity </label>
                        <Input
                            type="number"
                            defaultValue={inventory.quantity}
                            name="itemQuantity"
                            id="itemQuantity"
                            onChange={(e) => {
                                setinventory({ ...inventory, quantity: e.target.value });
                            }} />
                    </FormGroup>

                    <Container className="text-center">
                        <Button type="submit" color="success">Submit</Button>
                        <Button type={"reset"} color="dark " style={{ margin: 8 }} onClick={() => { getdata() }}>Reset</Button>
                    </Container>
                </Form>

            </div>
        </div>
    );
};

export default UpdateInventory;