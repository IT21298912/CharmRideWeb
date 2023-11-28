import axios from "axios";

const BUS_API_URL = "http://localhost:8090/bus";

class BusService {
  getbuses() {
    return axios.get(BUS_API_URL);
  }

  getBusById(buid) {
    const url = `${BUS_API_URL}/${buid}`;
    return axios.get(url);
  }

  updateBus(Bus) {
    // Construct the URL to the specific patient's endpoint
    // const url = `${PATIENT_API_URL}/${patient.id}`; // Replace 'id' with your patient identifier field name

    // Send a PUT request to update the patient data
    return axios.put(BUS_API_URL, Bus);
  }

    deleteBus(buid) {
    const url = `${BUS_API_URL}/${buid}`;
    
    // Send a DELETE request to delete the patient by patientId
    return axios.delete(url);
  }



}

export default new BusService();
