import axios from "axios";

const COMP_BASE_URL = "http://localhost:8090/booking";

class BookingService {
  getBookings() {
    return axios.get(COMP_BASE_URL);
  }




}

export default new BookingService();
