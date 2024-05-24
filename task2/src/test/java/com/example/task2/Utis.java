package com.example.task2;

import com.example.task2.entity.Books;
import com.example.task2.entity.Publishers;
import com.example.task2.models.BookRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Utis {
    public static Publishers createMockPublisher() {
        Publishers publisher = new Publishers();
        publisher.setId(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"));
        publisher.setName("stan lee");
        publisher.setAddress("york");
publisher.setCreatedAt(new Date());
publisher.setUpdatedAt(new Date());
        List<Books> booksList = new ArrayList<>();
        publisher.setBooks(booksList);

        return publisher;
    }
    public static Publishers updateRequest(String address){
        Publishers publisher = new Publishers();
        publisher.setAddress(address);
        return publisher;
    }
    public static Books createMockBook(){
        Books book = new Books();
        book.setId(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a70"));
        book.setTitle("Infinity War");
        book.setDescription("book of avengers");
        book.setCategory("comic");
        book.setCreatedAt(new Date());
        return book;
    }
    public static BookRequest updateBookRequest(){
        BookRequest book = new BookRequest();
        book.setTitle("Infinity War");
        book.setDescription("book of avengers");
        book.setCategory("comic");
        book.setPublisherId("6fd8baf9-a481-40b2-81e4-6e793ad06a79");
        return book;
    }
}
