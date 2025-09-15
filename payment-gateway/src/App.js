import HelloPage from "./components/helloPage";
import PaymentPage from "./components/paymentPage";
import Sample from "./components/sample";
import { BrowserRouter as Router,Routes, Route, Link } from "react-router-dom";
import LoginPage from "./auth/loginPage";
import RegisterPage from "./auth/registerPage";

function App() {
  return (

    <div>
      <Router>
        <div>
          {/* <nav style={{ padding: "10px", background: "#f0f0f0" }}>
          <Link to="/hi" style={{ marginRight: "15px" }}>Payment Page</Link>
          <Link to="/hello">Hello Page</Link>
        </nav> */}
        <Routes> 
          <Route path="/" element={<LoginPage/>}/>
          <Route path="/hi" element={<PaymentPage/>}/>
          <Route path="/hello" element={<HelloPage/>}/>
          <Route path="/register" element={<RegisterPage/>}/>
        </Routes>
        </div>
      </Router>
      {/* <PaymentPage/> */}
      {/* <HelloPage/> */}
    </div>
  );
}

export default App;
