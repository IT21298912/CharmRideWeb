package com.example.charmRides.controller;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.modal.Inspector;
import com.example.charmRides.service.inspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inspector")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class inspectorController {
    @Autowired
    private inspectorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inspector insertInspector(@RequestBody Inspector inspector) {

        return service.addInspector(inspector);
    }

    @GetMapping
    public List<Inspector> fetchInspectors() {
        return service.getInspector();
    }

    @GetMapping("/{Id}")
    public Inspector getInspectorById(@PathVariable String Id){
        return service.getInspectorById(Id);
    }

    @PutMapping
    public Inspector modifyInspectror(@RequestBody Inspector inspector){
        return service.updateInspector(inspector);
    }

    @DeleteMapping("/{Id}")
    public String removeInspector(@PathVariable String Id){
        return service.deleteInspector(Id);
    }

}
