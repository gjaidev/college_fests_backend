package com.collegefests.service;

import com.collegefests.model.Event;
import com.collegefests.model.TicketDetails;
import com.collegefests.model.User;
import com.collegefests.model.UserRegistration;
import com.collegefests.repository.EventRepository;
import com.collegefests.repository.UserRegistrationRepository;
import com.collegefests.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;
    @Autowired
    private EventRepository eventRepository;

    public String saveUser(User user){
        List<User> allUsers = repository.findAll();
        for(int i=0;i<allUsers.size()-1;i++){
            if(allUsers.get(i).getUserName().equals(user.getUserName()) &&
                    allUsers.get(i).getEmail().equals(user.getEmail())){
                return "User already exists";
            }
        }
        repository.save(user);
        return "User saved";
    }

    public List<User> saveUsers(List<User> Users){
        return repository.saveAll(Users);
    }

    public List<User> getUsers(){
        return repository.findAll();
    }

    public User getUserById(int userId){
        return repository.findById(userId).orElse(null);
    }

    public User getUserByIdAndPwd(String userName,String passWord){
        List<User> allUsers = repository.findAll();
        User userDetails = new User();
        for(int i=0;i<allUsers.size();i++){
            if(allUsers.get(i).getUserName().equals(userName) && allUsers.get(i).getPassword().equals(passWord)){
                userDetails = allUsers.get(i);
                break;
            }
        }
        if(userDetails.getUserName()==null){
            userDetails.setUserId(0);
            userDetails.setUserName(null);
            userDetails.setPhoneNum(null);
            userDetails.setRole(null);
            userDetails.setPassword(null);
            userDetails.setEmail(null);
        }
        return userDetails;
    }

    public String deleteUser(int userId){
        repository.deleteById(userId);
        return "User deleted";
    }

    public User updateUser(User user){
        User existingUser= repository.findById(user.getUserId()).orElse(null);
        existingUser.setEmail(user.getEmail());
        existingUser.setUserName(user.getUserName());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setPhoneNum(user.getPhoneNum());
        return repository.save(existingUser);
    }

    public List<TicketDetails> getTicketDetails(int userId) {
        List<TicketDetails> ticketDetails = new ArrayList<>();
        User existingUser = getUserById(userId);
        List<UserRegistration> userRegisteredEvents = userRegistrationRepository.findAll();
        List<UserRegistration> reqEvents = new ArrayList<>();
        for(int j=0;j<userRegisteredEvents.size();j++){
            if(userRegisteredEvents.get(j).getUserId()==userId){
                reqEvents.add(userRegisteredEvents.get(j));
            }
        }
        for(int i=0;i<reqEvents.size();i++)
        {
            TicketDetails newTicketDetails = new TicketDetails();
            Event event = eventRepository.findById(reqEvents.get(i).getEventId()).orElse(null);
            newTicketDetails.setEventName(event.getEventName());
            newTicketDetails.setEventDescription(event.getEventDescription());
            newTicketDetails.setEventLocation(event.getEventLocation());
            newTicketDetails.setDate(event.getDate());
            newTicketDetails.setTime(event.getTime());
            newTicketDetails.setUserName(existingUser.getUserName());
            ticketDetails.add(newTicketDetails);
        }
        return ticketDetails;
    }
}
