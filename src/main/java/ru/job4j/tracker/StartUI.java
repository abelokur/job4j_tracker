package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            /* if */
            }
            else if (select == 1) {
                System.out.println(select);
                Item[] items = new Item[0];
                items = tracker.findAll();
                for (int index = 0; index < items.length; index++) {
                    System.out.println(items[index]);
                }
            }
            else if (select == 2) {
                System.out.print("Введите id Заявки: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Введите Имя Заявки: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                if (tracker.replace(id, item)){
                    System.out.println("Замена успешно произведена");
                } else {
                    System.out.println("Замена не произведена");
                }
            }
            else if (select == 3) {
                System.out.print("Введите id удаляемой Заявки: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)){
                    System.out.println("Заявка удалена с id: " + id);
                } else {
                    System.out.println("Заявка не удалена");
                }
            }
            else if (select == 4) {
                System.out.print("Введите id Заявки, которую необходимо найти ");
                int id = Integer.valueOf(scanner.nextLine());
                Item items = new Item();
                items = tracker.findById(id);
                if (items != null) {
                    System.out.println(items);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            }
            else if (select == 5) {
                System.out.print("Введите Имя Заявки, которую необходимо найти ");
                String name = scanner.nextLine();
                Item[] items = new Item[0];
                items = tracker.findByName(name);
                if (items.length > 0) {
                    for (int index = 0; index < items.length; index++) {
                        System.out.println(items[index]);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        /* добавить остальные пункты меню. */
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}