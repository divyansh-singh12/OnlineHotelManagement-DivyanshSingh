import { Link } from "react-router-dom";
import Header from "../../pages/Header";
import React, { useState, useEffect } from "react";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";
import axios from "axios";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';

const ViewInventoryResult = () => {
    useEffect(() => {
        document.title = "Searched Inventory";
    }, []);

    useEffect(() => {
        getdata();
    }, []);

    var name = useParams();

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
                    setInventory(response.data);
                } else {
                    alert("Invalid Inventory Name");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
                alert("Invalid Inventory Name");
            }
        )
    }
    const [inventory, setInventory] = useState({});

    // for deleting data from server by delete button
    const deleteInventory = (id) => {
        axios.delete(`${base_url}ManageInventory/deleteinventory/${id}`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                if (response.data === "Successfully deleted") {
                    alert("Successfully deleted");

                    window.open("http://localhost:3000/manager", "_top");
                }
            },
            (error) => {
                console.log(error);
            }
        );
    };

    return (
        <div>
            < Header />
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Inventory Result</h2>
            <br></br>
            <div className="div2">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>{inventory.itemname}</CardSubtitle>
                        <br></br>
                        <CardText>Inventory Id : {inventory.id}</CardText>
                        <CardText>Quantity : {inventory.quantity}</CardText>

                        <Container className="text-center">
                            <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}><Link className="list-group-item list-group-item-action" tag="a" to={"/manager/viewinventorybyName/result/update/" + inventory.itemname}>Update</Link></Button>
                            <Button className="mx-2 bt btdelete" style={{ color: "white" }} onClick={() => { deleteInventory(inventory.id); }}>Delete</Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}

export default ViewInventoryResult;