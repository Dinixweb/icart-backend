package io.iShopmobile.ishopMobileBackend.Services;

import io.iShopmobile.ishopMobileBackend.Model.Users;
import io.iShopmobile.ishopMobileBackend.Repository.UserRepository;
import io.iShopmobile.ishopMobileBackend.Response.LoginResponse;
import io.iShopmobile.ishopMobileBackend.Response.UserRegResponse;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRegResponse createUser(Users user){
        //String userId = String.valueOf(RandomString.DEFAULT_LENGTH);
        userRepository.save(user);
        return new UserRegResponse(user.getUserId(), "successfully registered");
    }
    public boolean checkEmail(String email){
        return userRepository.getByEmail(email);
    }
    public boolean checkPassword(String email){
        return userRepository.getByPassword(email);
    }

    public LoginResponse loginUser(String email, String password) {
        Users users = userRepository.getUserByEmail(email);
        if(Objects.equals(users.getEmail(), email) && Objects.equals(users.getPassword(), password)) {
            return new LoginResponse(users.getUserId(), "successfully loggedIn", "SUCCESS");
        }else{
            return new LoginResponse(null, "invalid details","FAILED");
        }

    }

    public Users getUser(Long userId){
        return userRepository.getByUserId(userId);
    }


}
