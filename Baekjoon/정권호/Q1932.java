import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int max = Math.max(triangle[i][j], triangle[i][j+1]);
                triangle[i - 1][j] += max;
            }
        }

        System.out.println(triangle[0][0]);
    }
}
