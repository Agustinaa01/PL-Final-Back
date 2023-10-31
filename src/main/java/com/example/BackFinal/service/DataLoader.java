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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser(hashedPassword,"Usuario 3", "usuario1@ejemplo.com", AppUserRole.USER,new ArrayList<>()));
        userRepository.save(new AppUser(hashedPassword2, "Usuario 4", "usuario2@ejemplo.com", AppUserRole.ADMIN, new ArrayList<>()));
    }
}
