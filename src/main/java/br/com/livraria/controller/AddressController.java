package br.com.livraria.controller;

import br.com.livraria.service.AddressService;
import br.com.livraria.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final UserService userService;
    private final AddressService addressService;

    @GetMapping("/address-create")
    public ModelAndView addressCreate() { return new ModelAndView("pages/address-create"); }

    @GetMapping("/address-edit")
    public ModelAndView addressEdit() {
        return new ModelAndView("pages/address-edit");
    }

    @PostMapping("/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        userService.delete(id);
        return new ModelAndView("redirect:/address");
    }
}
