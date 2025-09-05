package br.com.livraria.controller;

import br.com.livraria.model.domain.User;
import br.com.livraria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ModelAndView saveUser(User user){
        userService.create(user);
        return new ModelAndView("redirect:/");
    }

}
