import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1; // 초기화
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1]; // 0 은 1에서만 나옴
            dp[i][9] = dp[i-1][8]; // 9 는 8에서만 나옴

            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000; // 2 ~ 8 은 각각의 계단에서 나옴
            }
        }

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum += dp[N][i];
            sum %= 1000000000;
        }

        System.out.println(sum);
    }
}
