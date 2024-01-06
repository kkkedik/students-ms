package com.example.students.servicies;

import com.example.students.entity.Book;
import com.example.students.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> readAll(){
        return bookRepository.findAll();
    }

    public Book readById(Long id){
        return bookRepository.findById(id).orElseThrow(()->
                new RuntimeException("Book not found"));
    }

    public List<Book> readById(List<Long> ids){
        return bookRepository.findAllById(ids);
    }

}
