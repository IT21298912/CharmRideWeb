package com.example.charmRides.repo;

import com.example.charmRides.modal.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface busRepository extends MongoRepository<Bus,String> {
}
