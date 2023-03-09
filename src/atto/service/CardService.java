package atto.service;

import atto.container.ComponentContainer;
import atto.dto.Card;
import atto.enums.CardStatus;
 import atto.enums.TransactionType;
import atto.repository.CardRepository;


import java.util.List;

public class CardService {

    public void checkCard(Card card) {
        Card exist = ComponentContainer.cardRepository.getCardByNumber(card.getNumber());
        if (exist != null) {
            System.out.println("Sorry card already is exist!!!");
            ComponentContainer.cardController.adminCardMenu();
            ComponentContainer.cardController.createCard();
        } else {
            ComponentContainer.cardRepository.saveCard(card);
            System.out.println("Card is  create  successfully");
            ComponentContainer.cardController.adminCardMenu();
        }

    }

    public void allCardList() {
        List<Card> cards = ComponentContainer.cardRepository.getAll();
        System.out.println("----------   Card List ----------");
        cards.forEach(card -> System.out.println(card));
        ComponentContainer.cardController.adminCardMenu();

    }

    public void updateCard(Card card) {
        Card exist = ComponentContainer.cardRepository.getCardByNumber(card.getNumber());
        if (exist != null) {
            ComponentContainer.cardRepository.updateCard(card);
            System.out.println("Card is  update  successfully");
            ComponentContainer.cardController.adminCardMenu();
        } else {
            System.out.println("Sorry Card isn't  create  yet!!!");
            ComponentContainer.cardController.createCard();
        }
    }

    public void deleteCard(Card card) {
        Card exist = ComponentContainer.cardRepository.getCardByNumber(card.getNumber());
        if (exist == null) {
            System.out.println("Card doesn't find !!!");
            ComponentContainer.cardController.adminCardMenu();
            return;
        } else {
            ComponentContainer.cardRepository.deleteCard(card.getNumber());
            System.out.println("Card is successfully delete");
            ComponentContainer.cardController.adminCardMenu();
        }


    }

    public void cardChangeStatus(String number) {
        Card exist = ComponentContainer.cardRepository.getCardByNumber(number);
        if (exist == null) {
            System.out.println("Sorry status isn't exist or not found card number");
            return;
        } else if (exist.getStatus().equals(CardStatus.ACTIVE)) {
            ComponentContainer.cardRepository.updateCardByStatus(CardStatus.BLOCK, number);
            ComponentContainer.cardController.adminCardMenu();
        } else if (exist.getStatus().equals(CardStatus.BLOCK)) {
            ComponentContainer.cardRepository.updateCardByStatus(CardStatus.ACTIVE, number);
            ComponentContainer.cardController.adminCardMenu();
        }
    }

    public void userRefillCard(String phone, String cardNumber, Double amount) {
        CardRepository cardRepository = new CardRepository();
        Card card = new Card();

        if (card == null) {
            System.out.println("card not found ");
            return;
        }

        if (card == null || !card.getPhone().equals(phone)) {
            System.out.println("card not belong to you");
            return;
        }
        //refill
        cardRepository.reFill(cardNumber, card.getBalance() + amount);
       // ComponentContainer.transactionService.transactionService(card.getId(),null,  amount, TransactionType.REFILL);
    }
}
