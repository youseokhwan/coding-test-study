import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] nums = new int[N];
        int max = -1;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(reader.readLine());
            nums[i] = num;
            max = Math.max(max, num);
        }

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;

        for (int i = 7; i <= max; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[nums[i]]);
        }

    }
}
