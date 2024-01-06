package com.example.students.controllers;

import com.example.students.dto.CreateStudentDTO;
import com.example.students.dto.StudentDTO;
import com.example.students.dto.UpdateStudentDTO;
import com.example.students.entity.Student;
import com.example.students.servicies.StudentService;
import com.example.students.utils.mapper.StudentMapper;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @PostMapping
    public StudentDTO create(@RequestBody CreateStudentDTO createStudentDTO) {
        Student student = studentService.create(createStudentDTO);
        return studentMapper.toStudentDTO(student);
        //контроллер>сервис>маппер
    }

    @GetMapping
    public List<Student> readAll() {
        return studentService.readAll();
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody UpdateStudentDTO updateStudentDTO) {
        return studentService.update(id, updateStudentDTO);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        studentService.delete(id);
        return HttpStatus.OK;
    }

}
