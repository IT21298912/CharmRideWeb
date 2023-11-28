package com.example.charmRides.controller;

import com.example.charmRides.dto.MloginDto;
import com.example.charmRides.exception.ResourceNotFound;
import com.example.charmRides.modal.Manager;
import com.example.charmRides.service.managerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class managerController {
    @Autowired
    private managerService manservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Manager register(@RequestBody Manager manager){
        return manservice.register(manager);
    }

    @GetMapping("/exist/manager/{email}")
    public ResponseEntity<Manager> findManager(@PathVariable(value = "email") String email){
        Manager resMan = manservice.findManager(email).orElseThrow(
                ()->new ResourceNotFound("Manager Not exist with Email " +email)
        );
        return ResponseEntity.ok(resMan);
    }

    @PostMapping("/login/manager")
    public ResponseEntity<MloginDto> loginManager(@RequestBody MloginDto loginDao){
        MloginDto logRes = manservice.loginManager(loginDao.getEmail(), loginDao.getPassword()).orElseThrow(
                ()->new ResourceNotFound("mail And Password Error")
        );
        return ResponseEntity.ok(logRes);
    }
}
