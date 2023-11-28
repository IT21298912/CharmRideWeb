package com.example.charmRides.service;

import com.example.charmRides.modal.Booking;
import com.example.charmRides.modal.Bus;

import java.util.List;

public interface bookingService {

    Booking addBus(Booking booking);
    List<Booking> getBookings();
}
