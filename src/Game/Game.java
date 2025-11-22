package Game;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import generate.Generate;
import java.util.List;

public class Game {
    private char[] word;
    private char[] guess;
    private int steps = 6;
    private List<Character> validLetters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private List<Character> inputedLetters = new ArrayList<>();

    public Game(char[] word, char[] guess) {
        this.word = word;
        this.guess = guess;
    }

    public char[] makeGuess() {
        this.guess = new char[word.length];
        Random random = new Random();
        Arrays.fill(guess, '_');

        int index = random.nextInt(word.length);
        int index2 = random.nextInt(word.length);
        guess[index] = word[index];
        guess[index2] = word[index2];
        return this.guess;
    }

    public void startGame() {
        boolean win = false;
        while (win == false && steps > 0) {
            try {
                win = makeStep();
            } catch (IOException e) {
                throw new RuntimeException("Ошибка ввода: " + e.getMessage());
            }
        }
        if (win == true) {
            System.out.println("Поздравляю вы выиграли! ");
            System.out.println("Хотите сыграть еще раз?\n");
        } else {
            System.out.println("К сожалению, вы проиграли.");
            System.out.println("Хотите сыграть еще раз?\n");
        }
    }

    public boolean makeStep() throws IOException {
        clearConsole();
        InputStreamReader isr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(isr);
        DrawGallows();

        System.out.print("Введите букву (Пример: a / b / w): ");
        String input = scanner.next();
        char letter = input.charAt(0);

        while (!validLetters.contains(letter)) {
            clearConsole();
            System.out.print("Ошибка, введите букву согласно примеру (Пример: a / b / w): ");
            input = scanner.next();
            letter = input.charAt(0);
        }

        if (inputedLetters.contains(letter)) {
            clearConsole();
            inputedLetters.add(letter);
            return isWon(guess);
        }

        boolean found = false;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == letter) {
                guess[i] = letter;
                found = true;
            }
        }

        if (found) {
            clearConsole();
            inputedLetters.add(letter);
            return isWon(guess);

        } else {
            if (inputedLetters.contains(letter)) {
                clearConsole();
                inputedLetters.add(letter);
                return isWon(guess);
            }
            steps = steps - 1;
            clearConsole();
            inputedLetters.add(letter);
            return isWon(guess);
        }
    }

    public boolean isWon(char[] word) {
        for (int i = 0; i < word.length; i++) {
            if (!(word[i] == this.word[i])) {
                return false;
            }
        }
        return true;
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void DrawGallows() {
        switch (steps) {
            case 0:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                           /|\\  |
                           / \\  |
                                |
                        ________|
                        0 попыток(
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 1:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                           /|\\  |
                           /    |
                                |
                        ________|
                        1 попытка
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 2:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                           /|\\  |
                                |
                                |
                        ________|
                        2 попытки
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 3:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                           /|   |
                                |
                                |
                        ________|
                        3 попытки
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 4:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                            |   |
                                |
                                |
                        ________|
                        4 попытки
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 5:
                System.out.println("""
                            +---+
                            |   |
                            O   |
                                |
                                |
                                |
                        ________|
                        5 попыток
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
            case 6:
                System.out.println("""
                            +---+
                            |   |
                                |
                                |
                                |
                                |
                        ________|
                        6 попыток
                        """);
                System.out.println(word);
                System.out.println(guess);
                break;
        }
    }
}
