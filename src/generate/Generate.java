package generate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

public class Generate {
    public static String GenerateWord() throws IOException {
        
        FileReader fileReader = new FileReader("russian-mnemonic-words.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int lim = 33740;
        Random random = new Random();
        int rand = random.nextInt(lim);
        int current = 1;

        String line = bufferedReader.readLine();
        while(current < rand) {
            line = bufferedReader.readLine();
            current++;
        }
        
        bufferedReader.close();
        return line;
    }
}