import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int a = Integer.parseInt(bufferedReader.readLine());

        for (int i = 1; i <= 9; i++) {
            stringBuilder.append(a).append(" * ").append(i).append(" = ").append(a*i).append("\n");
        }

        System.out.print(stringBuilder);
    }
}