package com.example.BackFinal.service;


import com.example.BackFinal.model.AppUser;
import com.example.BackFinal.model.AppUserRole;
import com.example.BackFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new AppUser("password","Usuario 3", "usuario1@ejemplo.com", AppUserRole.USER,new ArrayList<>()));
        userRepository.save(new AppUser("password2", "Usuario 4", "usuario2@ejemplo.com", AppUserRole.ADMIN, new ArrayList<>()));
    }
}
