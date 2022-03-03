import java.util.Random;
import java.util.Scanner;

public class Hw4testt {

        public static void main(String[] args) {
            String[][] map = initField(3);
            boolean isGameActive = true;
            System.out.println("Игра началась");

            printMap(map);
            while (isGameActive) {
                playerTurn(map);
                printMap(map);
                if (isWinner("X", map) || isBothLose(map)) {
                    isGameActive = false;
                    break;
                }
                computerTurn(map);
                printMap(map);
                if (isWinner("0", map) || isBothLose(map)) {
                    isGameActive = false;
                    break;
                }
            }
        }
        public static boolean isWinner (String mark, String[][]map){

            for (int i = 0; i < map.length; i++) {
                if (map[i][0] == mark && map[i][1] == mark && map[i][2] == mark) {
                    System.out.println(mark + " победил");
                    return true;
                }
            }

            for (int i = 0; i < map.length; i++) {
                if (map[0][i] == mark && map[1][i] == mark && map[2][i] == mark) {
                    System.out.println(mark + " победил");
                    return true;
                }
            }

            if (map[0][0] == mark && map[1][1] == mark && map[2][2] == mark) {
                System.out.println(mark + " победил");
                return true;
            }

            if (map[2][0] == mark && map[1][1] == mark && map[0][2] == mark) {
                System.out.println(mark + " победил");
                return true;
            }
            return false;
            }

        public static boolean isBothLose (String[][]map){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; i < map.length; i++) {
                    if (map[i][j].equals("*")) {
                        return false;
                    }
                }
            }
            System.out.println("Ничья");
            return true;
        }

        public static void computerTurn (String[][]map){
            System.out.println("Компьютер ходит ждите");

            Random random = new Random();

            boolean isActiveTurn = true;

            while (isActiveTurn) {

                int x = random.nextInt(map[0].length);
                int y = random.nextInt(map.length);

                if (map[x][y].equals("*")) {
                    map[x][y] = "0";
                    isActiveTurn = false;
                }
            }
            System.out.println("Комп сходил");
        }

        public static void playerTurn (String[][]map){

            System.out.println("Кожаный ходит. На какие клетки?");

            Scanner sc = new Scanner(System.in);


            boolean isActiveTurn = true;

            while (isActiveTurn) {

                int x = sc.nextInt();
                int y = sc.nextInt();

                if ((x > 0 && x <= map[0].length) && (y > 0 && y <= map.length)) {
                    if (map[x - 1][y - 1].equals("*")) {
                        map[x - 1][y - 1] = "X";
                        isActiveTurn = false;
                    } else {
                        System.out.println("Вы сходили на занятую ячейку");
                    }
                } else {
                    System.out.println("Вы вышли за пределы поля");
                }
            }
        }

        public static void printMap (String[][]map){
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static String[][] initField ( int size){
            String[][] map = new String[size][size];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j] = "*";
                }

            }
            return map;
        }

    }



