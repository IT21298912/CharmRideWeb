package com.example.charmRides.repo;

import com.example.charmRides.modal.Booking;
import com.example.charmRides.modal.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface bookingRepository extends MongoRepository<Booking,String> {
}
