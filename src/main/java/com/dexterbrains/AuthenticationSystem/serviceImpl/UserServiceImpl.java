package com.dexterbrains.AuthenticationSystem.serviceImpl;

import com.dexterbrains.AuthenticationSystem.dto.LoginRequest;
import com.dexterbrains.AuthenticationSystem.dto.Request;
import com.dexterbrains.AuthenticationSystem.dto.Response;
import com.dexterbrains.AuthenticationSystem.dto.UserInfo;
import com.dexterbrains.AuthenticationSystem.entity.User;
import com.dexterbrains.AuthenticationSystem.repository.UserRepository;
import com.dexterbrains.AuthenticationSystem.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Response> signup(Request request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Response.builder()
                    .statusCode(400)
                    .responseMessage("User Already Exists !")
                    .build());
        }
        User user = User.builder()
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                .build();
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(Response.builder()
                    .statusCode(200)
                    .responseMessage("SUCCESS")
                    .userInfo(modelMapper.map(savedUser, UserInfo.class))
                .build());
    }

    @Override
    public ResponseEntity<Response> login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public Response sendOtp() {
        return null;
    }

    @Override
    public Response validateOtp() {
        return null;
    }

    @Override
    public Response setPassword() {
        return null;
    }

    @Override
    public Response changePassword() {
        return null;
    }
}
