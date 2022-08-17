import { Link } from "react-router-dom";
import React from "react";
import {
    Card,
    CardBody,
    CardText,
    CardSubtitle,
    Button,
    Container,
} from "reactstrap";

const AvailableRooms = ({ availableRooms }) => {
    //  const [room, setRoom] = useState({});
    return (
        <div className="div2">
            <Card className="text-center bg-transparent text-dark">
                <CardBody className="form">
                    <CardSubtitle className="fw-bold form" style={{ backgroundColor: "#2FC8D7" }}>ROOM NO: {availableRooms.roomno}</CardSubtitle>
                    <br></br>
                    <CardText>Type : {availableRooms.type}</CardText>
                    <CardText>Capacity : {availableRooms.capacity}</CardText>
                    <CardText>Status : {availableRooms.status}</CardText>
                    <CardText>Check_in Time : {availableRooms.check_in_time} </CardText>
                    <CardText>Check_out Time : {availableRooms.check_out_time}</CardText>
                    <CardText>First Night Rate : {availableRooms.first_night_rate}</CardText>
                    <CardText>Extension Rate : {availableRooms.extension_rate}</CardText>
                    <CardText>Booked Till : {availableRooms.bookedtill}</CardText>

                    <Container className="text-center">
                        <Button color="success" className="bt">
                            <Link className="list-group-item list-group-item-action" tag="a" to={"/receptionist/searchroom/result/reservation/" + availableRooms.roomno}>Book Room</Link>
                        </Button>
                    </Container>
                </CardBody>
            </Card>
        </div>
    )
};

export default AvailableRooms;