import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int num = Integer.parseInt(tokenizer.nextToken());
        int money = Integer.parseInt(tokenizer.nextToken());

        int[] coin = new int[num];
        for (int i = 0; i < num; i++) {
            coin[i] = Integer.parseInt(reader.readLine());
        }

        int result = 0;

        for (int i = num - 1; i >= 0; i--) {
            result += money / coin[i];
            money %= coin[i];
        }

        System.out.println(result);
    }
}
