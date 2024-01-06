package com.example.students.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentDTO {
    private String name;
    private String lastName;
    private String middleName;
}
