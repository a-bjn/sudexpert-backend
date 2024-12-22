package com.example.sudexpert_backend.repository;


import com.example.sudexpert_backend.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmailRepository extends JpaRepository<Email, Long> { }
