import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printGrid(int grid[][]) {
        int b = 1;
        System.out.print("\n    ");
        for (int i = 0; i < 10; i++) {
            System.out.print(b + " ");
            b++;
        }
        System.out.print("\n    ");
        for (int i = 0; i < 10; i++) {
            System.out.print("_ ");
        }
        System.out.print("\n");
        char s = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + s + " |");
            s++;
            for (int j = 0; j < 10; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("_|");
                } else if (grid[i][j] == 1) {
                    System.out.print("X|");
                } else {
                    System.out.print("#|");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static String getLogo() {
        String logo = "";
        try {
            File myObj = new File("logo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                logo += data + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return logo;
    }

    public static void main(String[] args) {

        int grid[][] = new int[10][10];
        int ships[][] = new int[10][10];
        int temp[][] = new int[10][10];
        int d, rx, ry, x = 0, y;
        Random rand = new Random();

        boolean reset = false;

        /// SHIP POSITIONS
        // Ship size 5
        d = rand.nextInt(2);
        rx = rand.nextInt(6);
        ry = rand.nextInt(6);
        if (d == 0) {
            ry = rand.nextInt(10);
            for (int i = rx; i < rx + 5; i++) {
                ships[i][ry] = 1;
            }
        } else {
            rx = rand.nextInt(10);
            for (int i = ry; i < ry + 5; i++) {
                ships[rx][i] = 1;
            }
        }
        // Ship size 4
        reset = false;
        do {

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    temp[i][j] = 0;
                }
            }
            d = rand.nextInt(2);
            rx = rand.nextInt(7);
            ry = rand.nextInt(7);
            if (d == 0) {
                ry = rand.nextInt(10);
                for (int i = rx; i < rx + 4; i++) {
                    if (ships[i][ry] == 1) {
                        reset = true;
                    }
                    temp[i][ry] = 1;
                }
            } else {
                rx = rand.nextInt(10);
                for (int i = ry; i < ry + 4; i++) {
                    if (ships[rx][i] == 1) {
                        reset = true;
                    }
                    temp[rx][i] = 1;
                }
            }
        } while (reset);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (temp[i][j] == 1) {
                    ships[i][j] = 1;
                }
            }
        }
        // Ship size 3
        reset = false;
        do {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    temp[i][j] = 0;
                }
            }
            d = rand.nextInt(2);
            rx = rand.nextInt(8);
            ry = rand.nextInt(8);
            if (d == 0) {
                ry = rand.nextInt(10);
                for (int i = rx; i < rx + 3; i++) {
                    if (ships[i][ry] == 1) {
                        reset = true;
                    }
                    temp[i][ry] = 1;
                }
            } else {
                rx = rand.nextInt(10);
                for (int i = ry; i < ry + 3; i++) {
                    if (ships[rx][i] == 1) {
                        reset = true;
                    }
                    temp[rx][i] = 1;
                }
            }
        } while (reset);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (temp[i][j] == 1) {
                    ships[i][j] = 1;
                }
            }
        }
        // Ship size 3
        reset = false;
        do {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    temp[i][j] = 0;
                }
            }
            d = rand.nextInt(2);
            rx = rand.nextInt(8);
            ry = rand.nextInt(8);
            if (d == 0) {
                ry = rand.nextInt(10);
                for (int i = rx; i < rx + 3; i++) {
                    if (ships[i][ry] == 1) {
                        reset = true;
                    }
                    temp[i][ry] = 1;
                }
            } else {
                rx = rand.nextInt(10);
                for (int i = ry; i < ry + 3; i++) {
                    if (ships[rx][i] == 1) {
                        reset = true;
                    }
                    temp[rx][i] = 1;
                }
            }
        } while (reset);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (temp[i][j] == 1) {
                    ships[i][j] = 1;
                }
            }
        }
        // Ship size 2
        reset = false;
        do {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    temp[i][j] = 0;
                }
            }
            d = rand.nextInt(2);
            rx = rand.nextInt(9);
            ry = rand.nextInt(9);
            if (d == 0) {
                ry = rand.nextInt(10);
                for (int i = rx; i < rx + 2; i++) {
                    if (ships[i][ry] == 1) {
                        reset = true;
                    }
                    temp[i][ry] = 1;
                }
            } else {
                rx = rand.nextInt(10);
                for (int i = ry; i < ry + 2; i++) {
                    if (ships[rx][i] == 1) {
                        reset = true;
                    }
                    temp[rx][i] = 1;
                }
            }
        } while (reset);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (temp[i][j] == 1) {
                    ships[i][j] = 1;
                }
            }
        }
        // cheats(ships);

        // Logo
        String logo = getLogo();
        System.out.println(logo);

        // Highscores
        String names[] = new String[3];
        int scores[] = new int[3];

        try {
            File myObj = new File("highscores.txt");
            Scanner myReader = new Scanner(myObj);
            for (int i = 0; i < 3; i++) {
                String data = myReader.nextLine();
                names[i] = data;
            }
            for (int i = 0; i < 3; i++) {
                String data = myReader.nextLine();
                scores[i] = Integer.parseInt(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println("High scores:");
        for (int i = 0; i < 3; i++) {
            System.out.println(names[i] + " " + Integer.toString(scores[i]));
        }
        System.out.println("\n");

        // Play
        Scanner sc = new Scanner(System.in);
        System.out.println("Press enter to play");
        sc.nextLine();
        cls();

        int attempts = 0, sunk = 0;
        String s;

        do {
            cls();
            printGrid(grid);
            s = sc.next();
            y = sc.nextInt();
            char ss = s.toUpperCase().charAt(0);
            x = ss - 64;
            if (x < 11 && y < 11 && grid[x - 1][y - 1] == 0) {
                if (ships[x - 1][y - 1] == 1) {
                    grid[x - 1][y - 1] = 2;
                    sunk++;
                } else {
                    grid[x - 1][y - 1] = 1;
                }
                attempts++;
            }
        } while (sunk != 17);

        cls();
        printGrid(grid);

        System.out.println("Name:  ");
        String name = sc.next();

        int score = (int) Math.round(100 - ((attempts - 17) * 1.2));
        System.out.println("Score: " + score + "\n");

        int tt;
        String ttt;

        for (int i = 0; i < 3; i++) {
            if (score > scores[i]) {
                for (int j = 2; j > i; j--) {
                    tt = scores[j];
                    scores[j] = scores[j - 1];
                    scores[j - 1] = tt;

                    ttt = names[j];
                    names[j] = names[j - 1];
                    names[j - 1] = ttt;
                }
                scores[i] = score;
                names[i] = name;
                break;
            }
        }

        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter("highscores.txt"));
            for (int i = 0; i < 3; i++) {
                writer.write(names[i] + "\n");
            }
            for (int i = 0; i < 3; i++) {
                writer.write(scores[i] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}