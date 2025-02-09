package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.entity.mysql.UserEntity;
import com.abhideveloper.multipledbconnection.helper.Helper;
import com.abhideveloper.multipledbconnection.modal.UserModal;
import com.abhideveloper.multipledbconnection.repo.mysql.UserRepo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImp implements UserService{

    private final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public UserModal addUser(UserModal userModal) {
        UserEntity userEntity=Helper.modalToEntity(userModal);
        userEntity=userRepo.save(userEntity);
        return Helper.entityToModal(userEntity);
    }

    @Override
    public UserModal getUserById(Long id) {
        Optional<UserEntity> userEntityOpt=userRepo.findById(id);
        if(userEntityOpt.isPresent()){
            return Helper.entityToModal(userEntityOpt.get());
        }
        return null;
    }

    @Override
    public List<UserModal> getAllUsers() {
        List<UserEntity> userEntities=userRepo.findAll();
        List<UserModal> userModalList=new ArrayList<>();
        userEntities.stream().map((entity -> userModalList.add(Helper.entityToModal(entity))));
        return userModalList;
    }

    @Override
    public void deleteUSerById(Long id) {
        userRepo.deleteById(id);
    }
}
