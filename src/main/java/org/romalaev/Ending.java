package org.romalaev;

public class Ending {
    public static void displayEnding(Player player, int totalLocations) {
        System.out.println("\nИгра окончена!");

        if (player.getInventory().size() == totalLocations) {
            System.out.println("Поздравляем! Вы собрали все предметы и успешно завершили игру!");
        } else {
            System.out.println("Вы завершили игру, но не собрали все предметы.");
        }

        System.out.println("Собранные предметы:");
        for (Item item : player.getInventory()) {
            System.out.println("- " + item.getName());
        }
    }
}
