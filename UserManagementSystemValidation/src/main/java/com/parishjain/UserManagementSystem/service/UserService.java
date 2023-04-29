package com.parishjain.UserManagementSystem.service;

import com.parishjain.UserManagementSystem.models.User;
import com.parishjain.UserManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUserList(){
        return userRepository.getAll();
    }

    public String addUserToList(User user) {
        boolean insertionStatus = userRepository.save(user);
        if(insertionStatus) return "User has successfully added.";
        else return  "Some error occurred.. Try Again";
    }

    public List<User> getAllUserInList() {
        return userRepository.getAll();
    }

    public User getUserById(String user_id) {
        List<User> userPresent = getAllUserInList();

        for(User user : userPresent){
            if(user.getUser_id().equals(user_id)) return user;
        }
        return null;
    }

    public String deleteUserById(String user_id) {
        List<User> userPresent = getAllUserInList();

        for(User user : userPresent){
            if(user.getUser_id().equals(user_id)) {
                boolean status = userRepository.remove(user);
                if(status) return "Deleted";
            }
        }
        return "Not Deleted";
    }

    public String updateUserInformation(User user) {
        List<User> userPresent = getAllUserInList();
        for(User presentUser : userPresent){
            if(presentUser.getUser_id().equals(user.getUser_id())){
                userRepository.remove(presentUser);
                userRepository.save(user);
                return "Updated";
            }
        }
        return "Not Updated";
    }
}
