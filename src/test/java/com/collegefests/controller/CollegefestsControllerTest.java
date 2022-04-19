package com.collegefests.controller;

import com.collegefests.main.CollegefestsApplication;
import com.collegefests.model.Event;
import com.collegefests.model.User;
import com.collegefests.repository.EventRepository;
import com.collegefests.repository.UserRegistrationRepository;
import com.collegefests.repository.UserRepository;
import com.collegefests.service.EventService;
import com.collegefests.service.UserRegistrationService;
import com.collegefests.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = CollegefestsApplication.class)
public class CollegefestsControllerTest {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRegistrationService userRegistrationService;
    @MockBean
    private EventRepository eventRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserRegistrationRepository userRegistrationRepository;
    @Test
    void getAllEventsData() {
        Event event1 = new Event();
        Event event2 = new Event();
        event1.setEventId(1);
        event1.setEventLocation("Denton");
        event1.setTime("4:50PM");
        event1.setDate("2022-11-11");
        event1.setEventName("UNT Fest");
        event1.setEventOrganiser("Jaidev");
        event1.setPhone("9407581522");
        event1.setFees("200$");
        event1.setEventDescription("This is a fest for all techy guys");
        event2.setEventId(2);
        event2.setEventLocation("Denton");
        event2.setTime("5:50PM");
        event2.setDate("2022-11-10");
        event2.setEventName("UNT Fest2");
        event2.setEventOrganiser("Jaidev");
        event2.setPhone("9407581522");
        event2.setFees("2000$");
        event2.setEventDescription("This is a fest for everyone");
        when(eventRepository.findAll()).thenReturn(Stream.of(event1,event2).collect(Collectors.toList()));
        assertEquals(Arrays.asList(event1,event2),eventService.getEvents());
        assertEquals(2,eventService.getEvents().size());
    }

    @Test
    void getValidUserData() {
        User user1= new User();
        User user2= new User();
        user1.setUserId(1);
        user1.setUserName("jaidev");
        user1.setPassword("root");
        user1.setRole("user");
        user1.setEmail("jaidev1995@gmail.com");
        user1.setPhoneNum("9550504737");
        user2.setUserId(2);
        user2.setUserName("akshay");
        user2.setPassword("root");
        user2.setRole("user");
        user2.setEmail("akshay1995@gmail.com");
        user2.setPhoneNum("9550504736");
        when(userRepository.findAll()).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
        assertEquals(user1,userService.getUserByIdAndPwd("jaidev","root"));
        assertEquals(user2,userService.getUserByIdAndPwd("akshay","root"));
        assertEquals(null,userService.getUserByIdAndPwd("test","root").getEmail());
        assertEquals(0,userService.getUserByIdAndPwd("test","root").getUserId());

    }

    @Test
    void printTicketDetails() {

    }

    @Test
    void saveUserData() {
    }

    @Test
    void publishAnEvent() {
    }

    @Test
    void registerToEvent() {
    }

    @Test
    void deleteAnEvent() {
    }
}