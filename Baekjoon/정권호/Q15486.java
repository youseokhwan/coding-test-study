import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] jobs = new int[n][2];
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            jobs[i][0] = Integer.parseInt(tokenizer.nextToken());
            jobs[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            if (i + jobs[i][0] <= n) { // 일을 해도 날짜를 안넘길 때
                dp[i + jobs[i][0]] = Math.max(dp[i + jobs[i][0]], dp[i] + jobs[i][1]); // 일을 한 경우와 안한 경우 비교
            }
        }

        System.out.println(dp[n]);
    }

}
