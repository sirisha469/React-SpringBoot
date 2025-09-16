import { Link, useNavigate } from "react-router-dom";
import "../auth/loginPage.css";
import { useState } from "react";
import userService from "../components/userService";

function RegisterPage(){

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: '',
    email: '',
    mobile: '',
    password:''
  });

  const handleInputChange = (e) => {
    const {name, value} = e.target;
    setFormData({
      ...formData, [name]:value
    })
  }
  
  const handleSubmit = async (e) =>{
    e.preventDefault();

    try{
      const res = await userService.register(formData);

      // setFormData({
      //   name:'',
      //   email:'',
      //   name:'',
      //   password:''
      // });
      alert(res.data);
      navigate('/')
    }catch(err){
      console.error('Error registering user: ', err);
      alert('Error occured while registering user');
    }
  }

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
          <input type="text" name="name" value={formData.name} placeholder="Name" onChange={handleInputChange}/>
          <input type="text" name="email" value={formData.email} placeholder="Email" onChange={handleInputChange}/>
          <input type="text" name="mobile" value={formData.mobile} placeholder="Mobile" onChange={handleInputChange}/>
          <input type="password" name="password" value={formData.password} placeholder="Password" onChange={handleInputChange}/>
          <button onClick={handleSubmit}>Register</button>
          <p>Already have an account? <Link to="/">Login</Link></p>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;