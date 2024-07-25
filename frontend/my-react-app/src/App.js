import logo from './logo.svg';
import './App.css';
import { Home } from './components/Home/Home';
import Login from './components/Login/Login';
import {
  BrowserRouter as Router,
  Route,
  Routes
} from "react-router-dom";
import { Admin } from './components/Admin/Admin';
import { BasicNav } from './Layout/BasicNav/BasicNav';
import ViewEmployee from './components/ViewEmployee/ViewEmployee';
import { Navbar } from './Layout/Navbar/Navbar';

function App() {
  return (<>
  {/* <Navbar /> */}
  <Router>
    <Routes>
      <Route exact path="/" element={<><BasicNav /><Home /></>} />
      <Route exact path="/login" element={<><BasicNav /><Login /></>} />
      <Route exact path="/admindashboard/:username/:role" element={<><Admin/></>} />

      <Route exact path="/admindashboard/:username/:role" element={<><Navbar /><Admin/></>} />
          <Route exact path="/admindashboard/viewEmployee" element={<><Navbar /><ViewEmployee/></>} />
          {/* <Route exact path="/admindashboard/addEmployee" element={<><Navbar /><AddAgent/></>} />
          <Route exact path="/admindashboard/viewVendor" element={<><Navbar /> <ViewCustomerAll/></>} />
          <Route exact path="/admindashboard/addVendor" element={<><Navbar />< AddCustomer /></>} /> */}
          {/* <Route exact path="/admindashboard/addcustomer" element={<><Navbar />< AddCustomer /></>} />
          <Route exact path="/admindashboard/updateAgent/:id" element={<><Navbar />< UpdateAgent /></>} />
          <Route exact path="/admindashboard/updatecustomer/:id" element={<><Navbar />< UpdateCustomer /></>} />
          <Route exact path="/admindashboard/profile/:username" element={<><Navbar /><AdminProfile/></>} />
          <Route exact path="/admindashboard/addInsurance" element={<><Navbar /><AddPolicy/></>} />
          <Route exact path="/admindashboard/addScheme" element={<><Navbar /><AddScheme/></>} />
          <Route exact path="/admindashboard/viewinsurance" element={<><Navbar /><ViewAllInsurance/></>} />
          <Route exact path="/admindashboard/viewscheme" element={<><Navbar /><ViewAllSchemes/></>} />
          <Route exact path="/admindashboard/viewemployee" element={<><Navbar /><ViewEmployee/></>} />
          <Route exact path="/admindashboard/addemployee" element={<><Navbar /><AddEmployee/></>} /> */}

      </Routes>
      </Router>

    </>
  );
}

export default App;
