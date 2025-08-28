package br.com.livraria.service;

import br.com.livraria.model.domain.User;
import br.com.livraria.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public User findbyid(int id) {
        return userRepository.findById(id).get();
    }

    public List<User> findall() {
        return userRepository.findAll();
    }

    public void create(br.com.livraria.model.domain.User user) {
        userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
