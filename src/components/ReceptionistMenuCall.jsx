import React from "react";
import { Route, Routes } from "react-router-dom";

import Dashboard from "../pages/Dashboard";

import AddGuest from "../Services/Receptionist/AddGuest";
import IssueBill from "../Services/Receptionist/IssueBill";
import IssueBillResult from "../Services/Receptionist/IssueBillResult";
import Reservation from "../Services/Receptionist/Reservation";
import SearchRoom from "../Services/Receptionist/SeachRoom";
import SearchRoomResult from "../Services/Receptionist/SearchRoomResult";
import ViewGuestById from "../Services/Receptionist/ViewGuestById";
import ViewGuestResult from "../Services/Receptionist/ViewGuestResult";
import ViewBookingByRoomNo from "../Services/Receptionist/ViewBookingByRoomNo";
import ViewBookingResult from "../Services/Receptionist/ViewBookingResult";
import UpdateGuest from "../Services/Receptionist/UpdateGuest";

import ReceptionistMenu from "./ReceptionistMenu";




const ReceptionistMenuCall = () => {
    return (
        // <BrowserRouter>
        <ReceptionistMenu>

            <Routes>
                <Route path="/" element={<Dashboard />} />
                <Route path="/home" element={<Dashboard />} />

                <Route path="/addguest" element={<AddGuest />} />
                <Route path="/viewguestbyid" element={<ViewGuestById />} />
                <Route path="/viewguestbyid/result/:id" element={<ViewGuestResult />} />
                <Route path='/viewguestbyid/result/update/:id' element={< UpdateGuest />} />
                <Route path="/searchroom" element={<SearchRoom />} />
                <Route path="/searchroom/result" element={<SearchRoomResult />} />
                <Route path="/searchroom/result/reservation/:roomno" element={<Reservation />} />
                <Route path="/reservation" element={<Reservation />} />
                <Route path='/viewbookings' element={< ViewBookingByRoomNo />} />
                <Route path='/viewbookings/result/:roomno' element={< ViewBookingResult />} />
                <Route path="/issuebill" element={<IssueBill />} />
                <Route path="/issuebill/result/:roomno" element={<IssueBillResult />} />

            </Routes>

        </ReceptionistMenu>
        // </BrowserRouter>
    )
}

export default ReceptionistMenuCall;