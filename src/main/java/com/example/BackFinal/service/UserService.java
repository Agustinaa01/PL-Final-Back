package com.example.BackFinal.service;

import com.example.BackFinal.model.AppUser;
import com.example.BackFinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    public AppUser GuardarUser(AppUser appUser) {

        return userRepository.save(appUser);
    }
    public void eliminar(Integer id) {

        userRepository.deleteById(id);
    }
    public Optional<AppUser> buscar(Integer id) {

        return userRepository.findById(id);
    }
    public List<AppUser> buscarTodos() {

        return userRepository.findAll();
    }

    public AppUser actualizar(AppUser appUser) {

        return userRepository.save(appUser);
    }
}

