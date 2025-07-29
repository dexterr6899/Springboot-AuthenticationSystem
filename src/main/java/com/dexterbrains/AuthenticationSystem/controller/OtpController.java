package com.dexterbrains.AuthenticationSystem.controller;

import com.dexterbrains.AuthenticationSystem.dto.OtpRequest;
import com.dexterbrains.AuthenticationSystem.dto.OtpValidationRequestDTO;
import com.dexterbrains.AuthenticationSystem.dto.Response;
import com.dexterbrains.AuthenticationSystem.service.OtpService;
import com.dexterbrains.AuthenticationSystem.serviceImpl.OtpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/sendOtp")
    public Response sendOtp(@RequestBody OtpRequest otpRequest){
        return otpService.sendOtp(otpRequest);
    }

    @PostMapping("/validateOtp")
    public Response validateOtp(@RequestBody OtpValidationRequestDTO otpValidationRequestDTO){
        return otpService.validateOtp(otpValidationRequestDTO);
    }
}
