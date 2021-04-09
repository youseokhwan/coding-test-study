import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[][] arr = new int[N][2];
        int[][] dp = new int[N + 1][K + 1];
        int max = -1;

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            arr[i][0] = Integer.parseInt(tokenizer.nextToken());
            arr[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int value = arr[i - 1][0];
                int weight = arr[i - 1][1];

                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
            }
        }

        System.out.println(dp[N][K]);
    }
}
