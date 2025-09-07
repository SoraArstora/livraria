package br.com.livraria.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String cpf;
    private String phoneType;
    private String phone;
    private String email;
    private String password;
    private Boolean status = true;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    public void setAddresses(List<Address> addresses) {
        addresses.forEach(address -> address.setUser(this));
        this.addresses = addresses;
    }

    public void setCards(List<Card> cards) {
        cards.forEach(card -> card.setUser(this));
        this.cards = cards;
    }

}
