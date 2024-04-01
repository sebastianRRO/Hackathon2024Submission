import java.util.Random;

public class WordGenerator {
    private String[] words;
    private Random random;

    public WordGenerator(String[] words) {
        this.words = words;
        random = new Random();
    }

    public String generateWord() {
        int index = random.nextInt(words.length);
        return words[index];
    }
}

