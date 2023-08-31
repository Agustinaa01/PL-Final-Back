package com.example.BackFinal.service;

import com.example.BackFinal.model.Producto;
import com.example.BackFinal.model.User;
import com.example.BackFinal.repository.ProductoRepository;
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
    public User GuardarUser(User user) {

        return userRepository.save(user);
    }
    public void eliminar(Integer id) {

        userRepository.deleteById(id);
    }
    public Optional<User> buscar(Integer id) {

        return userRepository.findById(id);
    }
    public List<User> buscarTodos() {

        return userRepository.findAll();
    }

    public User actualizar(User user) {

        return userRepository.save(user);
    }
}

