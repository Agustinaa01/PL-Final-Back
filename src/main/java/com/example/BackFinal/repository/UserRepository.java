package com.example.BackFinal.repository;

import com.example.BackFinal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
