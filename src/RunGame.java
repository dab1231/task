import java.io.IOException;
import java.util.Scanner;
import Utils.StringUtils;
import generate.Generate;
import Game.Game;

public class RunGame {
    public static void main(String[] args) throws IOException {
        boolean isGameRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isGameRunning) {
            System.out.println("Выберите пункт меню:");
            System.out.println("1. Виселица");
            System.out.println("2. Выход");
            try {
                int point = scanner.nextInt();
                switch (point) {
                case 1:
                    char[] extractedCharsFromString = StringUtils.getChars(Generate.GenerateWord());
                    char[] guess = Game.makeGuess(extractedCharsFromString);
                    Game game = new Game(extractedCharsFromString, guess);
                    game.startGame();
                    break;
                case 2:
                    System.exit(0);
            }
            } catch (IOException e) {
                System.out.println("Ошибка ввода, введите число 1 или 2");
            }
        }
        scanner.close();
    }
}
