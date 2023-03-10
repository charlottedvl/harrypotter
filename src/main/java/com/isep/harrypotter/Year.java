package com.isep.harrypotter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@AllArgsConstructor
@Getter @Setter
public class Year {
    int numberYear;
    String number;// first, second, third...
    String name;
    String lieu;
    Boss boss;
    public void yearProgress(Year year){
        System.out.println(year.name);
        System.out.println("Welcome to your " + year.number + " year at Hogwarts School !");
        for (int trimester = 1; trimester < 4; trimester++){
            int action = ChoiceAction(trimester);
        }
    }

    public static int ChoiceAction(int trimester){
        String number ="";
        switch (trimester){
            case 1->number = "first";
            case 2->number = "second";
            case 3->number = "third";
            default-> System.out.println("An error occured, please restart the game");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do of your " + number + " trimester at Hogwarts ? (Please enter the number of the action)");
        System.out.println("1. Follow the sorcery lesson");
        System.out.println("2. Follow the potion lesson");
        System.out.println("3. Skip class and have fun");
        int action = scanner.nextInt();
        return action;
    }
}
