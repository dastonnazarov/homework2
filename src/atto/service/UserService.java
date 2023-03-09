package atto.service;

import atto.container.ComponentContainer;
import atto.dto.Card;
import atto.dto.Profile;

public class UserService {

    public void addCard(Card card) {
        Profile exists = ComponentContainer.userRepository.getUserByPhone(card.getPhone());

        if (exists != null && exists.getPhone().equals(card.getPhone())) {
            ComponentContainer.userRepository.saveUserCard(card);
        }  else {
//            registrationProfile(profile);
        }
    }
}
