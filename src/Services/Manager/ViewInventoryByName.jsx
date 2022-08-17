import React, { useEffect } from "react";
import { Button, Container, Form, FormGroup, Input } from "reactstrap";
import Header from "../../pages/Header";

const ViewInventoryByName = () => {
    useEffect(() => {
        document.title = "Search Inventory";
    }, []);
    const handleForm = (e) => {
        console.log(name);
        let a = 'http://localhost:3000/manager/viewinventorybyname/result/';
        let b = a + name;
        window.open(b, "_top");
        e.preventDefault();
    }
    var name = "";
    return (
        <div >
            <Header />

            <h2 className="text-center my-5" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>View Inventory By Name</h2>
            <Container style={{ paddingLeft: "300px" }}>
                <Form onSubmit={handleForm} className="form" style={{ width: "70%" }} >
                    <FormGroup>
                        <label style={{ fontWeight: "bold" }} className="my-2 " for="itemName">Enter Inventory Name</label>
                        <Input
                            type="text"
                            placeholder="Enter Name here"
                            name="itemName"
                            id="itemName"
                            onChange={(e) => {
                                name = e.target.value;
                            }}
                        />

                    </FormGroup>


                    <Container className="text-center my-4">
                        <Button type="submit" color="success bt">Search</Button>
                    </Container>
                </Form>
            </Container>

        </div>
    )
}
export default ViewInventoryByName;