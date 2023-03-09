package atto.controller;

import atto.container.ComponentContainer;
import atto.dto.Card;
import atto.util.ScannerUtil;


public class CardController {



    public static void adminCardMenu() {
        System.out.println("-----------  CardMenu  ----------");
        System.out.println("1.Create Card");
        System.out.println("2.Card List");
        System.out.println("3.Update Card (number,exp_date)");
        System.out.println("4.Change Card status");
        System.out.println("5.Delete Card");
        System.out.println("6.Go Back");
        System.out.println("0.Exit");
        adminByCardStart();
    }

    public static void adminByCardStart() {
        boolean bool = true;
        while (bool) {
            Integer action = ScannerUtil.getAction();
            switch (action) {
                case 1:
                    CardController.createCard();
                    break;
                case 2:
                    CardController.cardList();
                    break;
                case 3:
                    CardController.updateCard();
                    break;
                case 4:
                    CardController.changeCardStatus();
                    break;
                case 5:
                    CardController.deleteCard();
                    break;
                case 6:
                    AdminController.adminSectionMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("wrong option!");
                    break;
            }
        }
    }

                    //CRUD SECTION
    public static void createCard() {
        System.out.println("Enter Card Number: ");
        String cardNumber = ComponentContainer.StringScan.nextLine();

        System.out.println("Enter Card exp_date: ");
        String exp_date = ComponentContainer.StringScan.nextLine();

        Card card = new Card();
        card.setNumber(cardNumber);
        card.setExp_date(exp_date);
        ComponentContainer.cardService.checkCard(card);
    }

    public static void cardList() {
     ComponentContainer.cardService.allCardList();
    }

    public static void updateCard() {
        System.out.println("Enter card number: ");
        String number = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter card new update exp_date: ");
        String exp_date = ComponentContainer.StringScan.nextLine();

        Card card = new Card();
        card.setNumber(number);
        card.setExp_date(exp_date);
        ComponentContainer.cardService.updateCard(card);
    }

    public static void changeCardStatus() {
        System.out.println("------ Card change status -------");

        System.out.println("Enter card number: ");
        String cardNumber = ComponentContainer.StringScan.nextLine();
        ComponentContainer.cardService.cardChangeStatus(cardNumber);
    }

    public static void deleteCard() {
        System.out.println("Enter delete card number: ");
        String cardNumber = ComponentContainer.StringScan.nextLine();

        Card card = new Card();
        card.setNumber(cardNumber);
        ComponentContainer.cardService.deleteCard(card);
    }


}
