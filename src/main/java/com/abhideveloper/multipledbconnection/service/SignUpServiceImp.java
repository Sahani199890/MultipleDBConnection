package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.config.security.JWTToken;
import com.abhideveloper.multipledbconnection.entity.h2.SignUpEntity;
import com.abhideveloper.multipledbconnection.entity.mysql.UserEntity;
import com.abhideveloper.multipledbconnection.modal.SignUpModal;
import com.abhideveloper.multipledbconnection.modal.UserModal;
import com.abhideveloper.multipledbconnection.repo.h2.SignUpRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpServiceImp implements SignUpService{
    private final SignUpRepo signUpRepo;
    private final UserService userService;
    private final JWTToken token;

    public SignUpServiceImp(SignUpRepo signUpRepo,UserService userService,JWTToken token){
        this.signUpRepo=signUpRepo;
        this.userService=userService;
        this.token=token;
    }

    @Override
    public String register(SignUpModal modal) {
        Optional<SignUpEntity> signUpOpt=signUpRepo.findByEmail(modal.getEmail());
        if(signUpOpt.isEmpty()){
            SignUpEntity entity=new SignUpEntity();
            BeanUtils.copyProperties(modal,entity);
            signUpRepo.save(entity);
            UserModal userModal=new UserModal();
            BeanUtils.copyProperties(entity,userModal);
            UserModal data=userService.addUser(userModal);
            return token.generateToken(data.getEmail());
        }
        return null;
    }

    @Override
    public SignUpModal login(SignUpModal modal) {
        return null;
    }
}
