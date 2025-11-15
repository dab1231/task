import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import Game.Game;
public class RunGame {
    public static void main(String[] args) throws IOException{
        Game game = new Game();
        boolean win = false;
        while(!win){
            game.Step();
        }
    }
}
