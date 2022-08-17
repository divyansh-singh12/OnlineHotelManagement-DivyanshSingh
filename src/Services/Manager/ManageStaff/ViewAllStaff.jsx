import React, { useState, useEffect } from "react";
import base_url from "../../../api/bootapi";
import axios from "axios";
import Staff from "./Staff";
import Header from "../../../pages/Header";
const ViewAllStaff = () => {
    useEffect(() => {
        document.title = "All Staff"
    }, []);


    // function to call server
    const getAllStaffFromServer = () => {
        axios.get(`${base_url}ManageStaff/viewstaff`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                //toast("Data Fetched from Backend");
                setStaff(response.data);

            },
            (error) => {
                //for errors
                console.log(error);
                // toast.error("Data can't be Fetched from Backend");
            }
        );
    };


    useEffect(() => {
        getAllStaffFromServer();
    }, []);

    const [staff, setStaff] = useState([]);

    return (
        <div>
            <div> < Header /> </div>
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>All Staff</h2>
            <br></br>
            {/* <h5><u>List of Staff is as follows :</u></h5> */}
            {
                staff.length > 0
                    ? staff.map((item) =>
                        <Staff key={item.code} staff={item} />)
                    : "No Staff Present"
            }
        </div>
    );
}
export default ViewAllStaff;