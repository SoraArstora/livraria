package br.com.livraria.controller;

import br.com.livraria.model.domain.Address;
import br.com.livraria.model.domain.Card;
import br.com.livraria.service.AddressService;
import br.com.livraria.service.CardService;
import br.com.livraria.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;
    private final UserUtils userUtils;

    @GetMapping("/create")
    public ModelAndView view(Card card) {
        return new ModelAndView("pages/card-create");
    }

    @PostMapping("/create")
    public ModelAndView create(Card card) {
        card.setUser(userUtils.getAuthorizedUser());
        cardService.create(card);
        return new ModelAndView("redirect:/card");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Integer id) {
        Card card = cardService.findById(id);
        ModelAndView modelAndView = new ModelAndView("pages/card-edit");
        modelAndView.addObject("card", card);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView update(@PathVariable Integer id, Card card) {
        cardService.update(id, card);
        return new ModelAndView("redirect:/card");
    }

    @PostMapping("/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        cardService.delete(id);
        return new ModelAndView("redirect:/card");
    }
}
