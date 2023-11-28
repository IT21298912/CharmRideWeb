package com.example.charmRides.controller;

import com.example.charmRides.modal.Booking;
import com.example.charmRides.modal.Bus;
import com.example.charmRides.service.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class bookingController {

    @Autowired
    private bookingService bservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Booking insertBooking(@RequestBody Booking booking) {

        return bservice.addBus(booking);
    }

    @GetMapping
    public List<Booking> fetchBooking() {
        return bservice.getBookings();
    }
}
