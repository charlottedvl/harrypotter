package com.isep.harrypotter;

import java.util.Random;
import java.util.Scanner;

public class Utiles {



    public static int choice(int i){
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
