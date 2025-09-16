import React, { useEffect, useState } from "react";
import userService from "./userService";


export default function HelloPage(){
  const [message, setMessage] = useState("");

  useEffect(()=>{
    userService.hello()
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