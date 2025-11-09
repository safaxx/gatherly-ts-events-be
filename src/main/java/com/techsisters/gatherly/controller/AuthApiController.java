package com.techsisters.gatherly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsisters.gatherly.response.OtpResponse;
import com.techsisters.gatherly.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/user/")
public class AuthApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/send-otp")
    public OtpResponse generateOTP(@RequestBody String email) throws Exception {
        OtpResponse response = new OtpResponse();
        Integer otp = userService.generateOTP(email);
        response.setSuccess(true);
        response.setMessage("OTP generated successfully");
        response.setOtp(otp);
        return response;
    }

}
