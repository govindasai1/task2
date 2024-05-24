package com.example.task2.service;

import com.example.task2.entity.Books;
import com.example.task2.entity.Publishers;
import com.example.task2.models.SuccessResponse;
import org.springframework.stereotype.Service;

import java.util.List;

//        POST /publishers: Create a new publisher.
//        GET /publishers: Retrieve all publishers.
//        GET /publishers/{id}: Retrieve a publisher by ID.
//        PUT /publishers/{id}: Update an existing publisher.
//        DELETE /publishers/{id}: Delete a publisher by ID.
@Service
public interface PublishersInterface {
    public SuccessResponse createPublisher(Publishers publisher);
    public List<Publishers> retrieveAllBooks();
    public Publishers retrievePublisherById(String id);
    public SuccessResponse updatePublisher(String uuid,Publishers publisher);
    public SuccessResponse deletePublisher(String id);
}
