
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int result = 0;
        char[] word;

        HashSet<Character> words = new HashSet<>();
        boolean check;

        for (int i = 0; i < num; i++) {
            check = true;
            words.clear();
            word = reader.readLine().toCharArray();
            result++;
            words.add(word[0]);
            for (int j = 0; j < word.length - 1; j++) {
                if (word[j] != word[j + 1]) {
                    check = words.add(word[j + 1]);
                    if (!check) {
                        result--;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
