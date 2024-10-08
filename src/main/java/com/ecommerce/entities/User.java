package com.ecommerce.entities;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table (name="users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

@Column(name="users_name")
    private String userName;

@Column(name="user_email", unique=true)
    private String email;

@Column(name="user_password",length=10)
    private String password;

    private String gender;

    @Column(length=1000)
    private String about;

    @Column(name="user_image-name")
    private String image;

}
