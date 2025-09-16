import axios from "axios";

class userService{
  static BASE_URL = "http://localhost:8080";

  static async hi(){
    try {
      const response = await axios.get(`${this.BASE_URL}/hi`);
      return response;
    } catch (error) {
      throw error;
    }
  }

  static async hello(){
    try {
      const response = await axios.get(`${this.BASE_URL}/hello`);
      return response;
    } catch (error) {
      throw error;
    }
  }

  static async register(userData){
    try{
      const response = await axios.post(`${this.BASE_URL}/register`, userData);
      return response;
    }catch(error){
      throw error;
    }
  }
}

export default userService;