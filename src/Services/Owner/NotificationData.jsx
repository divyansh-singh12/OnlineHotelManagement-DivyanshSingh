import React from "react";
import {
    Card,
    CardBody,
    CardSubtitle
} from "reactstrap";
import { TbCircleDot } from "react-icons/tb";


const NotificationData = ({ notification }) => {

    return (
        <div>
            <Card className="bg-transparent text-dark">
                <CardBody>
                    <CardSubtitle className="fw-bold"><TbCircleDot />&nbsp; {notification}</CardSubtitle>
                </CardBody>
            </Card>
        </div>
    );

};

export default NotificationData;