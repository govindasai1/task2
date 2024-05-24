package com.example.task2.service;

import com.example.task2.Utis;
import com.example.task2.constants.Constants;
import com.example.task2.entity.Books;
import com.example.task2.entity.Publishers;
import com.example.task2.models.BookRequest;
import com.example.task2.models.SuccessResponse;
import com.example.task2.repository.BooksRepository;
import com.example.task2.repository.PublishersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.print.Book;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookServiceTest {
    @InjectMocks
    BooksService booksService;
    @Mock
    private BooksRepository booksRepo;
    @Mock
    private PublishersRepository publishersRepo;
    Publishers publisher = Utis.createMockPublisher();
    Books book = Utis.createMockBook();
    BookRequest bookRequest = Utis.updateBookRequest();

//    @Test
    public void createBookTest() {
        when(publishersRepo.findById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"))).thenReturn(Optional.ofNullable(publisher));
        when(booksRepo.save(book)).thenReturn(book);
        SuccessResponse result = booksService.createBook(bookRequest);
        Assertions.assertEquals(Constants.BOOK_CREATED_SUCCESSFUL,result.message);
    }
}
