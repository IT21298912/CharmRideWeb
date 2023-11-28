package com.example.charmRides.repo;

import com.example.charmRides.modal.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface complaintRepository extends MongoRepository<Complaint,String> {
}
