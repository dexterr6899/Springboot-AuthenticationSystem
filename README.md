<!-- Banner -->
<p align="center">
  <img src="https://img.shields.io/badge/SpringBoot-OTP%20Authentication-brightgreen?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot OTP Auth Banner"/>
</p>

<h1 align="center">🔐 Spring Boot OTP + Password Authentication System</h1>

<p align="center">
  A secure, modern authentication system using Spring Boot, JWT, and email OTP – fast, clean, and production-ready.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?style=for-the-badge&logo=java" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-success?style=for-the-badge&logo=springboot" />
  <img src="https://img.shields.io/badge/JWT-secure-yellow?style=for-the-badge&logo=jsonwebtokens" />
  <img src="https://img.shields.io/badge/BCrypt-encrypted-critical?style=for-the-badge&logo=lock" />
  <img src="https://img.shields.io/badge/SMTP-Gmail-red?style=for-the-badge&logo=gmail" />
  <img src="https://img.shields.io/github/license/dexterr6899/Springboot-AuthenticationSystem?style=for-the-badge" />
</p>


Welcome to the **Spring Boot Authentication System**!  
This project implements a modern and secure way to **sign up and log in using both OTP and password**, combining **Spring Security**, **JWT**, and **email-based verification** into a clean, scalable microservice-style architecture.

---

## ✨ Features

✅ User Signup with OTP Verification  
✅ Secure Login with Password (encrypted using Bcrypt)  
✅ JWT Token Generation for Authorization  
✅ Automatic Email OTP Sending via SMTP  
✅ JSON Response Builders for Standardized Outputs  
✅ Clean Codebase using Lombok and Builder Patterns  

---

## 📦 Tech Stack & Libraries Used

| Tool / Library     | Purpose                                      |
|--------------------|----------------------------------------------|
| **Spring Boot**    | Core application framework                   |
| **Spring Security**| Authentication & authorization               |
| **JWT**            | Stateless token-based session management     |
| **Lombok**         | Cleaner code with annotations (`@Builder`, etc.) |
| **SMTP (JavaMailSender)** | Sending OTP emails via Gmail           |
| **BCryptPasswordEncoder** | Encrypting and storing passwords securely |

---

## 🔐 Security Architecture

- **Passwords are never stored as plain text.**  
  Every password is encrypted using **BCrypt** before saving it to the database.
  
- **JWT (JSON Web Tokens)** are generated upon successful login and are used for validating all protected routes.

- **OTP (One-Time Password)** is sent to the user's email and validated during signup.

---

## 💡 Builder Pattern in Action

We use **Lombok’s `@Builder` annotation** to build:

- 🔁 **Custom JSON Responses** – Ensuring consistency and clarity in API replies  
- 📧 **Email Content** – Cleanly constructed mail templates for OTP delivery

---

## 🚀 How to Run
Clone the repository:

Copy
git clone https://github.com/your-username/Springboot-AuthenticationSystem.git
cd Springboot-AuthenticationSystem

📬 API Endpoints (Sample)
Endpoint	Method	Description
/auth/signup	POST	Sign up using email, password, OTP
/auth/verify-otp	POST	Submit OTP for verification
/auth/login	POST	Login with email + password
/auth/resend-otp	POST	Resend OTP to email

## 🧠 Future Improvements
Add rate limiting for OTP resend

Password reset flow using OTP

Admin panel for user management

Dockerize the app for deployment

## 🛠️ How to Set Up Mail Sender (Gmail SMTP)

To enable OTP emails via Gmail:

1. **Go to your Google Account → Security**
2. Scroll down to **"App passwords"**
3. Choose an app (e.g., Mail) and device (e.g., Windows Computer), then click **Generate**
4. Copy the generated app password
5. Paste it into your `application.properties`:


## 🙌 Contributing
Feel free to fork the repo, open issues, or submit PRs!
This project is perfect for anyone looking to learn or implement secure authentication in Spring Boot.

## 📄 License
MIT License – Use it, modify it, break it, improve it 🔧

## 👨‍💻 Author
Made with ❤️ by @dexterr6899


