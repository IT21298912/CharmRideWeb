import axios from "axios";

const COMP_BASE_URL = "http://localhost:8090/complaint";
const COMP_BASE_URL_DECLINE = "http://localhost:8090/complaint/decline";

class ComplaintService {
  getComplaints() {
    return axios.get(COMP_BASE_URL);
  }



  Updatetoresolve(cid) {
    // Construct the URL to the specific complaint's endpoint
    const url = `${COMP_BASE_URL}/${cid}`; // Use the complaint ID to target the specific complaint

    // Send a PUT request to update the complaint data
    return axios.put(url);
  }


  Updatetodecline(cid) {
    // Construct the URL to the specific complaint's endpoint
    const url = `${COMP_BASE_URL_DECLINE}/${cid}`; // Use the complaint ID to target the specific complaint

    // Send a PUT request to update the complaint data
    return axios.put(url);
  }

    deleteBus(buid) {
    const url = `${BUS_API_URL}/${buid}`;
    
    // Send a DELETE request to delete the patient by patientId
    return axios.delete(url);
  }



}

export default new ComplaintService();
