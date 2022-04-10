package com.collegefests.service;

import com.collegefests.model.User;
import com.collegefests.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository repository;

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

    public User getUserById(int user_id){
        return repository.findById(user_id).orElse(null);
    }

    public User getUserByIdAndPwd(String userName,String passWord){
        List<User> allUsers = repository.findAll();
        User userDetails = new User();
        for(int i=0;i<allUsers.size()-1;i++){
            if(allUsers.get(i).getUserName().equals(userName) && allUsers.get(i).getPassword().equals(passWord)){
                userDetails = allUsers.get(i);
                break;
            }
        }
        if(userDetails.getUserName().isEmpty()){
            userDetails.setUserId(0);
            userDetails.setUserName(null);
            userDetails.setPhoneNum(null);
            userDetails.setRole(null);
            userDetails.setPassword(null);
            userDetails.setEmail(null);
        }
        return userDetails;
    }

    public String deleteUser(int user_id){
        repository.deleteById(user_id);
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
}
