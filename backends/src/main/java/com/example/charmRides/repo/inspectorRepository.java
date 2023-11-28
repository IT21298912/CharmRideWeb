package com.example.charmRides.repo;

import com.example.charmRides.modal.Inspector;
import com.example.charmRides.modal.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface inspectorRepository extends MongoRepository<Inspector,String> {

}
