package com.example.students.repositories;

import com.example.students.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByStudentId(Long id);
    @Override
    @EntityGraph("student")
    Optional<Book> findById(Long id);
}
