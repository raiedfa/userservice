//package com.example.classProject.controller;
//
//import com.example.classProject.model.User;
//
//import com.example.classProject.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public User createUser (@RequestBody User user){
//        return userService.save(user);
//    }
//
//    @PutMapping
//    public User updateUser(@RequestBody User user){
//        return userService.update(user);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable int id){
//        return userService.deleteUserById(id);
//    }
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable int id){
//        return userService.getUserById(id);
//    }
//
//    @GetMapping
//    public List<User> getAll(){
//        return userService.getAll();
//    }
//
//    @GetMapping("/emails")
//    public List<String> getUsersEmailByFirstName(@RequestParam String firstName){
//        return userService.getUsersEmailByFirstName(firstName);
//    }
//
//    @GetMapping("/id")
//    public int getIdByEmail (String email){
//        return userService.getIdByEmail(email);
//    }
//
////    @GetMapping
////    public User getByEmailHelper(String email){
////        return userService.getByEmailHelper(email);
////    }
//
//
//
//
//
//}
