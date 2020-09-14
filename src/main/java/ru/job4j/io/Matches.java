package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        boolean run = true;
        while (run) {
            System.out.println("На столе лежат " + matches + " спичек");
            int select = Integer.valueOf(input.nextLine());
            if (select >= 1 && select <= 3) {
                matches = (matches - select >= 0) ? matches - select : matches;
                if (matches == 0) {
                    run = false;
                    System.out.println("Вы победили");
                }
            }
            else {
                System.out.println("Можно брать только от 1 до 3 спичек");
            }
        }
    }
}
