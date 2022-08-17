import React from "react";
import { Button, Card, CardBody, CardText, CardTitle } from "reactstrap";
import Header from "../../pages/Header";
import base_url from "../../api/bootapi";

const RetrieveReport = () => {
    const staffReport = () => {
        window.open(`${base_url}RetrieveReport/generatestaffreport`)
    }
    const incomeReport = () => {
        window.open(`${base_url}RetrieveReport/generateincomereport`)
    }
    return (
        <div>
            <Header />
            <div className="div2 my-5 " >
                <Card className="text-center bg-transparent text-dark" style={{ height: "300px" }}>

                    <CardBody className="form">
                        <br></br>
                        <br></br>
                        <CardTitle tag="h5" className="display-5">
                            Download Report From Here
                        </CardTitle>
                        <CardText className="display-7">
                            Please Choose the report Type

                        </CardText>

                        <br></br>
                        <Button className="bt" style={{ color: "white", backgroundColor: "#003333", margin: 15 }} onClick={() => { staffReport() }}>Staff Report</Button>
                        <Button className="bt" style={{ color: "white", backgroundColor: "#003333" }} onClick={() => { incomeReport() }}>Income Report</Button>
                    </CardBody>
                </Card>
            </div>
        </div>
    )


};

export default RetrieveReport;