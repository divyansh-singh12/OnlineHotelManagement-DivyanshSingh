import React from "react";
import { Route, Routes } from "react-router-dom";

import Dashboard from "../pages/Dashboard.jsx";
import Notifications from "../Services/Owner/Notifications.jsx";

import AddDepartment from "../Services/Owner/AddDepartment.jsx";
import AllDepartments from "../Services/Owner/AllDepartment.jsx";
import AddUser from "../Services/Owner/User/AddUser.jsx";
import DeleteUser from "../Services/Owner/User/DeleteUser.jsx";
import UpdateUser from "../Services/Owner/User/UpdateUser.jsx";
import ViewDepartmentByName from "../Services/Owner/ViewDepartmentByName.jsx";
import ViewDepartmentResult from "../Services/Owner/ViewDepartmentResult.jsx";

import OwnerMenu from "./OnwerMenu";
import RetrieveReport from "../Services/Owner/RetrieveReport.jsx";
import UpdateDepartment from "../Services/Owner/UpdateDepartment.jsx";



const OwnerMenuCall = () => {
    return (
        //  <BrowserRouter>
        <OwnerMenu>


            <Routes>
                <Route path="/" element={<Dashboard />} />
                <Route path="/home" element={<Dashboard />} />

                <Route path="/adddepartment" element={<AddDepartment />} />
                <Route path="/viewdepartmentbyname" element={<ViewDepartmentByName />} />
                <Route path="/viewdepartmentbyName/result/:name" element={<ViewDepartmentResult />} />
                <Route path='/viewdepartmentbyName/result/update/:name' element={<UpdateDepartment />} exact />
                <Route path="/viewall" element={<AllDepartments />} />
                <Route path='/viewall/update/:name' element={<UpdateDepartment />} exact />

                <Route path="/adduser" element={<AddUser />} />
                <Route path="/updateuser" element={<UpdateUser />} />
                <Route path="/deleteuser" element={<DeleteUser />} />

                <Route path="/notifications" element={<Notifications />} />
                <Route path="/retrievereport" element={<RetrieveReport />} />

            </Routes>

        </OwnerMenu>
        //  </BrowserRouter>
    )
}

export default OwnerMenuCall;