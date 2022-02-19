package io.iShopmobile.ishopMobileBackend.Controller;

import io.iShopmobile.ishopMobileBackend.Model.Users;
import io.iShopmobile.ishopMobileBackend.Response.LoginResponse;
import io.iShopmobile.ishopMobileBackend.Response.UserRegResponse;
import io.iShopmobile.ishopMobileBackend.Services.UserService;
import org.apache.catalina.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/createUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody Users user){
       UserRegResponse userRegResponse =  userService.createUser(user);
        return ResponseEntity.ok(userRegResponse);
    }

    @PostMapping(value = "/user/userLogin", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> userLogin(@RequestBody Users user){
        LoginResponse loginResponse = userService.loginUser(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(loginResponse);
    }

    @GetMapping(value = "/users/getUserData/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable("userId") long userId){
        Users users = userService.getUser(userId);
        return ResponseEntity.ok(users);
    }
}
