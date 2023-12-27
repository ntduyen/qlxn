package com.qlxn.patient.controller;

import com.qlxn.patient.model.Patient;
import com.qlxn.patient.model.ResponeObject;
import com.qlxn.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Patient")
@RequiredArgsConstructor
public class PatientController {

    @Autowired
    PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping("")
    List<Patient>  getAllPatients(){
        return patientService.getAllPatient();
         //   return List.of(new Patient(1L, "P1", "Adr1", "56", "", true));
    }

    @GetMapping("/{patientID}")
    ResponseEntity<ResponeObject> findById(@PathVariable("patientID") Integer patientID){
        Patient foundPatient = patientService.getPatient(patientID);
        if (foundPatient != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Query patient successfully " , foundPatient)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("Failed", "Cannot find patient with id = " + patientID, "")
            );
        }

    }
    @PostMapping("/insert")
   // http://localhost:8090/api/v1/Patient/insert
    ResponseEntity<ResponeObject> insertPatient(@RequestBody Patient newPatient){
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("OK", "Insert patient successfully", patientService.insertPatient(newPatient))
        );
    }
    @PutMapping ("/{patientID}")
    ResponseEntity<ResponeObject> updatePatient(@RequestBody Patient newPatient, @PathVariable int patientID){
        Patient optionalPatient = patientService.getPatient(patientID);

        if (optionalPatient != null){
            optionalPatient.setPatientName(newPatient.getPatientName());
            optionalPatient.setPatientAddress(newPatient.getPatientAddress());
            optionalPatient.setEmail(newPatient.getEmail());
            optionalPatient.setPhone(newPatient.getPhone());
            optionalPatient.setGender(newPatient.isGender());

            String updatedPatient = patientService.updatePatient(optionalPatient);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Update patient successfully", updatedPatient)
            );
        } else {
            newPatient.setPatientID(patientID);
            String updateNewPatient =  patientService.updatePatient(newPatient);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Patient not found. Created new patient entry with ID: " + patientID, updateNewPatient)
            );
        }
    }
    @DeleteMapping("/{patientID}")
    ResponseEntity<ResponeObject> deletePatient (@PathVariable Integer patientID) {
        boolean deleted = patientService.deletePatient(patientID);
        if (deleted) {
            //patientService.deletePatient(patientID);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK", "Delete patient successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("Failed", "Cannot find patient to delete", "")
        );
    }


}
