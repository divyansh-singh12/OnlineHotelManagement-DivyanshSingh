import React, { useState, useEffect } from "react";
import axios from "axios";
import base_url from "../../api/bootapi";
import { useParams } from 'react-router-dom';
import Bookings from "./Bookings";
import Header from "../../pages/Header";

const ViewBookingResult = () => {
    useEffect(() => {
        document.title = "All Bookings"
    }, []);

    var val = useParams().roomno;

    // function to call server
    const getAllBookingsFromServer = (val) => {
        axios.get(`${base_url}MakeReservation/viewbookings/${val}`, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                'Content-Type': 'application/json',
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                if (response.data != null) {
                    //success
                    console.log(response.data);
                    //toast("Data Fetched from Backend");
                    setBookings(response.data);
                } else {
                    alert("No Booking Found");
                    window.open("http://localhost:3000/receptionist/viewbookings", "_top");
                }

            },
            (error) => {
                //for errors
                console.log(error);
                // toast.error("Data can't be Fetched from Backend");
            }
        );
    };


    useEffect(() => {
        getAllBookingsFromServer(val);
    }, []);

    const [bookings, setBookings] = useState([]);

    return (
        <div>
            <div> < Header /> </div>
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>All Bookings</h2>
            <br></br>
            {/* <h5><u>List of Bookings for this room is as follows :</u></h5> */}
            {
                bookings.length > 0
                    ? bookings.map((item) =>
                        <Bookings key={item.id} bookings={item} />)
                    : "No Booking Present"
            }
        </div>
    );
};

export default ViewBookingResult;