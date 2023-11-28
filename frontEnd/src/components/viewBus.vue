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
                    <input type="text" class="form-control" id="inputEmail" v-model="Bus.name" placeholder="Enter Name" />
                    <!-- <p class="text-danger" v-if="!isValidname">Please enter a valid name.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputFirstName" class="form-label">Vehicle Name</label>
                    <input type="text" class="form-control" id="inputFirstName" v-model="Bus.vehicleNum" placeholder="Enter Vehicle Name" />
                    <!-- <p class="text-danger" v-if="!isValidvehiclename">Please enter a valid vehicle name.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputLastName" class="form-label">Bus Type</label>
                    <input type="text" class="form-control" id="inputLastName" v-model="Bus.busType" placeholder="Enter Bus Type" />
                    <!-- <p class="text-danger" v-if="!isValidbustype">Please enter a valid bus type.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputUsername" class="form-label">Seats</label>
                    <input type="text" class="form-control" id="inputUsername" v-model="Bus.seats" placeholder="Enter Seats" />
                    <!-- <p class="text-danger" v-if="!isValidseats">Please enter a valid number of seats.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputGender" class="form-label">Price</label>
                    <input type="text" class="form-control" id="inputGender" v-model="Bus.price" placeholder="Enter Price" />
                    <!-- <p class="text-danger" v-if="!isValidprice">Please enter a valid price.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputBloodGroup" class="form-label">Driver</label>
                    <input type="text" class="form-control" id="inputBloodGroup" v-model="Bus.driver" placeholder="Enter Driver" />
                    <!-- <p class="text-danger" v-if="!isValiddriver">Please enter a valid driver name.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputAge" class="form-label">From Location</label>
                    <input type="text" class="form-control" id="inputAge" v-model="Bus.fromLocation" placeholder="Enter From Location" />
                    <!-- <p class="text-danger" v-if="!isValidfrom">Please enter a valid from location.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputAmount" class="form-label">To Location</label>
                    <input type="text" class="form-control" id="inputAmount" v-model="Bus.toLocation" placeholder="Enter To Location" />
                    <!-- <p class="text-danger" v-if="!isValidto">Please enter a valid to location.</p> -->
                  </div>
                  <div class="mb-3">
                    <label for="inputDistrict" class="form-label">Shedule</label>
                    <input type="text" class="form-control" id="inputDistrict" v-model="Bus.shedule" placeholder="Enter Shedule" />
                    
                  </div>
  <button type="submit" class="btn btn-primary" style="margin-right: 10px;">Update</button>
  <button type="button" @click="deleteBus(Bus.id)" class="btn btn-primary">Delete</button>
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
import BusService from '../Services/BusService';
import axios from 'axios';
import Swal from 'sweetalert2';

export default {
  data() {
    return {
        Bus: {
            name: '',
            vehicleNum: '',
            busType: '',
            seats: '',
            price: '',
            driver: '',
            fromLocation: '',
            toLocation: '',
            shedule: ''

        },
    };
  },
  created() {
    // Fetch patient data initially
    this.fetchBusdata();

    // Set up polling to fetch data every 5 seconds (adjust the interval as needed)
    setInterval(this.fetchBusdata, 15000); // Poll every 5 seconds
  },
  methods: {
    fetchBusdata() {
      const buid = this.$route.params.buid;

      // Fetch patient data by patientId from the database using PatientService
      BusService.getBusById(buid)
        .then((response) => {
          // Update the patient data in your component
          this.Bus = response.data;
        })
        .catch((error) => {
          console.error('Error fetching Bus data:', error);
        });
    },
    submitForm() {
      // Send the updated patient data to the Spring Boot API using PUT request
      BusService.updateBus(this.Bus)
        .then((response) => {

          Swal.fire({
  position: 'top-end',
  icon: 'success',
  title: 'Your work has been saved',
  showConfirmButton: false,
  timer: 1500
})
          // Handle success (e.g., show a success message)
          console.log('Bus data updated successfully:', response.data);
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error('Error updating Bus data:', error);
        });
    },

    deleteBus(buid) {

            Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
            if (result.isConfirmed) {
            BusService.deleteBus(buid)
              .then((response) => {
                // Handle success (e.g., show a success message)
                console.log('bus deleted successfully:', response.data);

                // After deleting, update the Patiens array by removing the deleted patient
                this.Buses = this.Buses.filter((bus) => bus.buid !== buid);

                // Navigate to the desired route (if needed)
                this.$router.push({ name: 'Bman' });
              })
              .catch((error) => {
                // Handle errors (e.g., show an error message)
                console.error('Error deleting patient:', error);
              });
            Swal.fire(
              'Deleted!',
              'Your file has been deleted.',
              'success'
            )
            }
            })
            // Send a DELETE request to delete the patient using the same PatientService

            },




  },
};
</script>
