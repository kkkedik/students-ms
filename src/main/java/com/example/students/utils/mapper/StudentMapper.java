package com.example.students.utils.mapper;

import com.example.students.dto.CreateStudentDTO;
import com.example.students.dto.StudentDTO;
import com.example.students.dto.UpdateStudentDTO;
import com.example.students.entity.Student;
import com.example.students.servicies.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

//mapStruct
@Component
@AllArgsConstructor
public class StudentMapper {
    private final BookService bookService;

    public Student toStudent(CreateStudentDTO createStudentDTO) {
        return Student.builder()
                .name(createStudentDTO.getName())
                .lastName(createStudentDTO.getLastName())
                .middleName(createStudentDTO.getMiddleName())
                .books(new ArrayList<>())
                .build();
    }

    public Student updateStudentDTOToStudent(Long id,UpdateStudentDTO updateStudentDTO) {
        return Student.builder()
                .id(id)
                .name(updateStudentDTO.getName())
                .lastName(updateStudentDTO.getName())
                .middleName(updateStudentDTO.getMiddleName())
                .books(bookService.readById(updateStudentDTO.getBookIds()))
                //.books(Stream.of(bookService.readById(studentDTO.getBookId())).collect(Collectors.toList()))
                .build();
    }

    public StudentDTO toStudentDTO(Student student){
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getName())
                .lastName(student.getLastName())
                .middleName(student.getMiddleName())
                .bookIds(student.getBooks().stream().map(book -> book.getId()).collect(Collectors.toList()))
                .build();
    }
}
