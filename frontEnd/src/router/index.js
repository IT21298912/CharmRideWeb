import { createRouter, createWebHistory } from 'vue-router'

import Bman from '../components/BusManagement.vue'
import other from '../components/OtherManagement.vue'
import Overview from '../components/OverView.vue'
import Profile from '../components/Profile.vue'
import login from '../components/Login.vue'
import registre from '../components/Register.vue'
///import Pprofile from '../components/PatientProfile.vue'
//import Dprofile from '../components/DoctorProfile.vue'
//import viewPro from '../components/ViewPatientPro.vue'
//import docPro from '../components/ViewDoctorPro.vue';
import log from '../components/Login.vue';
import addbus from '../components/busAdd.vue';
import addIns from '../components/InsAdd.vue';
import viewB from '../components/viewBus.vue';
import viewI from '../components/viewInspector.vue';
import book from '../components/Booking.vue';
import trip from '../components/Trips.vue';


const routes = [
  
  {path: '/',component: log },
  { path: '/Overview',name:'Overview', component: Overview },
  { path: '/BusManagement',name:'Bman', component: Bman },
  { path: '/addbus', component: addbus },
  { path: '/OtherManagement', name:'Other', component: other },
  { path: '/Profile', component: Profile },
  { path: '/registre', component: registre },
  { path: '/addIns', component: addIns },
  { path: '/viewB/:buid', name:'viewB', component: viewB},
  { path: '/viewI/:Id', name:'viewI', component: viewI},
  { path: '/book', component: book },
  { path: '/trip', component: trip },

  
  // { path: '/login', component: login },
  // { path: '/Pprofile', component: Pprofile },
  // { path: '/Dprofile', component: Dprofile },
  // { path: '/viewPro/:patientId', name:'viewPro', component: viewPro },
  //  { path: '/docPro/:doctorid', name:'docPro', component: docPro},
  
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router
