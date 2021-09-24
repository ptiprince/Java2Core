package Java1.Tictoc;

import java.util.Random;
import java.util.Scanner;

public class MainLesson4  {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    public static char[][] map;
    private static final int SIZE = 5;
    private static final int LINE_LENGTH = 4;
    private static final int MAP_SIZE = 5;

    private static final char MAP_ELEMENT_EMPTY = '*';
    private static final char MAP_ELEMENT_X = 'X';
    private static final char MAP_ELEMENT_O = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            playerTurn();
            printMap();
            if (checkWinner('X')) {
                System.out.println("Player won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("No winner");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinner('O')) {
                System.out.println("AI won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("No winner");
                break;
            }
        }
    }
    // starX, Y - variables of 1st point where Player put "X", start of checking the line of 4 "X" (or "O" for AI potentially).
    // vX, Vy - variables of movement (x++, y++) and (x++, y--) for diagonals, (x++, y) for horizontal, (x, y++) - vertical
    public static boolean checkLine(int startX, int startY, int vX, int vY, char element) {
        if (startX + (LINE_LENGTH - 1) * vX < 0 || startY + (LINE_LENGTH - 1) * vY < 0 ||
                startX + (LINE_LENGTH - 1) * vX >= MAP_SIZE || startY + (LINE_LENGTH - 1) * vY >= MAP_SIZE) {
            return false;}
        //This is checking if we r not going out of the field. If we r out - false}
        for (int i = 0; i < LINE_LENGTH; i++) {
            if (map[startX + i * vX][startY + i * vY] != element) {
                // checking lines and returning false if line is not found
                return false;
            }
        }
        return true;// returns true if line found
    }

    public static boolean checkWinner(char element) {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (checkLine(i, j, 1, 0, element) || checkLine(i, j, 0, 1, element)
                        || checkLine(i, j, 1, 1, element) || checkLine(i, j, 1, -1, element)) {
                    // 1st condition - moving horizontal, 2nd - vertical, 3rd & 4th - diagonals
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));
        map[x][y] = MAP_ELEMENT_O;
        System.out.println("AI - " + (x + 1) + " " + (y+1));
    }

    // There is aiTurn with analysis. Check if it is correct as I'm not sure:
    // public static void aiTurn() {
    // int x = -1, y = -1;
    //  boolean aiWon = false,
    //  boolean playerWon = false;
    // for (int i = 0; i < LINE_LENGTH; i++) {
    //  for (int j = 0; j < LINE_LENGTH; j++) {
    //    if (!isCellEmpty(i, j)) {
    //    if (checkWinner('O')) {
    //          x = i; y = j; aiWon = true;}
    //      map[i][j] = MAP_ELEMENT_EMPTY;
    //   }
    //  }
    // } if (!aiWon){
    //  for (int i = 0; i < LINE_LENGTH; i++) {
    //  for (int j = 0; j < LINE_LENGTH; j++) {
    //     if (!isCellEmpty(i, j)) {
    //       map[i][j] = MAP_ELEMENT_X;
    //        if (checkWinner('X')) {
    //           x = i; y = j; playerWon = true;}
    //       map[i][j] = MAP_ELEMENT_EMPTY;
    //   }
    //  }
    //  }
    // } else {//if (!aiWon && !playerWon){
    // do {
    //  x = random.nextInt(SIZE);
    //  y = random.nextInt(SIZE);
    //  } while (!isCellEmpty(x, y));
    //   map[x][y] = MAP_ELEMENT_O;
    // System.out.println("AI - " + (x + 1) + " " + (y+1));
    //    }
    //}

    public static void playerTurn() {
        int x, y;
        do {
            System.out.println("Enter coordinates ('X Y')");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[x][y] = MAP_ELEMENT_X;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (map[x][y] != MAP_ELEMENT_EMPTY) {
            return false;
        }
        return true;
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = MAP_ELEMENT_EMPTY;
            }
        }
    }
}
