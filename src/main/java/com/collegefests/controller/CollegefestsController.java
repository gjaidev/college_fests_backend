package com.collegefests.controller;

import com.collegefests.model.Event;
import com.collegefests.model.User;
import com.collegefests.model.UserRegistration;
import com.collegefests.service.EventService;
import com.collegefests.service.UserRegistrationService;
import com.collegefests.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollegefestsController {
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping(value = "/getAllEvents")
    public List<Event> getEventsData(){
        return eventService.getEvents();
    }

    @RequestMapping(value = "/getUserDetails",method = RequestMethod.GET)
    public User getUserData(@RequestParam String userName, @RequestParam String passWord){
        return userService.getUserByIdAndPwd(userName,passWord);
    }

    @RequestMapping(value = "/saveUserDetails",method = RequestMethod.PUT)
    public String saveUserData(@RequestBody User user){
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/publishEvent",method = RequestMethod.PUT)
    public Event publishAnEvent(@RequestBody Event event){
        return eventService.saveEvent(event);
    }

    @RequestMapping(value = "/registerToAnEvent",method = RequestMethod.PUT)
    public UserRegistration registerToEvent(@RequestBody UserRegistration userRegistration){
        return userRegistrationService.saveUserRegistration(userRegistration);
    }

    @RequestMapping(value = "/deleteEvent",method = RequestMethod.POST)
    public String deleteAnEvent(@RequestParam int eventId){
        return eventService.deleteEvent(eventId);
    }

}
