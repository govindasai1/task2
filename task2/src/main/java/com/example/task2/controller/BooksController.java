package com.example.task2.controller;

import com.example.task2.constants.Constants;
import com.example.task2.entity.Books;
import com.example.task2.models.BookRequest;
import com.example.task2.models.SuccessResponse;
import com.example.task2.service.BooksInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//        POST /books: Create a new book.
//        GET /books: Retrieve all books.
//        GET /books/{id}: Retrieve a book by ID.
//        PUT /books/{id}: Update an existing book.
//        DELETE /books/{id}: Delete a book by ID
@RestController
@RequestMapping(Constants.BOOKS)
public class BooksController {
    @Autowired
    BooksInterface bookService;
    @PostMapping()
    public SuccessResponse createBook(@RequestBody BookRequest book){
        return bookService.createBook(book);
    }
    @GetMapping()
    public List<List<Books>> retrieveAllBooks(){
        return bookService.retrieveAllBooks();
    }
    @GetMapping(Constants.UUID)
    public Books retrieveBookById(@PathVariable String uuid){
        return bookService.retrieveBookById(uuid);
    }
    @PutMapping(Constants.UUID)
    public SuccessResponse updateBook(@PathVariable String uuid,@RequestBody Books book){
return bookService.updateBook(uuid,book);
    }

    @DeleteMapping(Constants.UUID)
    public SuccessResponse removeBook(@PathVariable String uuid){
        return bookService.deleteBook(uuid);
    }
}
