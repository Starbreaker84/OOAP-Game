package org.romalaev;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Создание предметов
        Item sword = new Item("Меч", "Острый стальной меч.");
        Item shield = new Item("Щит", "Прочный деревянный щит.");
        Item potion = new Item("Зелье", "Зелье здоровья.");
        Item key = new Item("Ключ", "Старый ржавый ключ.");
        // Создание локаций
        Location forest = new Location("Лес", "Тёмный густой лес.", sword);
        Location castle = new Location("Замок", "Заброшенный замок.", shield);
        Location cave = new Location("Пещера", "Сырая тёмная пещера.", potion);
        Location village = new Location("Деревня", "Тихая мирная деревня.", key);

        // Установка переходов между локациями
        forest.addExit("восток", village);
        forest.addExit("юг", cave);

        village.addExit("запад", forest);
        village.addExit("юг", castle);

        cave.addExit("север", forest);
        cave.addExit("восток", castle);

        castle.addExit("север", village);
        castle.addExit("запад", cave);

        // Инициализация игрока
        Player player = new Player(forest);

        // Инициализация обработчика команд
        CommandHandler commandHandler = new CommandHandler();

        // Основной цикл игры
        while (player.getVisitedLocations().size() < 4) {
            Location currentLocation = player.getCurrentLocation();

            // Описание текущей локации
            System.out.println("\nВы находитесь: " + currentLocation.getName());
            System.out.println(currentLocation.getDescription());

            // Предмет в локации
            if (currentLocation.getItem() != null) {
                System.out.println("Здесь вы видите: " + currentLocation.getItem().getName());
                System.out.println("Введите 'взять', чтобы подобрать предмет.");
            }

            // Возможные направления
            System.out.println("Возможные направления:");
            for (String direction : currentLocation.getExits().keySet()) {
                System.out.println("- " + direction);
            }

            // Обработка команд игрока
            String command = commandHandler.getCommand();

            if (command.equals("взять") && currentLocation.getItem() != null) {
                player.addItem(currentLocation.getItem());
                System.out.println("Вы подобрали: " + currentLocation.getItem().getName());
                currentLocation.removeItem();
            } else if (currentLocation.getExits().containsKey(command)) {
                player.moveTo(currentLocation.getExits().get(command));
            } else {
                System.out.println("Неизвестная команда или направление. Попробуйте снова.");
            }
        }

        // Отображение концовки
        Ending.displayEnding(player, 4);
    }
}