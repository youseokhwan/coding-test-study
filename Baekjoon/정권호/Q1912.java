import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int sum = 0;
        int max = -987654321;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(tokenizer.nextToken());
            max = Math.max(max, sum);
            if (sum < 0) { // 더했을 때 0보다 작아지면 초기화
                sum = 0;
            }
        }

        System.out.println(max);
    }
}
