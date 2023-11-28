package com.example.charmRides.service;

import com.example.charmRides.modal.Bus;
import com.example.charmRides.modal.Complaint;

import java.util.List;

public interface complaintService {
    Complaint addComplaint(Complaint complaint);

    List<Complaint> getComplaints();

    Complaint getComplaintById(String compid);

    Complaint updateComplaint(String cid);
    public Complaint declineComplaint(String cid);

    String deleteComplaint(String cid);
}
