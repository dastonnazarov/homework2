package atto.controller;

import atto.container.ComponentContainer;
import atto.dto.Profile;
import atto.util.ScannerUtil;

public class ProfileController {

    public static void loginProfile() {
        System.out.println("Enter phone: ");
        String phone = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter password: ");
        String password = ComponentContainer.StringScan.nextLine();

        Profile profile = new Profile();
        profile.setPhone(phone);
        profile.setPassword(password);

        ComponentContainer.profileService.loginProfile(profile);
    }

    public static void registrationSection() {
        System.out.println("Enter name: ");
        String name = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter surname: ");
        String surname = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter phone: ");
        String phone = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter password: ");
        String password = ComponentContainer.StringScan.nextLine();

        Profile profile = new Profile();
        profile.setName(name);
        profile.setSurname(surname);
        profile.setPhone(phone);
        profile.setPassword(password);
        ComponentContainer.profileService.registrationProfile(profile);

    }


    public static void adminProfileMenu() {

        System.out.println("-----------  Profile Menu  ----------");
        System.out.println("1. Profile List");
        System.out.println("2. Change Profile Status (by phone)");
        System.out.println("3.Go Back");
        System.out.println("0. Exit");
        adminProfileStart();

    }

    public static void adminProfileStart() {

        while (true) {
            Integer action = ScannerUtil.getAction();
            switch (action) {
                case 1:
                    ComponentContainer.adminController.profileList();
                    break;
                case 2:
                    ComponentContainer.adminController.changeProfileByPhone();
                    break;
                case 3:
                    ComponentContainer.adminController.adminSectionMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("wrong option!");
                    break;
            }
        }
    }


    public static void profileChangeStatusByPhone(){
        System.out.println("------ Change Profile Status (by phone) -------");

        System.out.println("Enter profile phone: ");
        String phone = ComponentContainer.StringScan.nextLine();
        ComponentContainer.profileService.profileChangeStatusByPhone(phone);

    }


}

