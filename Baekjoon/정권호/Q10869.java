import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(a + b).append("\n");
        stringBuilder.append(a - b).append("\n");
        stringBuilder.append(a * b).append("\n");
        stringBuilder.append(a / b).append("\n");
        stringBuilder.append(a % b);
        System.out.print(stringBuilder);
    }
}