package com.example.task2.controller;

import com.example.task2.Utis;
import com.example.task2.entity.Publishers;
import com.example.task2.repository.PublishersRepository;
import com.example.task2.service.PublishersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PublishersController.class)
public class PublisherControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PublishersRepository publishersRepo;
    @InjectMocks
    private PublishersController publisherController;
    @MockBean
    private PublishersService publishersService;
    Publishers publisher = Utis.createMockPublisher();

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PublishersController()).build();
    }

    @Test
    public void createPublisherTest() throws Exception {

//      SuccessResponse result = publisherService.createPublisher(publisher);
//        Assertions.assertEquals(result.message,Constants.PUBLISHER_CREATED_SUCCESSFUL);
        List<Publishers> list = new ArrayList<>();
        list.add(publisher);
        when(publishersRepo.findAll()).thenReturn(list);
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/publishers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
