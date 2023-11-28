package com.example.charmRides.repo;

import com.example.charmRides.dto.MloginDto;
import com.example.charmRides.modal.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface managerRepository extends MongoRepository<Manager,String> {

    Optional<Manager> findByEmail(String email);

    Optional<MloginDto> findByEmailAndPassword(String email, String password);
}
