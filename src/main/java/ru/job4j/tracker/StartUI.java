package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Введите id Заявки: "));
        String name = input.askStr("Введите Имя Заявки: ");
        Item item = new Item();
        item.setName(name);
        if (tracker.replace(id, item)){
            System.out.println("Замена успешно произведена");
        } else {
            System.out.println("Замена не произведена");
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
    int id = Integer.valueOf(input.askInt("Введите id удаляемой Заявки: "));
                if (tracker.delete(id)){
        System.out.println("Заявка удалена с id: " + id);
    } else {
        System.out.println("Заявка не удалена");
        }
    }
    public static void findById(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Введите id Заявки, которую необходимо найти "));
        Item items = new Item();
        items = tracker.findById(id);
        if (items != null) {
            System.out.println(items);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }
    public static void findByName(Input input, Tracker tracker) {
        String name = input.askStr("Введите Имя Заявки, которую необходимо найти ");
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

        public void init (Input input, Tracker tracker){
            boolean run = true;
            while (run) {
                this.showMenu();
                int select = Integer.valueOf(input.askInt("Select: "));
                if (select == 0) {
                    createItem(input, tracker);
                } else if (select == 1) {
                    Item[] items = new Item[0];
                    items = tracker.findAll();
                    for (int index = 0; index < items.length; index++) {
                        System.out.println(items[index]);
                    }
                } else if (select == 2) {
                    replaceItem(input, tracker);
                } else if (select == 3) {
                    deleteItem(input, tracker);
                }
            else if (select == 4) {
                        findById(input, tracker);
                    } else if (select == 5) {
                        findByName(input, tracker);
                    } else if (select == 6) {
                        run = false;
                    }
                }
            }

            private void showMenu () {
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

    public static void main (String[]args){
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}