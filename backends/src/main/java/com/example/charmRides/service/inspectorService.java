package com.example.charmRides.service;

import com.example.charmRides.modal.Complaint;
import com.example.charmRides.modal.Inspector;

import java.util.List;

public interface inspectorService {

    Inspector addInspector(Inspector inspector);

    List<Inspector> getInspector();

    Inspector getInspectorById(String Id);

    Inspector updateInspector(Inspector inspector);

    String deleteInspector(String Id);
}
