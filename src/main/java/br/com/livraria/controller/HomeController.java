package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("pages/index");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("pages/register");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("pages/login");
    }

}
