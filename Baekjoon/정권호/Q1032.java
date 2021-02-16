import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        List<String> files = new ArrayList<>();

        for (int i =0; i < num; i++) {
            files.add(reader.readLine());
        }

        char[] result = files.get(0).toCharArray();

        for (int i = 0; i < files.get(0).length(); i++) {
            for (int j = 0; j < num - 1; j++) {
                char cmp1 = files.get(j).charAt(i);
                char cmp2 = files.get(j + 1).charAt(i);
                if (cmp1 != cmp2) {
                    result[i] = '?';
                    continue;
                }

            }
        }
        System.out.println(result);
    }
}
