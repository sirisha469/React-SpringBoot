import React, { useState, useEffect } from "react";
import axios from "axios";
import api from "./sample";
import paymentService from "./sample";

export default function PaymentPage() {
  const [message, setMessage] = useState("");

   useEffect(() => {

    //const msg = paymentService.hi();
    paymentService.hi()
      .then((res) => {
        setMessage(res.data); // update state with backend response
      })
      .catch((err) => {
        console.error("Error fetching:", err);
      });
  }, []);

  // const msg = async ()=>{
  //   const m = await paymentService.hi();
  //   setMessage(m);
  // }

 return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h1>{message}</h1>
    </div>
  );
}
