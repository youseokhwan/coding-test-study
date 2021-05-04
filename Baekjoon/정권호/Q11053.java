import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        int size = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] arr = new int[size];
        int[] dp = new int[size];

        for (int i = 0; i < size; i++) { // 입력 받기
            int num = Integer.parseInt(tokenizer.nextToken());
            arr[i] = num;
        }

        int max = 1;
        dp[0] = 1;

        for (int i = 1; i < size; i++) {
            for (int j = i - 1; j >= 0; j--) { // 뒤로 돌면서
                if (arr[j] < arr[i]) { // 현재 자신 값보다 작으면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 그중에 최대값 찾기
                }
            }

            if (dp[i] == 0 ) { // 만약 자신보다 작은 값이 없으면 1
                dp[i]++;
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
