import React, { useState, useEffect } from "react";
import Department from "./Department";
import base_url from "../../api/bootapi";
import axios from "axios";
import Header from "../../pages/Header";
const AllDepartments = () => {

    useEffect(() => {
        document.title = "All Departments"
    }, []);


    // function to call server
    const getAllDepartmentsFromServer = () => {
        axios.get(`${base_url}ManageDepartment/viewall`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                //toast("Data Fetched from Backend");
                setDepartments(response.data);

            },
            (error) => {
                //for errors
                console.log(error);
                // toast.error("Data can't be Fetched from Backend");
            }
        );
    };


    useEffect(() => {
        getAllDepartmentsFromServer();
    }, []);

    const [departments, setDepartments] = useState([

    ]);

    return (
        <div>
            <div> < Header /> </div>
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>All Department</h2>
            <br></br>
            {/* <h5><u>List of Departments is as follows :</u></h5> */}
            {
                departments.length > 0
                    ? departments.map((item) =>
                        <Department key={item.id} department={item} />)
                    : "No Department Present"
            }
        </div>
    )
}

export default AllDepartments;