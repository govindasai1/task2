package com.example.task2.service;

import com.example.task2.Utis;
import com.example.task2.constants.Constants;
import com.example.task2.entity.Publishers;
import com.example.task2.exception.CommonException;
import com.example.task2.models.SuccessResponse;
import com.example.task2.repository.PublishersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PublisherServiceTest {
    @InjectMocks
    PublishersService publicService;
    @Mock
    private PublishersRepository publishersRepo;

    Publishers publisher = Utis.createMockPublisher();
    Publishers updateRequest = Utis.updateRequest("greek");

    @Test
    public void createPublisherTest() {

        when(publishersRepo.save(publisher)).thenReturn(publisher);
        SuccessResponse result = publicService.createPublisher(publisher);
        Assertions.assertEquals(result.message, Constants.PUBLISHER_CREATED_SUCCESSFUL);
    }

    @Test
    public void retrieveAllBooksTest() {
        List<Publishers> list = new ArrayList<>();
        list.add(publisher);
        when(publishersRepo.findAll()).thenReturn(list);
        List<Publishers> result = publicService.retrieveAllBooks();
        Assertions.assertEquals(result, list);
    }

    @Test
    public void retrievePublisherById() {
        when(publishersRepo.findById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"))).thenReturn(Optional.ofNullable(publisher));
        Publishers result = publicService.retrievePublisherById("6fd8baf9-a481-40b2-81e4-6e793ad06a79");
        Assertions.assertEquals(publisher, result);
    }

    @Test
    public void retrievePublisherByIdException() {
        when(publishersRepo.findById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"))).thenReturn(Optional.empty());
        assertThrows(CommonException.class, () -> {
            publicService.retrievePublisherById("6fd8baf9-a481-40b2-81e4-6e793ad06a79");
            ;
        });
    }

    @Test
    public void updatePublisherTest() {
        when(publishersRepo.findById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"))).thenReturn(Optional.ofNullable(publisher));
        when(publishersRepo.save(publisher)).thenReturn(publisher);
        SuccessResponse response = publicService.updatePublisher("6fd8baf9-a481-40b2-81e4-6e793ad06a79", updateRequest);
        Assertions.assertEquals(Constants.PUBLISHER_UPDATE_SUCCESSFUL, response.message);
    }

    @Test
    public void deletePublisherByIdTest() {
        when(publishersRepo.findById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"))).thenReturn(Optional.ofNullable(publisher));
        doNothing().when(publishersRepo).deleteById(UUID.fromString("6fd8baf9-a481-40b2-81e4-6e793ad06a79"));
        SuccessResponse result = publicService.deletePublisher("6fd8baf9-a481-40b2-81e4-6e793ad06a79");
        Assertions.assertEquals(Constants.PUBLISHER_DELETE_SUCCESSFUL, result.message);
    }

    @Test
    public void deletePublisherByIdTestCommonException() {
        assertThrows(CommonException.class, () -> {
            publicService.deletePublisher("6fd8baf9-a481-40b2-81e4-6e793ad06a79");
        });
    }
}
