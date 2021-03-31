import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받기
        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[(int) Math.pow(10, 6) + 1];
        // 2, 3 일땐 1번
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= N; i++) {
            if (i % 3 == 0) { // 3의 배수일 때
                arr[i] = Math.min(arr[i / 3], arr[i - 1]) + 1; // 3으로 나눌 때와 1을 뺄 때 값 비교
                if (i % 2 == 0) { // 2의 배수이기도 하면 위에서 비교한 값과 2로 나눌 때 값 비교
                    arr[i] = Math.min(arr[i / 2] + 1, arr[i]);
                }
                continue;
            }

            if (i % 2 == 0) { // 2의 배수일 때
                arr[i] = Math.min(arr[i / 2], arr[i - 1]) + 1; // 2로 나눌 때와 1을 뺄 때 값 비교
                continue;
            }

            arr[i] = arr[i - 1] + 1; // 1 빼기
        }

        System.out.println(arr[N]);
    }
}
