package atto.service;

import atto.container.ComponentContainer;

import atto.dto.Profile;
import atto.enums.ProfileStatus;


import java.time.LocalDate;
import java.util.List;

public class ProfileService {

    public void loginProfile(Profile profile) {
        Profile existsPhone = ComponentContainer.profileRepository.getProfileByPhone(profile.getPhone());

        if (existsPhone != null && existsPhone.getId() == -1) {
            ComponentContainer.adminController.adminSectionMenu();
        } else if (existsPhone != null && existsPhone.getId() != -1) {
            ComponentContainer.userController.userCardMenu();
        } else if (existsPhone == null) {
            System.out.println("You haven't registered yet!!!");
            ComponentContainer.menuController.singUpMenu();
        } else {
            registrationProfile(profile);
        }

    }

    public void registrationProfile(Profile profile) {
        profile.setCreate_date(LocalDate.now());
        ComponentContainer.profileRepository.saveProfile(profile);
        System.out.println("successfully registered");
        ComponentContainer.menuController.singUpMenu();
    }

    public void allProfileList() {
        List<Profile>profileList = ComponentContainer.profileRepository.getAllProfile();
        System.out.println("----------   Profile List ----------");
        profileList.forEach(profile -> System.out.println(profile));
        ComponentContainer.profileController.adminProfileMenu();

    }

    public void profileChangeStatusByPhone(String phone) {
        Profile exist = ComponentContainer.profileRepository.getProfileByPhone(phone);
        if (exist == null) {
            System.out.println("Sorry status isn't exist or not found profile phone");
            return;
        } else if (exist.getStatus().equals(ProfileStatus.ACTIVE)) {
            ComponentContainer.profileRepository.updateProfileByStatus(ProfileStatus.BLOCK.name(), phone);
            ComponentContainer.profileController.adminProfileMenu();

        } else if ( exist.getStatus().equals(ProfileStatus.BLOCK)) {
            ComponentContainer.profileRepository.updateProfileByStatus(ProfileStatus.ACTIVE.name(), phone);
            ComponentContainer.profileController.adminProfileMenu();
        }

        }
    }
