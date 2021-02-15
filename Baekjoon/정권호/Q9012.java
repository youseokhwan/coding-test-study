
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        char[] ps;
        StringBuilder sb = new StringBuilder();
        String result;
        int count = 0;

        for (int i = 0; i < num; i++) {
            ps = reader.readLine().toCharArray();
            count = 0;
            result = "YES";
            if (ps.length % 2 == 1) {
                result = "NO";
            }
            for (int j = 0; j < ps.length; j++) {
                if (ps[j] == '(') {
                    count++;
                } else {
                    count--;
                    if (count < 0) {
                        result = "NO";
                        break;
                    }
                }
            }
            if (count != 0) {
                result = "NO";
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
