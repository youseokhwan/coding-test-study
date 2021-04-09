import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[N];
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            Integer x = Integer.valueOf(tokenizer.nextToken());
            arr[i] = x;
            list[i] = x;
        }

        Arrays.sort(arr);
        int count = 0;
        int before = arr[0] - 1;

        for (int i = 0; i < N; i++) {
            if (before != arr[i]) {
                map.put(arr[i], count++);
                before = arr[i];
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            builder.append(map.get(list[i])).append(" ");
        }

        System.out.println(builder);
    }
}
