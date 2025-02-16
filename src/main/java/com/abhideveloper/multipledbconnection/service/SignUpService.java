package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.modal.SignUpModal;

public interface SignUpService {

    String register(SignUpModal modal);
    SignUpModal login(SignUpModal modal);
}
