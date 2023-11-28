<template>
    <div class="body-wrapper">
      <div class="container-fluid pt-4 pb-4">
        <div class="row">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <form @submit.prevent="submitForm">
                  <h3>Inspector</h3>
                  <div class="mb-3">
                    <label for="inputName" class="form-label">Name</label>
                    <input type="text" class="form-control" id="inputName" v-model="Inspector.name" placeholder="Enter Name" />
                    <p class="text-danger" v-if="!isValidName">Please enter a valid name.</p>
                  </div>
                  <div class="mb-3">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="text" class="form-control" id="inputEmail" v-model="Inspector.email" placeholder="Enter Email" />
                    <p class="text-danger" v-if="!isValidEmail">Please enter a valid email.</p>
                  </div>
                  <div class="mb-3">
                    <label for="inputPassword" class="form-label">Password</label>
                    <input type="password" class="form-control" id="inputPassword" v-model="Inspector.password" placeholder="Enter Password" />
                    <p class="text-danger" v-if="!isValidPassword">Please enter a valid password.</p>
                  </div>
                  <div class="mb-3">
                    <label for="inputPhoneNumber" class="form-label">Phone Number</label>
                    <input type="text" class="form-control" id="inputPhoneNumber" v-model="Inspector.phoneNumber" placeholder="Enter Phone Number" />
                    <p class="text-danger" v-if="!isValidPhoneNumber">Please enter a valid phone number.</p>
                  </div>
                  <div class="mb-3">
                    <label for="inputAddress" class="form-label">Address</label>
                    <input type="text" class="form-control" id="inputAddress" v-model="Inspector.address" placeholder="Enter Address" />
                    <p class="text-danger" v-if="!isValidAddress">Please enter a valid address.</p>
                  </div>
                  <button type="submit" class="btn btn-primary">Update Details</button>
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
        Inspector: {
          name: "",
          email: "",
          password: "",
          phoneNumber: "",
          address: "",
        },
        isValidName: true,
        isValidEmail: true,
        isValidPassword: true,
        isValidPhoneNumber: true,
        isValidAddress: true,
      };
    },
    methods: {
      submitForm() {
        this.validateForm();
  
        if (this.isFormValid) {
          // Send a POST request to your Spring Boot API
          axios
            .post("http://localhost:8090/inspector", this.Inspector) // Change the API endpoint
            .then((response) => {
              console.log("Inspector data sent successfully:", response.data);
  
              // Optionally, you can reset the form fields here
              this.Inspector.name = "";
              this.Inspector.email = "";
              this.Inspector.password = "";
              this.Inspector.phoneNumber = "";
              this.Inspector.address = "";
  
              Swal.fire("Data inserted Successfully!");
            })
            .catch((error) => {
              console.error("Error sending inspector data:", error);
            });
        }
      },
      validateForm() {
        this.isValidName = this.isValidField(this.Inspector.name);
        this.isValidEmail = this.isValidField(this.Inspector.email);
        this.isValidPassword = this.isValidField(this.Inspector.password);
        this.isValidPhoneNumber = this.isValidField(this.Inspector.phoneNumber);
        this.isValidAddress = this.isValidField(this.Inspector.address);
  
        this.isFormValid =
          this.isValidName &&
          this.isValidEmail &&
          this.isValidPassword &&
          this.isValidPhoneNumber &&
          this.isValidAddress;
      },
  
      isValidField(value) {
        return typeof value === "string" && value.trim() !== "";
      },
    },
  };
  </script>
  
    
        