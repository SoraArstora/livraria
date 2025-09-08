package br.com.livraria.controller;

import br.com.livraria.model.domain.Address;
import br.com.livraria.model.domain.User;
import br.com.livraria.model.request.PasswordRequest;
import br.com.livraria.service.UserService;
import br.com.livraria.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final UserUtils userUtils;

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
        User user = userUtils.getAuthorizedUser();
        ModelAndView modelAndView = new ModelAndView("pages/perfil");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/address")
    public ModelAndView address() {
        User user = userUtils.getAuthorizedUser();
        ModelAndView modelAndView = new ModelAndView("pages/address");
        modelAndView.addObject("addresses", user.getAddresses());
        return modelAndView;
    }

    @GetMapping("/card")
    public ModelAndView card() {
        User user = userUtils.getAuthorizedUser();
        ModelAndView modelAndView = new ModelAndView("pages/card");
        modelAndView.addObject("cards", user.getCards());
        return modelAndView;
    }

    @GetMapping("/password")
    public ModelAndView password(PasswordRequest password) {
        User user = userUtils.getAuthorizedUser();
        ModelAndView modelAndView = new ModelAndView("pages/password");
        //modelAndView.addObject("password", user.getPassword());
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView cart() {
        return new ModelAndView("pages/cart");
    }

}
