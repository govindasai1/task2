package com.example.task2.service;

import com.example.task2.constants.Constants;
import com.example.task2.entity.Publishers;
import com.example.task2.helper.ServiceHelper;
import com.example.task2.models.SuccessResponse;
import com.example.task2.repository.PublishersRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class PublishersService implements PublishersInterface {
    @Autowired
    PublishersRepository publishersRepo;

    @Override
    public SuccessResponse createPublisher(Publishers publisher) {
        publishersRepo.save(publisher);
        return new SuccessResponse(Constants.PUBLISHER_CREATED_SUCCESSFUL);
    }

    @Override
    public List<Publishers> retrieveAllBooks() {
        return publishersRepo.findAll();
    }

    @Override
    public Publishers retrievePublisherById(String id) {
         Publishers publisher = publishersRepo.findById(UUID.fromString(id)).orElse(null);
         return ServiceHelper.handlePublisher(publisher);
    }

    @Override
    public SuccessResponse updatePublisher(String uuid,Publishers publisher) {
       Publishers publishers = retrievePublisherById(uuid);
       publishers.setAddress(publisher.getAddress());
       publishers.setUpdatedAt(new Date());
       publishersRepo.save(publishers);
       return new SuccessResponse(Constants.PUBLISHER_UPDATE_SUCCESSFUL);
    }

    @Override
    public SuccessResponse deletePublisher(String id) {
        retrievePublisherById(id);
        publishersRepo.deleteById(UUID.fromString(id));
        return new SuccessResponse(Constants.PUBLISHER_DELETE_SUCCESSFUL);
    }
}

