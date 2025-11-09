package generate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Generate {
    public static String GenerateWord() throws IOException {
        
        // Загружаем файл как ресурс из того же пакета
        InputStream inputStream = Generate.class.getResourceAsStream("russian-mnemonic-words.txt");
        
        if (inputStream == null) {
            throw new IOException("Файл russian-mnemonic-words.txt не найден в пакете generate!");
        }
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

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