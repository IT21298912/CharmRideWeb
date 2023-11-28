package com.example.charmRides.service;

import com.example.charmRides.dto.MloginDto;
import com.example.charmRides.modal.Manager;

import java.util.Optional;

public interface managerService {

    Manager register(Manager manager);

    //    Optional<Patient> findPatient(String email);
    Optional<Manager> findManager(String email);
    //    Optional<LoginDao> loginPatient(String email,String password);
    Optional<MloginDto> loginManager(String email, String password);

}
