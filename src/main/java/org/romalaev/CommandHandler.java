package org.romalaev;

import java.util.Scanner;

public class CommandHandler {
    private Scanner scanner;

    public CommandHandler() {
        scanner = new Scanner(System.in);
    }

    public String getCommand() {
        System.out.print("> ");
        return scanner.nextLine().trim().toLowerCase();
    }
}
