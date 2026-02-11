package com.example.LearningSpringBoot.service;

import com.example.LearningSpringBoot.dto.request.UserCreateRequest;
import com.example.LearningSpringBoot.dto.request.UserUpdateRequest;
import com.example.LearningSpringBoot.entity.User;
import com.example.LearningSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(UserCreateRequest request){
        if (userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("username is existed");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        return userRepository.save(user);
    }

    public List<User> readUsers(){
        return userRepository.findAll();
    }

    public User readUser(String id) {
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("id is existed");
        }
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    public User updateUser(UserUpdateRequest request, String id) {
        if(!userRepository.existsById(id)){
            throw new RuntimeException("id is existed");
        }
        User user = readUser(id);
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setDateOfBirth(request.getDateOfBirth());
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("id is existed");
        }
        userRepository.deleteById(id);
    }
}
