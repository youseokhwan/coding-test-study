import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= a; i++) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}