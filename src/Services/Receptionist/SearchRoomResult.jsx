import axios from "axios";
import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import base_url from "../../api/bootapi";
import AvailableRooms from "./AvailableRooms";
import Header from "../../pages/Header";

const SearchRoomResult = () => {
    useEffect(() => {
        document.title = "Available Rooms";
        let searchQuery = { type: type, check_in: check_in, no_of_guest: no_of_guest };
        console.log(searchQuery);
        getAllRoomsFromServer(searchQuery);
    }, []);

    function ReverseString(str) {
        return str.split('').reverse().join('')
    }

    const query = new URLSearchParams(useLocation().search);
    let type = query.get("type");
    let date = query.get("checkin");
    let no_of_guest = query.get("noofguest");
    ReverseString(date);
    let check_in = date;

    const getAllRoomsFromServer = (data) => {
        console.log(data);
        axios.put(`${base_url}SearchRoom/result`, data, {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Access-Control-Allow-Headers": "*",
                "contentType": "*",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {

                //success
                console.log(response.data);
                //toast("Data Fetched from Backend");
                setAvailableRooms(response.data);

            },
            (error) => {
                //for errors
                console.log(error);
                // toast.error("Data can't be Fetched from Backend");
            }
        );
    };



    const [availableRooms, setAvailableRooms] = useState([]);


    return (
        <div>
            <div> < Header /> </div>
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>Following rooms are available </h2>
            <br></br>
            {
                availableRooms.length > 0
                    ? availableRooms.map((item) =>
                        <AvailableRooms key={item.roomno} availableRooms={item} />)
                    : "No Room Present For Booking"
            }
        </div>
    )
}

export default SearchRoomResult;