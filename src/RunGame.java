import java.io.IOException;
import generate.Generate;
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
