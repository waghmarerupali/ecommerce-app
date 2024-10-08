package com.ecommerce.service;

import com.ecommerce.dtos.UserDto;

import java.util.List;

public interface UserService {


    //create user
    UserDto createUser(UserDto UserDto);




    //update user
    UserDto updateUser(UserDto UserDto, Integer userId);


   public void deleteUser(Integer userId);


    //to get all users
    List<UserDto> getAllUser(UserDto UserDto);




    //get single user by id
    UserDto getUserById(Integer UserId);


UserDto getUserByEmail(String email);


    //search user
   List<UserDto> searchUser(String keyword);

}
