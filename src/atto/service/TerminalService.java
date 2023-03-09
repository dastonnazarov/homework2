package atto.service;

import atto.container.ComponentContainer;

import atto.dto.Card;
import atto.dto.Terminal;
import atto.enums.CardStatus;
import atto.enums.TerminalStatus;

import java.util.List;

public class TerminalService {
    public void checkTerminal(Terminal terminal) {

        Terminal  exist = ComponentContainer.terminalRepository.getTerminalByCode(terminal.getCode());
        if (exist != null) {
            System.out.println("Sorry Terminal already is exist!!!");
            ComponentContainer.terminalController.adminTerminalMenu();
            ComponentContainer.terminalController.createTerminal();
        } else{
            ComponentContainer.terminalRepository.saveTerminal(terminal);
            System.out.println("Terminal is  create  successfully");
            ComponentContainer.terminalController.adminTerminalMenu();
        }
    }

    public void allTerminalList() {
        List<Terminal> terminalList = ComponentContainer.terminalRepository.getAll();
        System.out.println("------- Terminal List -------");
        terminalList.forEach(terminal -> System.out.println(terminal));
        ComponentContainer.terminalController.adminTerminalMenu();
    }

    public void updateTerminalService(Terminal terminal) {
        Terminal exist = ComponentContainer.terminalRepository.getTerminalByCode(terminal.getCode());
        if (exist != null) {
            ComponentContainer.terminalRepository.updateTerminal(terminal);
            System.out.println("Terminal is  update  successfully");
            ComponentContainer.terminalController.adminTerminalMenu();
        } else {
            System.out.println("Sorry terminal isn't  create  yet!!!");
            ComponentContainer.terminalController.adminTerminalMenu();
        }
    }

    public void deleteTerminal(Terminal terminal) {
        Terminal exist = ComponentContainer.terminalRepository.getTerminalByCode(terminal.getCode());
        if (exist == null) {
            System.out.println("Terminal doesn't find !!!");
            ComponentContainer.terminalController.adminTerminalMenu();
            return;
        } else {
            ComponentContainer.terminalRepository.deleteTerminal(terminal.getCode());
            System.out.println("Terminal is successfully delete");
            ComponentContainer.terminalController.adminTerminalMenu();
        }

    }

    public void terminalChangeStatus(String code) {
        Terminal exist = ComponentContainer.terminalRepository.getTerminalByCode(code);
        if (exist == null) {
            System.out.println("Sorry status isn't exist or not found card number");
            return;
        } else if (exist.getStatus().equals(TerminalStatus.ACTIVE)) {
            ComponentContainer.terminalRepository.updateCardByStatus(TerminalStatus.BLOCK, code);
            ComponentContainer.terminalController.adminTerminalMenu();
        } else if ( exist.getStatus().equals(TerminalStatus.BLOCK)) {
            ComponentContainer.terminalRepository.updateCardByStatus(TerminalStatus.ACTIVE, code);
            ComponentContainer.terminalController.adminTerminalMenu();

        }
    }
}
