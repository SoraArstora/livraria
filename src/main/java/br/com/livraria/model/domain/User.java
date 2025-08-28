package br.com.livraria.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    private Integer id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String cpf;
    private String phoneType;
    private String phone;
    private String email;
    private String password;
}
