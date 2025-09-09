package br.com.livraria.utils;

import br.com.livraria.model.domain.User;
import br.com.livraria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserUtils {

    private final UserService userService;

    public User getAuthorizedUser(){
        return userService.findbyId(6);
    }
}
