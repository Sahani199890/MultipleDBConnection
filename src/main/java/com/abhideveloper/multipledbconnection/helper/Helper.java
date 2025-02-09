package com.abhideveloper.multipledbconnection.helper;

import com.abhideveloper.multipledbconnection.entity.mysql.UserEntity;
import com.abhideveloper.multipledbconnection.modal.UserModal;
import org.springframework.beans.BeanUtils;

public class Helper {
    private Helper(){}

    public static UserEntity modalToEntity(UserModal modal){
        UserEntity entity =new UserEntity();
        BeanUtils.copyProperties(modal,entity);
        return entity;
    }
    public static UserModal entityToModal(UserEntity entity){
        UserModal modal=new UserModal();
        BeanUtils.copyProperties(entity,modal);
        return modal;
    }


}
