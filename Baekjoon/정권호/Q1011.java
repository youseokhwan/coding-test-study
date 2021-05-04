import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int distance = end - start;

            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                builder.append(max * 2 - 1).append("\n");
                continue;
            }
            if (distance <= max * max + max) {
                builder.append(max * 2).append("\n");
                continue;
            }

            builder.append(max * 2 + 1).append("\n");

        }

        System.out.println(builder);
    }
}
