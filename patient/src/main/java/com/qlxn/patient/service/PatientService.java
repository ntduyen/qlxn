package com.qlxn.patient.service;

import com.qlxn.patient.model.Patient;

import java.util.List;

public interface PatientService {
    public String insertPatient(Patient patient);
    public String updatePatient(Patient patient);
    public boolean deletePatient(Integer patientID);
    public Patient getPatient(Integer patientID);
    public List<Patient> getAllPatient();


}
