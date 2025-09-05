package br.com.livraria.controller;

import br.com.livraria.model.domain.User;
import br.com.livraria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("pages/index");
    }

    @GetMapping("/register")
    public ModelAndView register(User user) {return new ModelAndView("pages/register");}

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("pages/login");
    }

    @GetMapping("/perfil")
    public ModelAndView perfil() {
        User user = userService.findbyId(3);
        ModelAndView modelAndView = new ModelAndView("pages/perfil");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/address")
    public ModelAndView endereco() {
        return new ModelAndView("pages/address");
    }

    @GetMapping("/card")
    public ModelAndView cartao() {
        return new ModelAndView("pages/card");
    }

    @GetMapping("/cart")
    public ModelAndView cart() {
        return new ModelAndView("pages/cart");
    }

}
