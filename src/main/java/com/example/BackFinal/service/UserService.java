package com.example.BackFinal.service;

import com.example.BackFinal.exceptions.ResourceNotFoundException;
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
    public void eliminar(Integer id) throws ResourceNotFoundException {
        if (buscar(id).isEmpty())
            throw new ResourceNotFoundException("No existe el usuario con el id: " + id);
            userRepository.deleteById(id);
    }
    public Optional<AppUser> buscar(Integer id)  {


        return userRepository.findById(id);
    }
    public List<AppUser> buscarTodos() {

        return userRepository.findAll();
    }

    public AppUser actualizar(AppUser appUser) {

        return userRepository.save(appUser);
    }
}

