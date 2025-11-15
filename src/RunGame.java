import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import Game.Game;

public class RunGame {
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Виселица");
            System.out.println("2. Выход");
            int point = scanner.nextInt();

            switch (point) {
                case 1:
                    Game game = new Game();
                    boolean win = false;
                    while (win == false && game.steps > 0) {
                        win = game.Step();
                    }
                    if (win == true) {
                        System.out.println("Поздравляю вы выиграли! ");
                        System.out.println("Хотите сыграть еще раз?\n");
                        break;
                    }
                    else{
                        System.out.println("К сожалению, вы проиграли.");
                        System.out.println("Хотите сыграть еще раз?\n");
                        break;
                    }
                case 2:
                    System.exit(0);
                
            }

        }
    }
}
