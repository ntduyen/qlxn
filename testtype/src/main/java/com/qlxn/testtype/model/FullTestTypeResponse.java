package com.qlxn.testtype.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class FullTestTypeResponse {
    private String testTypeName;
    private String description;
    List<StandardTest> standardTest;

}
