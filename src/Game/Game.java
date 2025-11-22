package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import generate.Generate;
import java.util.List;
import static Game.Utils.*;

public class Game {
    private char[] word;
    private char[] guess;
    private int steps = 6;
    private List<Character> validLetters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    private List<Character> inputedLetters = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Game() {
        this.word = Generate.GenerateWord().toCharArray();
        makeGuess();
    }

    public void makeGuess() {
        this.guess = new char[word.length];
        Random random = new Random();
        Arrays.fill(guess, '_');

        int index = random.nextInt(word.length);
        int index2 = random.nextInt(word.length);
        guess[index] = word[index];
        guess[index2] = word[index2];
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

    public boolean isLetterUsed(char letter) {
        if (inputedLetters.contains(letter)) {
            clearConsole();
            return true;
        }
        return false;
    }

    public char inputLetter() {
        System.out.print("Введите букву (Пример: a / b / w): ");
        String input = scanner.next();
        char letter = input.charAt(0);

        while (!validLetters.contains(letter)) {
            clearConsole();
            System.out.print("Ошибка, введите букву согласно примеру (Пример: a / b / w): ");
            input = scanner.next();
            letter = input.charAt(0);
        }
        return letter;
    }

    public boolean makeStep() throws IOException {
        clearConsole();
        DrawGallows(steps, word, guess);

        char letter = inputLetter();
        boolean isLetterUsed = isLetterUsed(letter);
        inputedLetters.add(letter);
        if(isLetterUsed){
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
            return isWon(guess);

        } else {
            steps = steps - 1;
            clearConsole();
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

    

    
}
