package com.example.uberappproject.uberapp.services.impl;

import com.example.uberappproject.uberapp.dto.DriverDto;
import com.example.uberappproject.uberapp.dto.SignupDto;
import com.example.uberappproject.uberapp.dto.UserDto;
import com.example.uberappproject.uberapp.entities.Rider;
import com.example.uberappproject.uberapp.entities.User;
import com.example.uberappproject.uberapp.entities.enums.Role;
import com.example.uberappproject.uberapp.exceptions.RuntimeConflictException;
import com.example.uberappproject.uberapp.repositories.UserRepository;
import com.example.uberappproject.uberapp.services.AuthService;
import com.example.uberappproject.uberapp.services.RiderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    public AuthServiceImpl(ModelMapper modelMapper, UserRepository userRepository, RiderService riderService) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.riderService = riderService;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElseGet(()->null);
        if (user!=null){
            throw new RuntimeConflictException("cannot signup, user already exists with email: "+signupDto.getEmail());
        }


        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

//        create user related entities
        riderService.createNewRider(savedUser);
//      add wallet


        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
