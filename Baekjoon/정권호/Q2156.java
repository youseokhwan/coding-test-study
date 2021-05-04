import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) { // 입력 받기
            arr[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = arr[0];

        if (N > 1) { // overflow 방지
            dp[1] = arr[0] + arr[1];
        }

        if (N > 2) { // overflow 방지
            dp[2] = arr[2] + Math.max(arr[0], arr[1]);
            dp[2] = Math.max(dp[2], dp[1]);
        }

        for (int i = 3; i < N; i++) {
            dp[i] = arr[i] + Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]); // 두 칸 전은 이번 칸에 마실 수 있지만, 한 칸 전에 마시려면 두 칸 전건 마실 수 없으므로 세 칸 전에 마심
            dp[i] = Math.max(dp[i], dp[i - 1]); // 현재 칸에서 안마시는 경우
        }

        System.out.println(dp[N - 1]);
    }
}
