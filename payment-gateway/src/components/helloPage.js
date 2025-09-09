import React, { useEffect, useState } from "react";
import paymentService from "./sample";


export default function HelloPage(){
  const [message, setMessage] = useState("");

  useEffect(()=>{
    paymentService.hello()
        .then((res)=>{
          setMessage(res.data);
        })
        .catch((err)=>{
          console.error("Error fetching:", err);
        });
  },[]);

  return(
    <div>
      <h1>{message}</h1>
    </div>
  );
}

//export default helloPage;