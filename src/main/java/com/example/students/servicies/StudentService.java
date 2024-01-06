package com.example.students.servicies;

import com.example.students.dto.CreateStudentDTO;
import com.example.students.dto.UpdateStudentDTO;
import com.example.students.entity.Student;
import com.example.students.repositories.StudentRepository;
import com.example.students.utils.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public Student create(CreateStudentDTO createStudentDTO) {
        return studentRepository.save(studentMapper.toStudent(createStudentDTO));
    }

    public List<Student> readAll() {
        return studentRepository.findAll();
    }


    public Student update(Long id, UpdateStudentDTO updateStudentDTO) {
        return studentRepository.save(studentMapper.updateStudentDTOToStudent(id, updateStudentDTO));
        // вытащить по id из базы студента
        // обновить поля этому студенту из дто, после вернуть студента
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
