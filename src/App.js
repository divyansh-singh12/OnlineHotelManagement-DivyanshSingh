import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import OwnerMenuCall from './components/OwnerMenuCall';
import ManagerMenuCall from './components/ManagerMenuCall';
import ReceptionistMenuCall from './components/ReceptionistMenuCall';
import Login from './pages/Login';

const App = () => {
  return (


    <BrowserRouter>

      <Routes>
        <Route path='/login' element={<Login />} exact />
        <Route path='/owner/*' element={< OwnerMenuCall />} />

        <Route path='/manager/*' element={< ManagerMenuCall />} />
        <Route path='/receptionist/*' element={< ReceptionistMenuCall />} />
      </Routes>
    </BrowserRouter>

  );
};







// <BrowserRouter>
// <Routes>
//   {/* <Route path='/owner/**' element={<Sidebar />}> */}
//     {/* <Sidebar> */}

//     {/* <Routes> */}
//       {/* <Route path="/owner/" element={<Dashboard />} /> */}
//       <Route path="/owner/home" element={<Dashboard />} />

//       <Route path="/owner/adddepartment" element={<AddDepartment />} />
//       <Route path="/about" element={<About />} />
//       <Route path="/comment" element={<Comment />} />
//       <Route path="/analytics" element={<Analytics />} />
//       <Route path="/product" element={<Product />} />
//       <Route path="/productList" element={<ProductList />} />
//     {/* </Routes> */}
//     {/* </Sidebar> */}
//     </Route>
//   </Routes>

// {/* <ManagerMenu>
//   <Routes>

//   <Route path="/manager" element={<Dashboard />} />
//   <Route path="/manager/home" element={<Dashboard />} />
//   <Route path="/manager/addinventory" element={<AddInventory />} />

//   </Routes>

// </ManagerMenu> */}







export default App;