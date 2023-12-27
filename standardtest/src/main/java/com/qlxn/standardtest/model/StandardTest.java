package com.qlxn.standardtest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "StandardTest")
public class StandardTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer standardTestID;
    private String standardTestName;
    private String description;

    private Integer testTypeID;

    @Override
    public String toString() {
        return "StandardTest{" +
                "standardTestID=" + standardTestID +
                ", standardTestName='" + standardTestName + '\'' +
                ", description='" + description + '\'' +
                ", testTypeID=" + testTypeID +
                '}';
    }
}
