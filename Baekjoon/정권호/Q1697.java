import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] dp = new int[K + 2];

        if (N >= K) { // 시작점이 도착점보다 뒤에 있거나 같을 때
            System.out.println(N - K);
            return;
        }

        for (int i = 1; i <= N; i++) { // 시작점 뒤로 1칸씩 이동
            dp[N - i] = i;
        }

        for (int i = N + 1; i <= K; i++) {
            if (i % 2 == 0) { // 짝수면
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1; // 앞 뒤로 비교
                continue;
            }
            dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2); // 앞과 반값과 비교
        }

        System.out.println(dp[K]);
    }
}

