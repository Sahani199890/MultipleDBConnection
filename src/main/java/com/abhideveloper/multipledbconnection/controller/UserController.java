package com.abhideveloper.multipledbconnection.controller;

import com.abhideveloper.multipledbconnection.modal.UserModal;
import com.abhideveloper.multipledbconnection.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("addUser")
    public ResponseEntity<?> addUser(@RequestBody UserModal userModal){
        return ResponseEntity.ok(userService.addUser(userModal));
    }
    @GetMapping("userId/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @GetMapping("allUsers")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        userService.deleteUSerById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
