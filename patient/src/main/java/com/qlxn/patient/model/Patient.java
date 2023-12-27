package com.qlxn.patient.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientID;
    private String patientName;
    private String patientAddress;
    private String phone;
    private String email;
    private boolean gender;

    @Override
    public String toString() {
        return "Patient{" +
                "patientID=" + patientID +
                ", patientName='" + patientName + '\'' +
                ", patientAddress='" + patientAddress + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
