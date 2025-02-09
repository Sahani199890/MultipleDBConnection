package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.entity.h2.SignUpEntity;
import com.abhideveloper.multipledbconnection.modal.SignUpModal;
import com.abhideveloper.multipledbconnection.repo.h2.SignUpRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignUpServiceImp implements SignUpService{
    private final SignUpRepo signUpRepo;

    public SignUpServiceImp(SignUpRepo signUpRepo){
        this.signUpRepo=signUpRepo;
    }

    @Override
    public SignUpModal signUpUser(SignUpModal modal) {
        Optional<SignUpEntity> signUpOpt=signUpRepo.findByEmail(modal.getEmail());
        if(signUpOpt.isEmpty()){
            SignUpEntity entity=new SignUpEntity();
            BeanUtils.copyProperties(modal,entity);
            signUpRepo.save(entity);
        }
        return null;
    }

    @Override
    public SignUpModal signInUser(SignUpModal modal) {
        return null;
    }
}
