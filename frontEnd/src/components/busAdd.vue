<template>
  <div class="body-wrapper">
    <div class="container-fluid pt-4 pb-4">
      <div class="row">
        <div class="col-lg-8">
          <div class="card">
            <div class="card-body">
              <form @submit.prevent="submitForm">
                <h3>Bus Profile</h3>
                <div class="mb-3">
                  <label for="inputEmail" class="form-label">Name</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputEmail"
                    v-model="Bus.name"
                    placeholder="Enter Name"
                  />
                  <p class="text-danger" v-if="!isValidname">
                    Please enter a valid name.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputFirstName" class="form-label"
                    >Vehicle Number</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputFirstName"
                    v-model="Bus.vehicleNum"
                    placeholder="Enter Vehicle Name"
                  />
                  <p class="text-danger" v-if="!isValidvehiclename">
                    Please enter a valid vehicle name.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="busTypeSelect" class="form-label">Bus Type</label>
                  <select
                    class="form-select"
                    id="busTypeSelect"
                    v-model="Bus.busType"
                  >
                    <option value="AC">AC</option>
                    <option value="Non-AC">Non-AC</option>
                  </select>
                  <p class="text-danger" v-if="!isValidbustype">
                    Please select a valid bus type.
                  </p>
                </div>

                <div class="mb-3">
  <label for="busSeatsSelect" class="form-label">Seats</label>
  <select class="form-select" id="busSeatsSelect" v-model="Bus.seats">
    <option value="50">50</option>
    <option value="60">60</option>
    <option value="25">25</option>
  </select>
</div>
<p class="text-danger" v-if="!isValidseats">
  Please select a valid number of seats.
</p>

                <div class="mb-3">
                  <label for="inputGender" class="form-label">Price</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputGender"
                    v-model="Bus.price"
                    placeholder="Enter Price"
                  />
                  <p class="text-danger" v-if="!isValidprice">
                    Please enter a valid price.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputBloodGroup" class="form-label">Driver</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputBloodGroup"
                    v-model="Bus.driver"
                    placeholder="Enter Driver"
                  />
                  <p class="text-danger" v-if="!isValiddriver">
                    Please enter a valid driver name.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputAge" class="form-label">From Location</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputAge"
                    v-model="Bus.fromLocation"
                    placeholder="Enter From Location"
                  />
                  <p class="text-danger" v-if="!isValidfrom">
                    Please enter a valid from location.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputAmount" class="form-label"
                    >To Location</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputAmount"
                    v-model="Bus.toLocation"
                    placeholder="Enter To Location"
                  />
                  <p class="text-danger" v-if="!isValidto">
                    Please enter a valid to location.
                  </p>
                </div>
                <div class="mb-3">
  <label for="busSheduleSelect" class="form-label">Shedule</label>
  <select class="form-select" id="busSheduleSelect" v-model="Bus.shedule">
    <option value="6pm to 9pm">6pm to 9pm</option>
    <option value="3pm to 6pm">3pm to 6pm</option>
    <option value="12pm to 3pm">12pm to 3pm</option>
    <option value="8am to 12pm">8am to 12pm</option>
    <option value="5am to 8am">5am to 8am</option>
    <option value="1am to 5am">1am to 5am</option>
  </select>
</div>

                <button type="submit" class="btn btn-primary">
                  Update Details
                </button>
              </form>
            </div>
          </div>
        </div>
        <!-- ... -->
      </div>
    </div>
  </div>
</template>
  
  
    
    
    
  <script>
import axios from "axios";
import Swal from "sweetalert2";

export default {
  data() {
    return {
      Bus: {
        name: "",
        vehicleNum: "",
        busType: "",
        seats: "",
        price: "",
        driver: "",
        fromLocation: "",
        toLocation: "",
        shedule: "",
      },
      isValidname: true,
      isValidvehiclename: true,
      isValidbustype: true,
      isValidseats: true,
      isValidprice: true,
      isValiddriver: true,
      isValidfrom: true,
      isValidto: true,
    };
  },
  methods: {
    submitForm() {
      this.validateForm();

      if (this.isFormValid) {
        // Send a POST request to your Spring Boot API
        axios
          .post("http://localhost:8090/bus", this.Bus)
          .then((response) => {
            console.log("Bus data sent successfully:", response.data);

            // Optionally, you can reset the form fields here
            this.Bus.name = "";
            this.Bus.vehicleNum = "";
            this.Bus.busType = "";
            this.Bus.driver = "";
            this.Bus.seats = "";
            this.Bus.price = "";
            this.Bus.fromLocation = "";
            this.Bus.toLocation = "";
            this.Bus.shedule = "";

            Swal.fire("Data inserted Successfully!");
          })
          .catch((error) => {
            console.error("Error sending doctor data:", error);
          });
      }
    },
    validateForm() {
      this.isValidname = this.isValidField(this.Bus.name);
      this.isValidvehiclename = this.isValidField(this.Bus.vehicleNum);
      this.isValidbustype = this.isValidField(this.Bus.busType);
      this.isValidseats = this.isValidField(this.Bus.seats);
      this.isValidprice = this.isValidField(this.Bus.price);
      // this.isValiddriver = this.isValidField(this.doctor.status);
      // this.isValidfrom = this.isValidField(this.doctor.amount);
      // this.isValidto = this.isValidField(this.doctor.cured);

      this.isFormValid =
        this.isValidname &&
        this.isValidvehiclename &&
        this.isValidbustype &&
        this.isValidseats &&
        this.isValidprice;
    },

    isValidField(value) {
      return typeof value === "string" && value.trim() !== "";
    },
  },
};
</script>
  
      