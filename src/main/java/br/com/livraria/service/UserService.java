package br.com.livraria.service;

import br.com.livraria.model.domain.User;
import br.com.livraria.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(br.com.livraria.model.domain.User user) {
        user.getAddresses().forEach(address -> address.setUser(user));
        userRepository.save(user);
    }

    public User findbyId(Integer id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void update(Integer id, User user) {
        User oldUser = userRepository.findById(id).get();
        oldUser.setName(user.getName());
        oldUser.setGender(user.getGender());
        oldUser.setBirthDate(user.getBirthDate());
        oldUser.setCpf(user.getCpf());
        oldUser.setPhoneType(user.getPhoneType());
        oldUser.setPhone(user.getPhone());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setStatus(user.getStatus());
        userRepository.save(oldUser);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
