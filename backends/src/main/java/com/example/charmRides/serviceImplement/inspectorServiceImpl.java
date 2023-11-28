package com.example.charmRides.serviceImplement;

import com.example.charmRides.modal.Complaint;
import com.example.charmRides.modal.Inspector;
import com.example.charmRides.repo.inspectorRepository;
import com.example.charmRides.service.inspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inspectorServiceImpl implements inspectorService {

    @Autowired
    private inspectorRepository repo;

    @Override
    public Inspector addInspector(Inspector inspector) {

        return repo.save(inspector);
    }

    @Override
    public List<Inspector> getInspector() {
        return repo.findAll();
    }

    @Override
    public Inspector getInspectorById(String Id) {
        return repo.findById(Id).orElse(null);
    }

    @Override
    public Inspector updateInspector(Inspector inspectorreq) {
        Inspector exinspector = repo.findById(inspectorreq.getId()).orElse(null);
        if (exinspector != null) {
            exinspector.setName(inspectorreq.getName());
            exinspector.setEmail(inspectorreq.getEmail());
            exinspector.setAddress(inspectorreq.getAddress());
            exinspector.setPhoneNumber(inspectorreq.getPhoneNumber());
            exinspector.setPassword(inspectorreq.getPassword());

        }
        return repo.save(exinspector);
    }

    @Override
    public String deleteInspector(String Id) {
        repo.deleteById(Id);
        return Id+"patient deleted from the dashboard";
    }
}
