<template>
    <div class="body-wrapper">
        <div class="container-fluid pt-4 pb-4">
            <div class="row">
                <div class="col-lg-8">
                    <div class="card">
                        <div class="card-body">
                            <form @submit.prevent="submitForm">
                                <h3>Inspector Profile</h3>
                                <div class="mb-3">
                                    <label for="inputEmail" class="form-label">Name</label>
                                    <input type="text" class="form-control" id="inputEmail" v-model="Inspector.name"
                                        placeholder="Enter Name" />
                                    <!-- <p class="text-danger" v-if="!isValidname">Please enter a valid name.</p> -->
                                </div>
                                <div class="mb-3">
                                    <label for="inputFirstName" class="form-label">E-mail</label>
                                    <input type="email" class="form-control" id="inputFirstName" v-model="Inspector.email"
                                        placeholder="Enter Vehicle Name" />
                                    <!-- <p class="text-danger" v-if="!isValidvehiclename">Please enter a valid vehicle name.</p> -->
                                </div>
                                <div class="mb-3">
                                    <label for="inputLastName" class="form-label">Password</label>
                                    <input type="text" class="form-control" id="inputLastName" v-model="Inspector.password"
                                        placeholder="Enter Bus Type" />
                                    <!-- <p class="text-danger" v-if="!isValidbustype">Please enter a valid bus type.</p> -->
                                </div>
                                <div class="mb-3">
                                    <label for="inputUsername" class="form-label">phoneNumber</label>
                                    <input type="text" class="form-control" id="inputUsername" v-model="Inspector.phoneNumber"
                                        placeholder="Enter Seats" />
                                    <!-- <p class="text-danger" v-if="!isValidseats">Please enter a valid number of seats.</p> -->
                                </div>
                                <div class="mb-3">
                                    <label for="inputGender" class="form-label">address</label>
                                    <input type="text" class="form-control" id="inputGender" v-model="Inspector.address"
                                        placeholder="Enter Price" />
                                    <!-- <p class="text-danger" v-if="!isValidprice">Please enter a valid price.</p> -->
                                </div>
             

                                <button type="submit" class="btn btn-primary" style="margin-right: 10px">
                                    Update
                                </button>
                                <button type="button" @click="deleteBus(Bus.id)" class="btn btn-primary">
                                    Delete
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
import InspectorService from "../Services/InspectorService";

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
        };
    },
    created() {
        // Fetch patient data initially
        this.fetchInspectorData();

        // Set up polling to fetch data every 5 seconds (adjust the interval as needed)
        setInterval(this.fetchInspectorData, 15000); // Poll every 5 seconds
    },
    methods: {
        fetchInspectorData() {
            const Id = this.$route.params.Id;

            // Fetch patient data by patientId from the database using PatientService
            InspectorService.getInspectorById(Id)
                .then((response) => {
                    // Update the patient data in your component
                    this.Inspector = response.data;
                })
                .catch((error) => {
                    console.error("Error fetching Inspector data:", error);
                });
        },
        submitForm() {
            // Send the updated patient data to the Spring Boot API using PUT request
            InspectorService.updateInspector(this.Inspector)
                .then((response) => {
                    Swal.fire({
                        position: "top-end",
                        icon: "success",
                        title: "Your work has been saved",
                        showConfirmButton: false,
                        timer: 1500,
                    });
                    // Handle success (e.g., show a success message)
                    console.log("Inspector data updated successfully:", response.data);
                })
                .catch((error) => {
                    // Handle errors (e.g., show an error message)
                    console.error("Error updating Inspector data:", error);
                });
        },

        deleteInspector(Id) {
            Swal.fire({
                title: "Are you sure?",
                text: "You won't be able to revert this!",
                icon: "warning",
                showCancelButton: true,
                confirmButtonColor: "#3085d6",
                cancelButtonColor: "#d33",
                confirmButtonText: "Yes, delete it!",
            }).then((result) => {
                if (result.isConfirmed) {
                    InspectorService.DeleteInpector(Id)
                        .then((response) => {
                            // Handle success (e.g., show a success message)
                            console.log("Inspector deleted successfully:", response.data);

                            // After deleting, update the Patiens array by removing the deleted patient
                            this.Inspectors = this.Inspectors.filter(
                                (Inspector) => Inspector.Id !== Id
                            );

                            // Navigate to the desired route (if needed)
                            this.$router.push({ name: "Other" });
                        })
                        .catch((error) => {
                            // Handle errors (e.g., show an error message)
                            console.error("Error deleting Inspectors:", error);
                        });
                    Swal.fire("Deleted!", "Your file has been deleted.", "success");
                }
            });
            // Send a DELETE request to delete the patient using the same PatientService
        },
    },
};
</script>
