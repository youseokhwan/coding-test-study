import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] cmp1 = reader.readLine().toCharArray();
        char[] cmp2 = reader.readLine().toCharArray();
        List<Character> result = new ArrayList<>();

        for (int i = 0; i < cmp1.length; i++) {
            result.add(cmp1[i]);
        }

        int count = 0;

        for (int i = 0; i < cmp2.length; i++) {
            boolean isContain = result.contains(cmp2[i]);
            if (isContain) {
                result.remove((Character) cmp2[i]);
                continue;
            }
            count++;
        }

        System.out.println(count + result.size());
    }
}
