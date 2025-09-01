package br.com.livraria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/users/{id}")
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
