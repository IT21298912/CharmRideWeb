import axios from "axios";

const INS_API_URL = "http://localhost:8090/inspector";

class InspectorService {
  getInspector() {
    return axios.get(INS_API_URL);
  }

  getInspectorById(Id) {
    const url = `${INS_API_URL}/${Id}`;
    return axios.get(url);
  }

  updateInspector(Inspector) {
    // Construct the URL to the specific patient's endpoint
    // const url = `${PATIENT_API_URL}/${patient.id}`; // Replace 'id' with your patient identifier field name

    // Send a PUT request to update the patient data
    return axios.put(INS_API_URL, Inspector);
  }

    DeleteInpector(Id) {
    const url = `${INS_API_URL}/${Id}`;
    
    // Send a DELETE request to delete the patient by patientId
    return axios.delete(url);
  }



}

export default new InspectorService();
