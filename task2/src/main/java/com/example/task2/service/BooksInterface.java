package com.example.task2.service;

import com.example.task2.entity.Books;
import com.example.task2.models.BookRequest;
import com.example.task2.models.SuccessResponse;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;


@Service
public interface BooksInterface {
    public SuccessResponse createBook(BookRequest book);
    public List<List<Books>> retrieveAllBooks();
    public Books retrieveBookById(String id);
    public SuccessResponse updateBook(String id,Books book);
    public SuccessResponse deleteBook(String id);
}
