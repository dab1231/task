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
    public char[] word;
    public char[] guess;
    public int steps = 6;
    public List<Character> validLetters = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public List<Character> inputedLetters = new ArrayList<>();



    public Game() throws IOException {
        word = getChars(Generate.GenerateWord());
        guess = makeGuess();
    }
    
    public char[] getChars(String word) {
        this.word = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            this.word[i] = word.charAt(i);
        }
        return this.word;
    }

    public char[] makeGuess() {
        this.guess = new char[word.length];
        Random random = new Random();
        for(int i = 0; i < guess.length; i++){
            guess[i] = '_';
        }
        int index = random.nextInt(word.length);
        int index2 = random.nextInt(word.length);
        guess[index] = word[index];
        guess[index2] = word[index2];
        return this.guess;
    }
    

    public boolean Step() throws IOException{
        clearConsole();
        InputStreamReader isr = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        Scanner scanner = new Scanner(isr);
        DrawGallows();

        System.out.print("Введите букву (Пример: a / b / w): ");
        String input = scanner.next();
        char letter = input.charAt(0);

        while(!validLetters.contains(letter)){
            clearConsole();
            System.out.print("Ошибка, введите букву согласно примеру (Пример: a / b / w): ");
            input = scanner.next();
            letter = input.charAt(0);
        }
        
        boolean found = false;
        for(int i = 0; i < word.length; i++){
            if(word[i] == letter){
                guess[i] = letter;
                found = true;
            }
        }

        if(found){
            clearConsole();
            inputedLetters.add(letter);
            return IsWon(guess);
            
        } else {
            if(inputedLetters.contains(letter)){
                clearConsole();
                inputedLetters.add(letter);
                return IsWon(guess);
            }
            steps = steps - 1;
            clearConsole();
            inputedLetters.add(letter);
            return IsWon(guess);
        }
    }

    public boolean IsWon(char[] word){
        for(int i = 0; i < word.length; i++){
            if(!(word[i] == this.word[i])){
                return false;
            }
        }
        return true;
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void DrawGallows(){
        switch(steps){
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
