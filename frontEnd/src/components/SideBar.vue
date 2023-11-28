<template>
  <aside className="left-sidebar shadow-sm">
      <div>
        <div className="brand-logo d-flex align-items-center justify-content-between">
          <h3 className='fw-bolder'>Charm Rides Management</h3> 
         <img src="../assets/images/logos/logo.jpg" alt="" width={150} />
        </div>
        <nav className="sidebar-nav scroll-sidebar mt-3" data-simplebar="">
          <ul id="sidebarnav">
            <li className="nav-small-cap mt-2">
              <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span className="hide-menu">Home</span>
            </li>
            <li className="sidebar-item">
              <router-link to="/Overview" class="sidebar-item" aria-expanded="false">
              <a className="sidebar-link">
                <span>
                  <i className="ti ti-layout-dashboard"></i>
                </span>
                <span className="hide-menu">Dashboard</span>
              </a>
              </router-link>
            </li>
            <li className="nav-small-cap">
              <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span className="hide-menu">Managements</span>
            </li>

            <router-link to="/BusManagement" class="sidebar-item" aria-expanded="false">
<a class="sidebar-link">
  <span>
    <i class="ti ti-article"></i>
  </span>
  <span class="hide-menu">Bus Management</span>
</a>
</router-link>


            <router-link to="/OtherManagement" class="sidebar-item" aria-expanded="false">
<a class="sidebar-link">
  <span>
    <i class="ti ti-article"></i>
  </span>
  <span class="hide-menu">Inspector Management</span>
</a>
</router-link>

<router-link to="/book" class="sidebar-item" aria-expanded="false">
<a class="sidebar-link">
  <span>
    <i class="ti ti-article"></i>
  </span>
  <span class="hide-menu">Booking List</span>
</a>
</router-link>

<router-link to="/trip" class="sidebar-item" aria-expanded="false">
<a class="sidebar-link">
  <span>
    <i class="ti ti-article"></i>
  </span>
  <span class="hide-menu">Trips</span>
</a>
</router-link>


        


            <li className="nav-small-cap">
              <i className="ti ti-dots nav-small-cap-icon fs-4"></i>
              <span className="hide-menu">AUTH</span>
            </li>
                    <li className="sidebar-item">
                      <router-link to="/Profile" class="sidebar-link" aria-expanded="false">
               <span>
               <i class="ti ti-user"></i>
               </span>
                <span class="hide-menu">My Profile</span>
</router-link>

<router-link to="/" class="sidebar-link" aria-expanded="false">
                <span>
                  <i className="ti ti-login"></i>
                </span>
                <span className="hide-menu">Logout</span>
              </router-link>
            </li>
          </ul>
        </nav>
      </div>
    </aside>
</template>
<style>
.simplebar-placeholder{
  display: none  !important;;
}
</style>