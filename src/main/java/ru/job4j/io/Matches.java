package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int matches = 11;
        System.out.println("Введите имя первого игрока");
        String Player1 = input.nextLine();
        System.out.println("Введите имя второго игрока");
        String Player2 = input.nextLine();
        String CurrentPlayer = Player1;
        while (matches > 0) {
            System.out.println("На столе лежат " + matches + " спичек");
            System.out.println(CurrentPlayer + " введи количество спичек");
            int select = Integer.valueOf(input.nextLine());
            if (select >= 1 && select <= 3) {
                matches = (matches - select >= 0) ? matches - select : matches;
                if (matches == 0) {
                    System.out.println("Победил " + CurrentPlayer);
                }
            }
            else {
                System.out.println("Можно брать только от 1 до 3 спичек");
            }
            CurrentPlayer = (CurrentPlayer.equals(Player1)) ? Player2 : Player1;
        }
    }
}
