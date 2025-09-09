import "../auth/loginPage.css";
import { Link } from "react-router-dom";

function LoginPage(){
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
          <h2>Login</h2>
          <input type="text" placeholder="Username"/>
          <input type="password" placeholder="Password"/>
          <button>Login</button>
          <p>Not a user? <Link to="/hi">Register</Link></p>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
