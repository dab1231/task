package Game;

public class Utils {
    private static final String[] hangmanPictures = {
        """
                            +---+
                            |   |
                            O   |
                           /|\\ |
                           / \\ |
                                |
                        ________|
                        """,
        """
                            +---+
                            |   |
                            O   |
                           /|\\ |
                           /    |
                                |
                        ________|
                        """,
                        """
                            +---+
                            |   |
                            O   |
                           /|\\ |
                                |
                                |
                        ________|
                        """,
        """
                            +---+
                            |   |
                            O   |
                           /|   |
                                |
                                |
                        ________|
                        """,
        """
                            +---+
                            |   |
                            O   |
                            |   |
                                |
                                |
                        ________|
                        """,
        """
                            +---+
                            |   |
                            O   |
                                |
                                |
                                |
                        ________|
                        """,
        """
                            +---+
                            |   |
                                |
                                |
                                |
                                |
                        ________|
                        """
                        
    };

    public static char[] getChars(String word) {
        char[] chars = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            chars[i] = word.charAt(i);
        }
        return chars;
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void DrawGallows(int steps, char[] word, char[] guess) {
        draw(hangmanPictures[steps], steps, word, guess);
    }

    public static void draw(String hangmanPicture, int step, char[] word, char[] guess) {
        System.out.println(hangmanPicture);
        System.out.println("Попыток осталось: " + step);
        System.out.println(word);
        System.out.println(guess);
    }
}
