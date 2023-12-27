package com.qlxn.patient.service;

import com.qlxn.patient.model.Patient;
import com.qlxn.patient.reponsitories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PatientServiceImpl implements PatientService{
    PatientRepository patientRepository;
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public String insertPatient(Patient patient) {
        patientRepository.save(patient);
        return "Success";
    }

    @Override
    public String updatePatient(Patient patient) {
        patientRepository.save(patient);
        return "Success";
    }

    @Override
    public boolean deletePatient(Integer patientID) {
        patientRepository.deleteById(patientID);
        return true;
    }

    @Override
    public Patient getPatient(Integer patientID) {

        return patientRepository.findById(patientID).get();
    }

    @Override
    public List<Patient> getAllPatient() {

        return patientRepository.findAll();
    }
}
