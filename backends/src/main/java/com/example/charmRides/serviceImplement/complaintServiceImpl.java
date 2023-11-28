package com.example.charmRides.serviceImplement;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.modal.Complaint;
import com.example.charmRides.repo.complaintRepository;
import com.example.charmRides.service.complaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class complaintServiceImpl implements complaintService {
    @Autowired
    private complaintRepository crepo;

    @Override
    public Complaint addComplaint(Complaint complaint) {
        return crepo.save(complaint);
    }

    @Override
    public List<Complaint> getComplaints() {
        return crepo.findAll();
    }

    @Override
    public Complaint getComplaintById(String compid) {
        return crepo.findById(compid).orElse(null);
    }

    @Override
    public Complaint updateComplaint(String cid) {
        Complaint existcomp = crepo.findById(cid).orElse(null);
        if (existcomp != null) {
            existcomp.setStatus("Resolved");

        }
        return crepo.save(existcomp);
    }

    public Complaint declineComplaint(String cid) {
        Complaint existcomp = crepo.findById(cid).orElse(null);
        if (existcomp != null) {
            existcomp.setStatus("Decline");

        }
        return crepo.save(existcomp);
    }

        @Override
        public String deleteComplaint (String cid){
            crepo.deleteById(cid);
            return cid + "patient deleted from the dashboard";
        }


}