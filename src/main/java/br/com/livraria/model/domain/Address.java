package br.com.livraria.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String residentType;
    private String streetType;
    private String street;
    private String number;
    private String neighbor;
    private String cep;
    private String city;
    private String state;
    private String country;
    private Boolean charge;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
