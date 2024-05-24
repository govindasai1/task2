package com.example.task2.controller;

import com.example.task2.constants.Constants;
import com.example.task2.entity.Publishers;
import com.example.task2.models.SuccessResponse;
import com.example.task2.service.PublishersInterface;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(Constants.PUBLISHERS)
public class PublishersController {
    @Autowired
    PublishersInterface publishersService;
    @PostMapping()
    public SuccessResponse createPublisher(@RequestBody @Valid Publishers publisher){
        return publishersService.createPublisher(publisher);
    }
    @GetMapping()
    public List<Publishers> retrieveAllBooks(){
        return publishersService.retrieveAllBooks();
    }
    @GetMapping(Constants.UUID)
    public Publishers retrievePublisherById(@PathVariable String uuid){
        return publishersService.retrievePublisherById(uuid);
    }
    @PutMapping(Constants.UUID)
    public SuccessResponse updatePublisher(@PathVariable String uuid,@RequestBody Publishers publisher){
        return publishersService.updatePublisher(uuid,publisher);
    }
    @DeleteMapping(Constants.UUID)
    public SuccessResponse deletePublisher(String uuid){
        return publishersService.deletePublisher(uuid);
    }

}
