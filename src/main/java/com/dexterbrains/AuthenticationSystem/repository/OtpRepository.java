package com.dexterbrains.AuthenticationSystem.repository;

import com.dexterbrains.AuthenticationSystem.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, Long> {

    Otp findByEmail(String email);
}
