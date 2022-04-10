package com.collegefests.service;

import com.collegefests.model.UserRegistration;
import com.collegefests.repository.UserRegistrationRepository;
import com.collegefests.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRegistrationService {
    @Autowired
    private UserRegistrationRepository repository;

    public UserRegistration saveUserRegistration(UserRegistration userRegistration){
        return repository.save(userRegistration);
    }

    public List<UserRegistration> saveUsers(List<UserRegistration> userRegistrations){
        return repository.saveAll(userRegistrations);
    }

    public List<UserRegistration> getUserRegistrations(){
        return repository.findAll();
    }

    public UserRegistration getUserRegistrationById(int user_id){
        return repository.findById(user_id).orElse(null);
    }

    public String deleteUserRegistration(int user_id){
        repository.deleteById(user_id);
        return "User registration deleted";
    }

    public UserRegistration updateUserRegistration(UserRegistration userRegistration){
        UserRegistration existingUser= repository.findById(userRegistration.getUserId()).orElse(null);
        existingUser.setEmail(existingUser.getEmail());
        existingUser.setEventId(existingUser.getEventId());
        existingUser.setEventName(existingUser.getEventName());
        existingUser.setPhone(existingUser.getPhone());
        return repository.save(existingUser);
    }
}
