import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기
        int N = Integer.parseInt(reader.readLine());
        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int red = Integer.parseInt(tokenizer.nextToken());
            int blue = Integer.parseInt(tokenizer.nextToken());
            int green = Integer.parseInt(tokenizer.nextToken());

            rgb[i][0] = red;
            rgb[i][1] = green;
            rgb[i][2] = blue;
        }

        dp[0][0] = rgb[0][0]; // rgb 각각의 시작값  0: red, 1: green, 2:blue
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for (int i = 1; i < N; i++) { // 직전의 색깔과만 같지만 않으면 됨
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + rgb[i][2];
        }

        int min = Math.min(dp[N - 1][0], dp[N - 1][1]);
        min = Math.min(min, dp[N-1][2]);

        System.out.println(min);
    }
}
