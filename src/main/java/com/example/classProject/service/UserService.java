package com.example.classProject.service;

import com.example.classProject.model.User;
import com.example.classProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        User existUser = userRepository.getByEmailHelper(user.getEmail());
        if (user == existUser){
            throw new RuntimeException("Email is already exists: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    public User update(User user){
            return userRepository.update(user);
    }

    public String deleteUserById (int id){
        if (userRepository.getUserById(id) != null){
            return userRepository.deleteUserById(id);
        }
        return "The user with id :" + id + "does not exists";
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public List<String> getUsersEmailByFirstName(String firstName){
        return userRepository.getUsersEmailByFirstName(firstName);
    }

    public  int getIdByEmail(String email){
        return userRepository.getIdByEmail(email);
    }

//    public User getByEmailHelper(String email){
//        return userRepository.getByEmailHelper(email);
//    }

}
