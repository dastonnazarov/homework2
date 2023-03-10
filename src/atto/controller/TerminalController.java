package atto.controller;

import atto.container.ComponentContainer;
import atto.dto.Terminal;
import atto.util.ScannerUtil;

public class TerminalController {

    public static void adminTerminalMenu() {
        System.out.println("-----------  Terminal Menu  ----------");
        System.out.println("1.Create Terminal");
        System.out.println("2.Terminal List");
        System.out.println("3.Update Terminal (code,address)");
        System.out.println("4.Change Terminal status");
        System.out.println("5.Delete Terminal");
        System.out.println("6.Go Back");
        System.out.println("0.Exit");
        adminByTerminalStart();
    }

    public static void adminByTerminalStart() {
        boolean bool = true;
        while (bool) {
            Integer action = ScannerUtil.getAction();
            switch (action) {
                case 1:
                    createTerminal();
                    break;
                case 2:
                    terminalList();
                    break;
                case 3:
                    updateTerminal();
                    break;
                case 4:
                    changeTerminalStatus();
                    break;
                case 5:
                    deleteTerminal();
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
    public static void createTerminal() {
        System.out.println("Enter Terminal code: ");
        String code = ComponentContainer.StringScan.nextLine();

        System.out.println("Enter Terminal address: ");
        String address = ComponentContainer.StringScan.nextLine();

        Terminal terminal = new Terminal();
        terminal.setCode(code);
        terminal.setAddress(address);
        ComponentContainer.terminalService.checkTerminal(terminal);
    }

    public static void terminalList() {
        ComponentContainer.terminalService.allTerminalList();
    }

    public static void updateTerminal() {
        System.out.println("Enter Terminal code: ");
        String number = ComponentContainer.StringScan.nextLine();
        System.out.println("Enter Terminal new update address: ");
        String address = ComponentContainer.StringScan.nextLine();

        Terminal terminal = new Terminal();
        terminal.setCode(number);
        terminal.setAddress(address);
        ComponentContainer.terminalService.updateTerminalService(terminal);
    }

    public static void changeTerminalStatus() {
        System.out.println("------ Terminal change status -------");

        System.out.println("Enter terminal number: ");
        String code = ComponentContainer.StringScan.nextLine();
        ComponentContainer.terminalService.terminalChangeStatus(code);
    }

    public static void deleteTerminal() {
        System.out.println("Enter delete terminal code: ");
        String code = ComponentContainer.StringScan.nextLine();

        Terminal terminal = new Terminal();
        terminal.setCode(code);
        ComponentContainer.terminalService.deleteTerminal(terminal);
    }

}



