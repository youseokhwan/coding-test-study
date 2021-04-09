import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());
        int end = Integer.parseInt(tokenizer.nextToken());
        StringBuilder builder = new StringBuilder();

        if (end < 4) {
            for (int i = start; i <= end; i++) {
                if (i == 1) {
                    continue;
                }
                builder.append(i).append("\n");
            }
            System.out.println(builder);
            return;
        }

        // 에라토스테네스의 체
        List<Integer> primes = new ArrayList<>();
        int sqrt = (int) Math.sqrt(end);

        if (Math.sqrt(end) > sqrt) {
            sqrt++;
        }

        primes.add(2);

        for (int i = 3; i <= sqrt; i += 2) {
            boolean isPrime = false;
            for (int j = 0; j < primes.size(); j++) {
                if (i % primes.get(j) == 0) {
                    isPrime = true;
                    break;
                }
            }
            if (isPrime) {
                continue;
            }
            primes.add(i);
        }

        if (start % 2 == 0 || start < 2) {
            if (start <= 2) {
                builder.append("2").append("\n");
                start = 2;
            }
            start++;
        }

        for (int i = start; i <= end; i += 2) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                if (i != primes.get(j) && i % primes.get(j) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (!isPrime) {
                continue;
            }
            builder.append(i).append("\n");
        }

        System.out.println(builder);
    }
}
