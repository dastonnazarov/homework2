package atto.controller;


import atto.container.ComponentContainer;
import atto.repository.ProfileRepository;
import atto.service.ProfileService;
import atto.util.ScannerUtil;

public class AdminController {

    public static void adminSectionMenu() {
        System.out.println("-----------  Admin Menu  ----------");
        System.out.println("1. Card Section");
        System.out.println("2. Terminal Section");
        System.out.println("3. Profile Section");
        System.out.println("4. Transaction Section");
        System.out.println("5. Statistic Section");
        System.out.println("6.Go Back");
        System.out.println("0. Exit");
        adminSectionStart();

    }

    public static void adminSectionStart() {

        while (true) {
            Integer action = ScannerUtil.getAction();
            switch (action) {
                case 1:
                    CardController.adminCardMenu();
                    break;
                case 2:
                    TerminalController.adminTerminalMenu();
                    break;
                case 3:
                    ProfileController.adminProfileMenu();
                    break;
                case 4:
                 //  TransactionController.adminTransactionMenu();
                    break;
                case 5:
                    break;
                case 6:
                    MenuController.singUpMenu();
                case 0:
                    return;
                default:
                    System.out.println("wrong option!");
                    break;
            }
        }
    }


    public void profileList() {
        ComponentContainer.profileService.allProfileList();
    }


    public static void changeProfileByPhone() {
        ComponentContainer.profileController.profileChangeStatusByPhone();
    }
}
