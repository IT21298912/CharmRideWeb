
<template>
  <div className="body-wrapper ">
    <div className="container-fluid pt-4 pb-0">
      <div class="row">
        <div class="col-lg-8 d-flex align-items-stretch">
          <div class="card w-100">
            <div class="card-body">
              <div class="d-sm-flex d-block align-items-center justify-content-between mb-9">
                <div class="mb-3 mb-sm-0">
                  <h5 class="card-title fw-semibold">Trip Overview</h5>
                </div>
                <div>
                  <select class="form-select">
                    <option value="1">March 2023</option>
                    <option value="2">April 2023</option>
                    <option value="3">May 2023</option>
                    <option value="4">June 2023</option>
                  </select>
                </div>
              </div>
              <ChartCompo />
            </div>
          </div>
        </div>
        <div class="col-lg-4">
    <div class="card text-dark bg-white shadow mb-3" style="max-width: 18rem;">
      <div class="card-header bg-white">
        <h2 class="text-center">Crowd Overview</h2>
      </div>
      <div class="card-body">
        <h5 class="card-title">Bus Details</h5>
        <p class="card-text">
          Buses with 60 seats: {{ busCounts.seats60 }}<br>
          Buses with 55 seats: {{ busCounts.seats55 }}<br>
          Buses with 25 seats: {{ busCounts.seats25 }}
        </p>
        <hr>
        <h5 class="card-title">Today Bookings: {{ numberOfBookings }}</h5>
        <hr>
        <h5 class="card-title">Total Seats: {{ total }}</h5>
        <h5 class="card-title">Available Seats: {{ total - numberOfBookings }}</h5>
        <h5 class="card-title">Total Users: {{ totalUsers }}</h5>
      </div>
    </div>
  </div>
        
      </div>

      <div class="row">
        <div class="col-lg-8 d-flex align-items-stretch">
          <div class="card w-100">
            <div class="card-body">
              <div class="d-sm-flex d-block align-items-center justify-content-between mb-9">
                <div class="mb-3 mb-sm-0">
                  <h5 class="card-title fw-semibold">Booking Overview</h5>
                </div>
                <!-- <div>
                  <select class="form-select">
                    <option value="1">March 2023</option>
                    <option value="2">April 2023</option>
                    <option value="3">May 2023</option>
                    <option value="4">June 2023</option>
                  </select>
                </div> -->
              </div>
              <ChartCompo2 />
            </div>
          </div>
        </div>


        
      </div>


      <div class="row">
        <div class="col-lg-12 d-flex align-items-stretch">
          <div class="card w-100">
            <div class="card-body p-4">
              <h5 class="card-title fw-semibold mb-4">Complaint Details</h5>
              <div class="table-responsive">
                <table class="table table-flush" id="datatable-basic2">
                  <thead class="thead-light">
                    <tr>
                      <th>Complain_ID</th>
                      <th>Username</th>

                      <th>BusName</th>
                      <th>Inspector_Name</th>
                      <th>Description</th>
                      <th>Status</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="complaint in Complaints" :key="complaint.cid">
                      <td>
                        <div class="d-flex align-items-center">
                          <p class="text-xs font-weight-bold ms-2 mb-0">
                            {{ complaint.cid }}
                          </p>
                        </div>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">{{ complaint.userName }}</span>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">{{ complaint.busName }}</span>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">{{ complaint.inspector }}</span>
                      </td>
                      <td class="text-xs font-weight-bold">
                        <span class="my-2 text-xs">{{ complaint.description }}</span>
                      </td>
                      <td class="text-xs font-weight-bold">
                        <span class="my-2 text-xs">{{
                          complaint.status
                        }}</span>
                      </td>
                      <td class="text-xs font-weight-bold p-0 pt-1">
                        <button class="btn btn-outline-dark btn-xs p-1 mb-1 me-1" @click="Updatetoresolve(complaint.cid)">
                          Resolved
                        </button>
                        <button class="btn btn-outline-dark btn-xs p-1 mb-1 me-1" @click="Updatetodecline(complaint.cid)">
                          Decline
                        </button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ComplaintService from "../services/ComplaintService";
import axios from "axios";
import * as XLSX from "xlsx";
import Swal from "sweetalert2";
import ChartCompo from "./ChartCompo.vue";
import GraphCompo from "./GraphCompo.vue";
import ChartCompo2 from './chartCompo2.vue';

export default {
  name: "Complaintlist",
  components: {
    ChartCompo,
    GraphCompo,
    ChartCompo2,
  },

  data() {
    return {
      Complaints: [],
      busCounts: {
        seats60: 0,
        seats55: 0,
        seats25: 0,
      },
      numberOfBookings: 0,
      total:0,
      totalUsers: 0,
    };
  },

  methods: {
    getComplaints() {
      ComplaintService.getComplaints().then((response) => {
        this.Complaints = response.data;
      });
    },


    Updatetoresolve(cid) {

      Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, update it!'
      }).then((result) => {
        if (result.isConfirmed) {
          ComplaintService.Updatetoresolve(cid)
            .then((response) => {
              // Handle success (e.g., show a success message)
              // console.log('bus deleted successfully:', response.data);

              // After deleting, update the Patiens array by removing the deleted patient
              this.Complaints = this.Complaints.filter((Complaint) => Complaint.cid !== cid);

              // Navigate to the desired route (if needed)
              this.$router.push({ name: 'Overview' });
            })
            .catch((error) => {
              // Handle errors (e.g., show an error message)
              console.error('Error updating Inspector:', error);
            });
          Swal.fire(
            'Updated!',
            'Your file has been updated.',
            'success'
          )
        }
      })
      // Send a DELETE request to delete the patient using the same PatientService

    },

    Updatetodecline(cid) {

      Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, update it!'
      }).then((result) => {
        if (result.isConfirmed) {
          ComplaintService.Updatetodecline(cid)
            .then((response) => {
              // Handle success (e.g., show a success message)
              // console.log('bus deleted successfully:', response.data);

              // After deleting, update the Patiens array by removing the deleted patient
              this.Complaints = this.Complaints.filter((Complaint) => Complaint.cid !== cid);

              // Navigate to the desired route (if needed)
              this.$router.push({ name: 'Overview' });
            })
            .catch((error) => {
              // Handle errors (e.g., show an error message)
              console.error('Error updating Inspector:', error);
            });
          Swal.fire(
            'Updated!',
            'Your file has been updated.',
            'success'
          )
        }
      })
      // Send a DELETE request to delete the patient using the same PatientService

    },



    exportToCSV() {
      const Complaints = this.Complaints;
      const ws = XLSX.utils.json_to_sheet(Complaints);
      const wb = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(wb, ws, "Complaints");
      XLSX.writeFile(wb, "Complaints.csv");
    },
  },

  created() {
    this.getComplaints();
    setInterval(this.getComplaints, 1000);

    axios
      .get("https://charm-ride.pockethost.io/api/collections/bus/records")
      .then((response) => {
        const buses = response.data.items;

        buses.forEach((bus) => {
          // Check the bus seat count and increment the corresponding variable
          if (bus.seat === 60) {
            this.busCounts.seats60++;
          } else if (bus.seat === 55) {
            this.busCounts.seats55++;
          } else if (bus.seat === 25) {
            this.busCounts.seats25++;
          }
        });

        // Calculate the multiplication results
        const result60 = this.busCounts.seats60 * 60;
        const result55 = this.busCounts.seats55 * 55;
        const result25 = this.busCounts.seats25 * 25;

         this.total = result25+result55+result60;

        // You can access the results in your component as needed
        console.log("Buses with 60 seats:", this.busCounts.seats60);
        console.log("Buses with 55 seats:", this.busCounts.seats55);
        console.log("Buses with 25 seats:", this.busCounts.seats25);

        console.log("Result for 60-seat buses:", result60);
        console.log("Result for 55-seat buses:", result55);
        console.log("Result for 25-seat buses:", result25);
      })
      .catch((error) => {
        console.error("Failed to fetch data:", error);
      });

      const today = new Date();
    const todayFormatted = today.toISOString().split('T')[0]; // Get today's date in the format "YYYY-MM-DD"

    axios
      .get("https://charm-ride.pockethost.io/api/collections/booking/records", {
        params: {
          created: todayFormatted,
        },
      })
      .then((response) => {
        this.numberOfBookings = response.data.totalItems; // Get the total number of bookings for today
      })
      .catch((error) => {
        console.error("Failed to fetch data:", error);
      });

      axios
      .get("https://charm-ride.pockethost.io/api/collections/users/records")
      .then((response) => {
        this.totalUsers = response.data.totalItems; // Get the total number of users from the API response
      })
      .catch((error) => {
        console.error("Failed to fetch data:", error);
      });



  },
};
</script>


