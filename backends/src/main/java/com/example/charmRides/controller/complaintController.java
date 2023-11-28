package com.example.charmRides.controller;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.modal.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.charmRides.service.complaintService;

import java.util.List;

@RestController
@RequestMapping("/complaint")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class complaintController {

    @Autowired
    private complaintService cservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Complaint insertComplaint(@RequestBody Complaint complaint) {

        return cservice.addComplaint(complaint);
    }


    @GetMapping
    public List<Complaint> fetchComplaints() {
        return cservice.getComplaints();
    }

    @GetMapping("/{cid}")
    public Complaint getComplaintId(@PathVariable String cid){
        return cservice.getComplaintById(cid);
    }

    @DeleteMapping("/{cid}")
    public String removeComplaint(@PathVariable String cid){
        return cservice.deleteComplaint(cid);
    }

    @PutMapping("/{cid}")
    public Complaint updatecomplaint(@PathVariable String cid){
        return cservice.updateComplaint(cid);
    }

    @PutMapping("/decline/{cid}")
    public Complaint declinecomplaint(@PathVariable String cid){
        return cservice.declineComplaint(cid);
    }





}
