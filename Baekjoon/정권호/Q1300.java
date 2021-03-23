import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int K = Integer.parseInt(reader.readLine());

        int max = K; // 배열의 구조상 k번 째수는 k보다 클 수 없음
        int min = 1;
        int mid = 0;
        int answer = 0;

        while (min <= max) {
            int count = 0;
            mid = (min + max) / 2;

            for (int i = 1; i <= N; i++) {
                // 각 행은 i의 배수 임으로 mid 를 i로 나눈 몫의 수와 i 보다 작은 수가 같음, 근데 또 N개를 넘기는 경우가 있으니 최대값은 N으로 조절
                count += Math.min(mid / i, N);
            }

            if (count < K) { // 개수가 딸리면 mid 값을 크게
                min = mid + 1;
                continue;
            }

            max = mid - 1; // 개수가 넘치면 mid 값을 작게
            answer = mid; // mid 가 k 번째 수보다 크니까 갱신, 점점 줄여나감
        }

        System.out.println(answer);
    }
}
