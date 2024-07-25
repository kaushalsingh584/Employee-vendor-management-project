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

function App() {
  return (<>
  {/* <Navbar /> */}
  <Router>
    <Routes>
      <Route exact path="/" element={<><BasicNav /><Home /></>} />
      <Route exact path="/login" element={<><BasicNav /><Login /></>} />
      <Route exact path="/admindashboard/:username/:role" element={<><Admin/></>} />

      </Routes>
      </Router>

    </>
  );
}

export default App;
