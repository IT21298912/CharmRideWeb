<script setup>
import { RouterLink, RouterView } from 'vue-router'
import OverView from './components/OverView.vue';
import SideBar from './components/SideBar.vue'
import Headers from './components/Headers.vue'
import Profile from './components/Profile.vue'
import BusManagement from './components/BusManagement.vue'
import OtherManagement from './components/OtherManagement.vue'
// import PatientManagement from './components/PatientManagement.vue'
import Login from './components/Login.vue'
import Register from './components/Register.vue'

// export default {
//   name: 'App',
//   components: {
//     PatientManagement
//   }
// }

</script>

<template>
  <!-- <Headers/>
  <SideBar/> -->
    <Headers v-if="$route.path !== '/' && $route.path !== '/login' && $route.path !== '/registre'" />
    <SideBar v-if="$route.path !== '/' && $route.path !== '/login' && $route.path !== '/registre'" />
  <!-- <OverView/> -->
  <!-- <Profile/> -->
  <!-- <StaffManagement/> -->
  <!-- <PatientManagement/> -->
  <!-- <DoctorManagement/> -->
  <!-- <Login/> -->
  <!-- <Register/> -->
  <RouterView />
</template>

<style scoped>

</style>
