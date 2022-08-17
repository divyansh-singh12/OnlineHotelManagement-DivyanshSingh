import React, { useEffect, useState } from "react";
import Header from '../../pages/Header';
import { Link } from "react-router-dom";
import {
    Button, Container, Card,
    CardBody,
    CardText,
    CardSubtitle
} from "reactstrap";
import axios from "axios";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';

const ViewDepartmentResult = () => {
    useEffect(() => {
        document.title = "Searched Department";
    }, []);

    useEffect(() => {
        getdata();
    }, []);

    var name = useParams();

    const getdata = () => {
        axios.get(`${base_url}ManageDepartment/viewdepartment/${name.name}`, {
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
                    setDepartment(response.data);
                } else {
                    alert("Invalid Department Name");
                }
            }, (error) => {
                console.log(error);
                console.log("error");
            }
        )
    }
    const [department, setDepartment] = useState({});

    // for deleting data from server by delete button
    const deleteDepartment = (id) => {
        axios.delete(`${base_url}ManageDepartment/deletedepartment/${id}`, {
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

                    window.open("http://localhost:3000/owner", "_top");
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
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Department Result</h2>
            <br></br>
            <div className="div2">
                <Card className="text-center bg-transparent text-dark">
                    <CardBody className="form">
                        <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>{department.name}</CardSubtitle>
                        <br></br>
                        <CardText>Department Id : {department.id}</CardText>
                        <CardText>Department HOD : {department.hodName}</CardText>
                        <CardText>HOD Phone No. : {department.hodPhoneNo}</CardText>
                        <CardText>Department Size : {department.sizeOfDepartment}</CardText>

                        <Container className="text-center">
                            <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }}><Link className="list-group-item list-group-item-action" tag="a" to={"/owner/viewdepartmentbyName/result/update/" + department.name}>Update</Link></Button>
                            <Button className="mx-2 bt btdelete" style={{ color: "white" }} onClick={() => { deleteDepartment(department.id); }}>Delete</Button>
                        </Container>
                    </CardBody>
                </Card>
            </div>
        </div>
    )
}

export default ViewDepartmentResult;