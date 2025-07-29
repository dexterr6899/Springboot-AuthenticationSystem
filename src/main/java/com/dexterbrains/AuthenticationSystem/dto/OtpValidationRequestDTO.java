package com.dexterbrains.AuthenticationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtpValidationRequestDTO {

    private String otp;
    private String email;
}
