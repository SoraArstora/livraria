package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @GetMapping("/users")
    public ModelAndView index() {
        return new ModelAndView("pages/admin/user-list");
    }

}
