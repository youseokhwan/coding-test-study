import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] dynamic = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        int max = -1;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) { // 최대값 찾으면서 입력받기
            int n = Integer.parseInt(reader.readLine());
            max = Math.max(n, max);
            arr[i] = n;
        }

        fibonacci(max + 1);

        for (int i = 0; i < N; i++) {
            builder.append(dynamic[arr[i]][0]).append(" ").append(dynamic[arr[i]][1]).append("\n");
        }

        System.out.println(builder);

    }

    public static void fibonacci(int n) {
        // 피보나치수가 0일 때와 1일 때의 각각 0의 갯수와 1의 갯수
        dynamic[0][0] = 1; // 0일때
        dynamic[0][1] = 0;

        dynamic[1][0] = 0; // 1일때
        dynamic[1][1] = 1;

        for (int i = 2; i < n; i++) { // 피보나치 수는 이전의 두개 수의 합
            dynamic[i][0] = dynamic[i - 1][0] + dynamic[i - 2][0];
            dynamic[i][1] = dynamic[i - 1][1] + dynamic[i - 2][1];
        }
    }
}
