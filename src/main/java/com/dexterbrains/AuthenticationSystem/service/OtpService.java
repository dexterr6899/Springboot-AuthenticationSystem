package com.dexterbrains.AuthenticationSystem.service;

import com.dexterbrains.AuthenticationSystem.dto.OtpRequest;
import com.dexterbrains.AuthenticationSystem.dto.OtpValidationRequestDTO;
import com.dexterbrains.AuthenticationSystem.dto.Response;

public interface OtpService {

    public Response sendOtp(OtpRequest otpRequest);

    public Response validateOtp(OtpValidationRequestDTO otpValidationRequestDTO);
}
