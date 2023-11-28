package com.example.charmRides.controller;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.service.busService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
@CrossOrigin("http://localhost:5173") // Removed trailing slash

public class busController {
    @Autowired
    private busService bService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bus insertBus(@RequestBody Bus bus) {

        return bService.addBus(bus);
    }

    @GetMapping
    public List<Bus> fetchbuses() {
        return bService.getBus();
    }

    @GetMapping("/{buid}")
    public Bus getBusbyid(@PathVariable String buid){
        return bService.getBusByid(buid);
    }

    @PutMapping
    public Bus modifyBus(@RequestBody Bus busreq){
        return bService.updateBus(busreq);
    }

    @DeleteMapping("{buid}")
    public String deleteBus(@PathVariable String buid){
        bService.deleteBus(buid);
        return buid+"deleted";}



}


