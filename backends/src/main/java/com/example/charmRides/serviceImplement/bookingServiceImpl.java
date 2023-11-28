package com.example.charmRides.serviceImplement;


import com.example.charmRides.modal.Booking;
import com.example.charmRides.repo.bookingRepository;
import com.example.charmRides.service.bookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookingServiceImpl implements bookingService {
    @Autowired
    private bookingRepository brepo;


    @Override
    public Booking addBus(Booking booking) {
        return brepo.save(booking);
    }

    @Override
    public List<Booking> getBookings() {
        return brepo.findAll();
    }
}
