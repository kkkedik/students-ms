package com.example.students.controllers;

import com.example.students.entity.Book;
import com.example.students.servicies.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    public List<Book> readAll(){
        return bookService.readAll();
    }

}
