package br.com.livraria.controller;

import br.com.livraria.model.domain.Address;
import br.com.livraria.model.domain.User;
import br.com.livraria.service.AddressService;
import br.com.livraria.service.UserService;
import br.com.livraria.utils.UserUtils;
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
    private final UserUtils userUtils;

    @GetMapping("/create")
    public ModelAndView view(Address address) {
        return new ModelAndView("pages/address-create");
    }

    @PostMapping("/create")
    public ModelAndView create(Address address) {
        address.setUser(userUtils.getAuthorizedUser());
        addressService.create(address);
        return new ModelAndView("redirect:/address");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        Address address = addressService.findById(id);
        ModelAndView modelAndView = new ModelAndView("pages/address-edit");
        modelAndView.addObject("address", address);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Integer id, Address address) {
        addressService.update(id, address);
        return new ModelAndView("redirect:/address");
    }

    @PostMapping("/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        addressService.delete(id);
        return new ModelAndView("redirect:/address");
    }
}
