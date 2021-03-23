import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int K = Integer.parseInt(tokenizer.nextToken());
        int N = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[K];
        long max = -1;

        for (int i = 0; i < K; i++) { // 입력 받으면서 최대값 구하기
            arr[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, arr[i]);
        }

        long min = 1;
        long answer = 0;

        while (min <= max) {
            long count = 0;
            long mid = (min + max) / 2;
            for (int i = 0; i < K; i++) {
                count += arr[i] / mid;
            }

            if (count >= N) {
                if (answer < mid) {
                    answer = mid;
                }
                min = mid + 1;
                continue;
            }
            max = mid - 1;
        }

        System.out.println(answer);
    }
}
