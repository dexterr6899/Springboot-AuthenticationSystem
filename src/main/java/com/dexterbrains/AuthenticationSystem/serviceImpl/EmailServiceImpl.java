package com.dexterbrains.AuthenticationSystem.serviceImpl;

import com.dexterbrains.AuthenticationSystem.dto.EmailDetailsDTO;
import com.dexterbrains.AuthenticationSystem.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    @Override
    public void sendEmail(EmailDetailsDTO emailDetailsDTO) {
        try {
            SimpleMailMessage mailMessage =new SimpleMailMessage();
            mailMessage.setFrom(emailSender);
            mailMessage.setTo(emailDetailsDTO.getRecipient());
            mailMessage.setText(emailDetailsDTO.getMessageBody());
            mailMessage.setSubject(emailDetailsDTO.getSubject());

            javaMailSender.send(mailMessage);
            log.info("Message sent to: {}", emailDetailsDTO.getRecipient());
            log.info("Message sender is: {}", emailSender);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
