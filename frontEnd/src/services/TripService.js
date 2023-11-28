import axios from "axios";

const COMP_BASE_URL = "https://charm-ride.pockethost.io/api/collections/trip/records";

class TripService {
  getTrips() {
    return axios.get(COMP_BASE_URL);
  }




}

export default new TripService();
