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

        for (int i = 0; i < num; i++) {
            files.add(reader.readLine());
        }
        char[] result = new char[files.get(0).length()];

        for (int i = 0; i < num -1; i++) {
            for (int j = 0; j < files.get(0).length(); j++) {
                char cmp1 = files.get(i).charAt(j);
                char cmp2 = files.get(i + 1).charAt(j);
                if (cmp1 == cmp2) {
                    result[j] = cmp1;
                } else {
                    result[j] = '?';
                }
            }
            files.set(i + 1, String.valueOf(result));
        }
        System.out.println(files.get(files.size()-1));
    }
}
