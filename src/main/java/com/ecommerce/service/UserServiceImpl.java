package com.ecommerce.service;

import com.ecommerce.dtos.UserDto;
import com.ecommerce.entities.User;
import com.ecommerce.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
 @Autowired
  private UserRepository userRepository;
 @Autowired
 private ModelMapper mapper;

    @Override
    public UserDto createUser(UserDto UserDto) {

      //  dto->to entity
        User User=  dtoToEntity(UserDto);
        com.ecommerce.entities.User saveUser= userRepository.save(User);

        //entity to dto
        UserDto newDto=entityToDto(saveUser);
        return newDto;
    }

    @Override
    public UserDto updateUser(UserDto UserDto,Integer userId) {

      User user=  userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not fount"));
       user.setUserName(UserDto.getUserName());
       user.setAbout(UserDto.getAbout());
       user.setGender(UserDto.getGender());
       user.setPassword(UserDto.getPassword());
       user.setImage(UserDto.getImage());

      User updatedUser= userRepository.save(user);
      UserDto updatedDto= entityToDto(updatedUser);
      return updatedDto;

    }

    @Override
    public void deleteUser(Integer userId) {


      User user=  userRepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
      userRepository.delete(user);


    }

    @Override
    public List<UserDto> getAllUser(UserDto UserDto) {



   List<User> users =  userRepository.findAll();
    //entitytodto
        List<UserDto> dtoList=  users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public UserDto getUserById(Integer UserId) {

                User user=userRepository.findById(UserId).orElseThrow(()-> new RuntimeException("user not found"));
                //entitytodto
        UserDto userdto=entityToDto(user);
        return userdto;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("user not found"));

        return entityToDto(user);
    }



    @Override
    public List<UserDto> searchUser(String keyword) {

      List<User> users= userRepository.findByUserNameContaining(keyword);
      List<UserDto> dtoList=users.stream().map(user->entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }




    private UserDto entityToDto(User saveUser) {

        return mapper.map(saveUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {

        return mapper.map(userDto,User.class);
    }



}
