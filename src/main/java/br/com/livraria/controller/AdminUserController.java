package br.com.livraria.controller;

import br.com.livraria.model.domain.User;
import br.com.livraria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @GetMapping("/wasd")
    public ModelAndView index(@PathVariable Long id) {
        return new ModelAndView("pages/admin/user-edit");
    }

    @GetMapping("/registerBook")
    public ModelAndView registerBook() {
        return new ModelAndView("pages/admin/registerBook");
    }

    @GetMapping("/books")
    public ModelAndView books() {
        return new ModelAndView("pages/admin/book-list");
    }

    @GetMapping("/graphics")
    public ModelAndView graphics() {
        return new ModelAndView("pages/admin/graphics");
    }

}
