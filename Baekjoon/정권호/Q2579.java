import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
        int N = Integer.parseInt(reader.readLine());
        int[] stair = new int[N + 1];
        int[] dp = new int[N + 1];

        if (N == 1) { // 계단 1개일때
            System.out.println(Integer.parseInt(reader.readLine()));
            return;
        }

        for (int i = 1; i <= N; i++) { // 계단 입력받기
            stair[i] = Integer.parseInt(reader.readLine());
        }

        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= N; i++) {
            // 2칸 오를 때와 1칸 오를 때 비교
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + stair[i - 1]) + stair[i]; // 2칸 오를 때는 전에 1칸 오르든 2칸 오르든 상관없지만, 1칸은 전에 오를 때 무조권 2칸 올라야 함으로
        }

        System.out.println(dp[N]);
    }
}
