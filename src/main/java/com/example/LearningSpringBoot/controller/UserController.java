package com.example.LearningSpringBoot.controller;

import com.example.LearningSpringBoot.dto.request.ApiResponse;
import com.example.LearningSpringBoot.dto.request.UserCreateRequest;
import com.example.LearningSpringBoot.dto.request.UserUpdateRequest;
import com.example.LearningSpringBoot.entity.User;
import com.example.LearningSpringBoot.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreateRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    List<User> readUsers(){
        return userService.readUsers();
    }

    @GetMapping("/{userId}")
    User readUser(@PathVariable String userId){
        return userService.readUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser (@RequestBody @Valid UserUpdateRequest request, @PathVariable("userId") String id) {
        return userService.updateUser(request, id);
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
    }
}
