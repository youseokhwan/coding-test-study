import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[][] jewelries = new int[N][2];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            jewelries[i][0] = Integer.parseInt(tokenizer.nextToken());
            jewelries[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] bags = new int[K];

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(jewelries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Arrays.sort(bags);
        PriorityQueue<Integer> a = new PriorityQueue<>();

        long result = 0;
        int min = 0;

        for (int i = 0; i < K; i++) {
            for (int j = min; j < N; j++) {
                if (jewelries[j][0] > bags[i]) {
                    break;
                }
                min++;
                a.add(-jewelries[j][1]);
            }
            if (!a.isEmpty()) {
                result += Math.abs(a.poll());
            }
        }

        System.out.println(result);
    }
}
