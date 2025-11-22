import java.io.IOException;
import java.util.Scanner;
import generate.Generate;
import Game.Game;
import Game.Utils;

public class RunGame {
    public static void main(String[] args)  {
        boolean isGameRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isGameRunning) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Виселица");
            System.out.println("2. Выход");
            int point = scanner.nextInt();
            switch (point) {
            case 1:
                Game game = new Game();
                game.startGame();
                break;
            case 2:
                System.exit(0);
         }
        }
        scanner.close();
    }
}
