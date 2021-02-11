import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j <= i; j++) {
                result.append("*");
            }
            result.append("\n");
        }
        System.out.print(result);
    }
}