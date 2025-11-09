package Game;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import generate.*;
public class Game {
    public char[] word;
    public char[] guess;
    public int steps = 6;

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

    public void Step(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите букву: ");
        char letter = scanner.next().charAt(0);
        
        boolean found = false;
        for(int i = 0; i < word.length; i++){
            if(word[i] == letter){
                guess[i] = letter;
                found = true;
            }
        }
        if(found){
            System.out.println("Есть такая буква!");
            IsWon(guess);
        } else {
            System.out.println("Такой буквы нет.");
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

    public void DrawGallows(){
        switch(steps){
            case 0:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |
                   / \\  |
                        |
                ________|
                0 попыток(
                """);
            case 1:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |
                   /    |
                        |
                ________|
                1 попытка
                """);
            case 2:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                   /|\\  |
                        |
                        |
                ________|
                2 попытки
                """);
            case 3:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                   /|   |
                        |
                        |
                ________|
                3 попытки
                """);
            case 4:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                    |   |
                        |
                        |
                ________|
                4 попытки
                """);
            case 5:
                System.err.println("""
                    +---+
                    |   |
                    O   |
                        |
                        |
                        |
                ________|
                5 попыток
                """);
            case 6:
                System.err.println("""
                    +---+
                    |   |
                        |
                        |
                        |
                        |
                ________|
                6 попыток
                """);
        }
    }
}
