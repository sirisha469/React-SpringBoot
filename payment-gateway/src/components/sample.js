import axios from "axios";

class paymentService{
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
}

export default paymentService;