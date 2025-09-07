package br.com.livraria.service;

import br.com.livraria.model.domain.Card;
import br.com.livraria.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {

    public final CardRepository cardRepository;

    public void create(Card card) {
        cardRepository.save(card);
    }

    public Card findById(Integer id){
        return cardRepository.findById(id).get();
    }

    public void update(Integer id, Card card) {
        Card oldCard = cardRepository.findById(id).get();
        oldCard.setCardNumber(card.getCardNumber());
        oldCard.setName(card.getName());
        oldCard.setBrand(card.getBrand());
        oldCard.setCvv(card.getCvv());
        cardRepository.save(oldCard);
    }

    public void delete(int id) {
        cardRepository.deleteById(id);
    }
}
