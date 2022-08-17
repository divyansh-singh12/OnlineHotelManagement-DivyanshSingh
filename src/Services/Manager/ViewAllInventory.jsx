import React, { useState, useEffect } from "react";
import Inventory from "./Inventory";
import base_url from "../../api/bootapi";
import axios from "axios";
import Header from "../../pages/Header";
const ViewAllInventory = () => {
    useEffect(() => {
        document.title = "All Inventories"
    }, []);


    // function to call server
    const getAllInventoriesFromServer = () => {
        axios.get(`${base_url}ManageInventory/viewall`, {
            headers: {
                "Access-Control-Allow-Headers": "Content-Type",
                "Access-Control-Allow-Methods": "*"
            }
        }).then(
            (response) => {
                //success
                console.log(response.data);
                //toast("Data Fetched from Backend");
                setInventories(response.data);

            },
            (error) => {
                //for errors
                console.log(error);
                // toast.error("Data can't be Fetched from Backend");
            }
        );
    };


    useEffect(() => {
        getAllInventoriesFromServer();
    }, []);

    const [inventory, setInventories] = useState([]);

    return (
        <div>
            <div> < Header /> </div>
            <h2 className="text-center my-3" style={{ fontFamily: "fantasy", fontStyle: "italic", textDecoration: "underline" }}>All Inventories</h2>
            <br></br>
            {/* <h5><u>List of Inventories is as follows :</u></h5> */}
            {
                inventory.length > 0
                    ? inventory.map((item) =>
                        <Inventory key={item.id} inventory={item} />)
                    : "No Inventory Present"
            }
        </div>
    );
}
export default ViewAllInventory;