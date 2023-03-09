package atto.controller;
import atto.util.ScannerUtil;


public class MenuController {

/*    public static Integer getAction() {
        System.out.print("choose option: ");
        Integer number = ComponentContainer.numberScan.nextInt();
        return number;
    }*/
    public static void singUpMenu() {
        System.out.println("----------- Atto Menu  ----------");
        System.out.println("1.Login");
        System.out.println("2.Registration");
        System.out.println("0.Exit");
        startAttoSection();
    }
    public static void startAttoSection() {
        while (true){
            Integer action = ScannerUtil.getAction();
            switch (action) {
                case 1:
                    ProfileController.loginProfile();
                    break;
                case 2:
                    ProfileController.registrationSection();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("wrong option!!!");
                    break;
            }
        }
    }

}
