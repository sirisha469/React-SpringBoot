import { useState } from "react";
import "../auth/loginPage.css";
import { Link } from "react-router-dom";
import userService from "../components/userService";
import { useNavigate } from 'react-router-dom';

function LoginPage(){

  const [email, setEmail] = useState('');
  const [password, setPassword]= useState('');
  const navigate = useNavigate();

  const handleInputChange = (e) => {
    const {name, value} = e.target;

    if (name === 'email') {
      setEmail(value);
    } else if (name === 'password') {
      setPassword(value);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try{
      const resData = await userService.login(email,password); 
      if(resData.token){
        localStorage.setItem('token', resData.token);
        navigate('/hi');
      }
    }
    catch(err){
      console.log(err);
    }
  };

  return(
    <div className="login-container">
      <div className="branding">
        <div className="branding-logo">
          <img src="https://static.vecteezy.com/system/resources/previews/023/206/137/original/cute-to-do-list-template-with-floral-element-funny-design-of-daily-planner-schedule-or-checklist-perfect-for-planning-memo-notes-and-self-organization-hand-drawn-illustration-vector.jpg" alt="todo"/>
          {/* <h3>To-Do App</h3> */}
        </div>
      </div>
      <div className="login-box">
        <div className="login-form">
          <h2>Login</h2>
          <input type="text" name="email" value={email} placeholder="Username" onChange={handleInputChange}/>
          <input type="password" name="password" value={password} placeholder="Password" onChange={handleInputChange}/>
          <button onClick={handleSubmit}>Login</button>
          <p>Not a user? <Link to="/register">Register</Link></p>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
