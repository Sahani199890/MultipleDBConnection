package com.abhideveloper.multipledbconnection.modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpModal {

    private String name;
    private String email;
    private String password;
    private String confirmPassword;

}
