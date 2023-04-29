package com.parishjain.UserManagementSystem.repository;

import com.parishjain.UserManagementSystem.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userList ;

    public UserRepository(){
        userList = new ArrayList<>();
    }




    public boolean save(User user) {
        userList.add(user);
        return true;
    }

    public List<User> getAll() {
        return userList;
    }

    public boolean remove(User user) {
        userList.remove(user);
        return true;
    }


}
