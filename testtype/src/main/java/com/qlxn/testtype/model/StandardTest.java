package com.qlxn.testtype.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardTest {
    private String standardTestName;
    private String description;
}
