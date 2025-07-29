package com.dexterbrains.AuthenticationSystem.service;


import com.dexterbrains.AuthenticationSystem.dto.EmailDetailsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

public interface EmailService {

    public void sendEmail(EmailDetailsDTO emailDetailsDTO);
}
