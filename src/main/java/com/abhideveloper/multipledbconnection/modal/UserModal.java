package com.abhideveloper.multipledbconnection.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModal {
    private String name;
    private Integer age;
    private String email;
    private String password;
}
