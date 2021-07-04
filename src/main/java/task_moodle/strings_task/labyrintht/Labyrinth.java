package task_moodle.strings_task.labyrintht;

import java.util.Scanner;

/**
 * Написать игру.
 * <p>
 * Игровое поле - 10 х 10 ячеек. начальная позиция героя в левом верхнем углу.
 * Разными  символами обозначайте тропу и препятствия. Используйте Scanner для приема символов из консоли.
 * Символами wasd управляйте движением героя. Место, где находится герой, обозначте симовлом "X".
 * Для движения героя используйте унарные инкременты/декременты и switch-case
 */
public class Labyrinth {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String EMPTY = "⬜";
    private static final String HERO = "X";
    private static final int COUNT = 38;
    private static String[][] field = {
            {"X", "☢", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "⚐"},
            {"⬜", "☢", "⬜", "☢", "⬜", "☢", "⬜", "⬜", "☢", "☢"},
            {"⬜", "☢", "☢", "☢", "⬜", "☢", "⬜", "⬜", "⬜", "⬜"},
            {"⬜", "☢", "⬜", "⬜", "☢", "☢", "⬜", "☢", "⬜", "⬜"},
            {"⬜", "☢", "⬜", "⬜", "☢", "☢", "⬜", "⬜", "☢", "⬜"},
            {"⬜", "⬜", "⬜", "⬜", "☢", "☢", "☢", "⬜", "⬜", "☢"},
            {"⬜", "⬜", "⬜", "⬜", "☢", "☢", "☢", "⬜", "⬜", "☢"},
            {"⬜", "☢", "☢", "⬜", "⬜", "⬜", "⬜", "⬜", "⬜", "☢"},
            {"⬜", "☢", "☢", "⬜", "⬜", "⬜", "☢", "⬜", "⬜", "☢"},
            {"☢", "⬜", "☢", "☢", "⬜", "⬜", "☢", "⬜", "⬜", "☠"},
    };
    private static int x = 0;
    private static int y = 0;
    private static boolean isAlive = true;

    public static void main(String[] args) {
        while (isAlive) {
            try {
                printField();
                field[x][y] = EMPTY;
                move();
                isAlive = !isDeadFromPoisson();
                if (x == 0 && y == 9) {
                    System.out.println("YOU WIN!");
                    break;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                isAlive = false;
                System.out.println("YOU MOVE and cross the border. YOU DEAD!");
            }
        }
    }

    private static void printField() {
        for (String[] symbols : field) {
            for (String symbol : symbols) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean isDeadFromPoisson() {
        int count = 0;
        for (String[] symbols : field) {
            for (String symbol : symbols) {
                if (symbol.equals("☢")) {
                    count++;
                }
            }
        }
        if (count == COUNT) {
            return false;
        }
        System.out.println("You are dead from poison");
        return true;
    }

    private static void move() {
        String action = SCANNER.next();
        switch (action) {
            case "w":
                x--;
                break;
            case "a":
                y--;
                break;
            case "s":
                x++;
                break;
            case "d":
                y++;
                break;
            default:
                break;
        }
        field[x][y] = HERO;
    }
}
