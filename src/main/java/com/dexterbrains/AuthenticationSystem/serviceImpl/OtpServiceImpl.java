package com.dexterbrains.AuthenticationSystem.serviceImpl;

import com.dexterbrains.AuthenticationSystem.dto.*;
import com.dexterbrains.AuthenticationSystem.entity.Otp;
import com.dexterbrains.AuthenticationSystem.repository.OtpRepository;
import com.dexterbrains.AuthenticationSystem.service.EmailService;
import com.dexterbrains.AuthenticationSystem.service.OtpService;
import com.dexterbrains.AuthenticationSystem.utils.AppUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;
    private final EmailService emailService;

    @Override
    public Response sendOtp(OtpRequest otpRequest) {

        Otp existingOtp = otpRepository.findByEmail(otpRequest.getEmail());
        if (existingOtp != null){
            otpRepository.delete(existingOtp);
        }
        String otp = AppUtils.generateOtp();
        log.info("otp: {}", otp);
        otpRepository.save(Otp.builder()
                        .email(otpRequest.getEmail())
                        .otp(otp)
                        .expiresAt(LocalDateTime.now().plusMinutes(2))
                .build());
        emailService.sendEmail(EmailDetailsDTO.builder()
                        .subject("OTP VALID FOR 2 MINUTES ONLy")
                        .recipient(otpRequest.getEmail())
                        .messageBody("Your OTP expires in 2 mins"+ otp)
                .build());

        return Response.builder()
                .statusCode(200)
                .responseMessage("SUCCESS")
                .build();
    }

    @Override
    public Response validateOtp(OtpValidationRequestDTO otpValidationRequestDTO) {
        Response response = new Response();
        Otp otp = otpRepository.findByEmail(otpValidationRequestDTO.getEmail());
        log.info("Email:{}", otpValidationRequestDTO.getEmail());
        if (otp == null){
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("You have not sent the OTP")
                    .build();
        } else if (otp.getExpiresAt().isBefore(LocalDateTime.now())) {
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("OTP expired")
                    .build();
        } else if (!otp.getOtp().equals(otpValidationRequestDTO.getOtp())) {
            return Response.builder()
                    .statusCode(400)
                    .responseMessage("INVALID OTP")
                    .build();
        } else if (otp.getOtp().equals(otpValidationRequestDTO.getOtp())) {
            response = Response.builder()
                    .statusCode(200)
                    .responseMessage("OTP varification successful !")
                    .otpResponse(OtpResponse.builder()
                            .isOtpValid(true)
                            .build())
                    .build();
        }
        return response;
    }
}
