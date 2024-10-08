package com.ecommerce.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
public class UserDto {
@Id
    private Integer userId;

@Size(min=3,max=15,message = "invalid name!!")
    private String userName;

@Email(message = "invalid email!!")
    private String email;

@NotBlank(message = "you must enter the password!!")
    private String password;

@Size(min=4,max=6,message = "invalid gender!!")
    private String gender;

@NotBlank(message = "write something abbout!!")
    private String about;


    private String image;
}
