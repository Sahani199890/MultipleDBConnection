package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.modal.UserModal;

import java.util.List;

public interface UserService {
    UserModal addUser(UserModal userModal);
    UserModal getUserById(Long id);
    List<UserModal> getAllUsers();
    void deleteUSerById(Long id);
}
