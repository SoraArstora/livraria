package br.com.livraria.controller;

import br.com.livraria.model.domain.User;
import br.com.livraria.model.request.PasswordRequest;
import br.com.livraria.service.UserService;
import br.com.livraria.utils.UserUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserUtils userUtils;

    @PostMapping("/create")
    public ModelAndView create(User user){
        userService.create(user);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/allUsers")
    public ModelAndView index() {
        List<User> users = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("pages/admin/user-list");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(User user){
        Integer id = userUtils.getAuthorizedUser().getId();
        userService.update(id, user);
        return new ModelAndView("redirect:/perfil");
    }
    @PostMapping("/updatePassword")
    public ModelAndView updatePassword(@Valid PasswordRequest passwordRequest, BindingResult result){
        Integer id = userUtils.getAuthorizedUser().getId();
        if(result.hasErrors()) {
            return new ModelAndView("pages/password");
        }
        userService.updatePassword(id, passwordRequest);
        return new ModelAndView("redirect:/perfil");
    }

    @PostMapping("/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        userService.delete(id);
        return new ModelAndView("redirect:/");
    }
}
