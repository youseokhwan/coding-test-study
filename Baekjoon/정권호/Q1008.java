import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        double a = Double.parseDouble(tokenizer.nextToken());
        double b = Double.parseDouble(tokenizer.nextToken());

        System.out.println(a / b);
    }
}