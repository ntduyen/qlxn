package com.qlxn.testtype.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "TestType")
public class TestType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer testTypeID;
    private String testTypeName;
    private String description;

    @Override
    public String toString() {
        return "TestType{" +
                "testTypeID=" + testTypeID +
                ", testTypeName='" + testTypeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
