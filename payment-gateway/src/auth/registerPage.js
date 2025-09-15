import { Link } from "react-router-dom";
import "../auth/loginPage.css";

function RegisterPage(){

  return(
    <div className="login-container">
      <div className="branding">
        <div className="branding-logo">
          <img src="https://static.vecteezy.com/system/resources/previews/023/206/137/original/cute-to-do-list-template-with-floral-element-funny-design-of-daily-planner-schedule-or-checklist-perfect-for-planning-memo-notes-and-self-organization-hand-drawn-illustration-vector.jpg"/>
          {/* <h3>To-Do App</h3> */}
        </div>
      </div>
      <div className="login-box">
        <div className="login-form">
          <h2>Register</h2>
          <input type="text" placeholder="Name"/>
          <input type="text" placeholder="Email"/>
          <input type="text" placeholder="Mobile"/>
          <input type="password" placeholder="Password"/>
          <button>Register</button>
          <p>Already have an account? <Link to="/">Login</Link></p>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;