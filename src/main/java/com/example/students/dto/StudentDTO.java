package com.example.students.dto;


import lombok.*;

import java.util.List;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private String lastName;
    private String middleName;
    private List<Long> bookIds;

}
