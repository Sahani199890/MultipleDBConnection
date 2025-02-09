package com.abhideveloper.multipledbconnection.service;

import com.abhideveloper.multipledbconnection.modal.SignUpModal;

public interface SignUpService {

    SignUpModal signUpUser(SignUpModal modal);
    SignUpModal signInUser(SignUpModal modal);
}
