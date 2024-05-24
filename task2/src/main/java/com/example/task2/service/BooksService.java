package com.example.task2.service;

import com.example.task2.constants.Constants;
import com.example.task2.entity.Books;
import com.example.task2.entity.Publishers;
import com.example.task2.helper.ServiceHelper;
import com.example.task2.models.BookRequest;
import com.example.task2.models.SuccessResponse;
import com.example.task2.repository.BooksRepository;
import com.example.task2.repository.PublishersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BooksService implements BooksInterface {
    @Autowired
    BooksRepository booksRepo;
    @Autowired
    PublishersRepository publisherRepo;
    @Autowired
    PublishersInterface publishService;

    @Override
    public SuccessResponse createBook(BookRequest book) {
        Publishers publisher = publisherRepo.findById(UUID.fromString(book.publisherId)).get();
        Books books = new Books();
        books.setTitle(book.getTitle());
        books.setDescription(book.getDescription());
        books.setCategory(book.getCategory());
        books.setPublisher(publisher);
        booksRepo.save(books);
        return new SuccessResponse(Constants.BOOK_CREATED_SUCCESSFUL);
    }

    @Override
    public List<List<Books>> retrieveAllBooks() {

        var c = publisherRepo.findAll();
        List<UUID> uuids = new ArrayList<>();
        List<List<Books>> booksList = new ArrayList<>();
        c.forEach(cd->{
            uuids.add(cd.getId());
        });
         uuids.forEach(d->{booksList.add(booksRepo.getBooksForUser(d));});
         return booksList;
    }

    @Override
    public Books retrieveBookById(String id) {
        Books book = booksRepo.findById(UUID.fromString(id)).orElse(null);
        return ServiceHelper.handleBook(book);
    }

    @Override
    public SuccessResponse updateBook(String id, Books book) {
        Books books = retrieveBookById(id);
        books.setDescription(book.getDescription());
        books.setUpdatedAt(new Date());
        booksRepo.save(books);
        return new SuccessResponse(Constants.BOOK_UPDATE_SUCCESSFUL);
    }

    @Override
    public SuccessResponse deleteBook(String id) {
        retrieveBookById(id);
        booksRepo.deleteById(UUID.fromString(id));
        return new SuccessResponse(Constants.BOOK_DELETE_SUCCESSFUL);
    }
}
