package com.dexterbrains.AuthenticationSystem.service;

import com.dexterbrains.AuthenticationSystem.dto.LoginRequest;
import com.dexterbrains.AuthenticationSystem.dto.Request;
import com.dexterbrains.AuthenticationSystem.dto.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Response> signup(Request request);

    ResponseEntity<Response> login(LoginRequest loginRequest);

    Response sendOtp();

    Response validateOtp();

    Response setPassword();

    Response changePassword();

}
