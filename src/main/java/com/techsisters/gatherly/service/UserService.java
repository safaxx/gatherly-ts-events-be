package com.techsisters.gatherly.service;

import org.springframework.stereotype.Service;

import com.techsisters.gatherly.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    

}
