package com.isep.harrypotter;


import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter @Getter
public class Utiles {



    public int choice(int i){
        Scanner scanner = new Scanner(System.in);
        int choice;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= i) {
                    break;
                } else {
                    System.out.println("Please enter a valid number between 1 and " + i);
                }
            } else {
                System.out.println("Please enter a valid integer");
                scanner.next();
            }
        }
        return choice;
    }
}
