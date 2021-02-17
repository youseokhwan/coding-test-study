import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(reader.readLine());
        int result = 0;

        result += money / 500;
        money %= 500;

        result += money / 100;
        money %= 100;

        result += money / 50;
        money %= 50;

        result += money / 10;
        money %= 10;

        result += money / 5;
        money %= 5;

        result += money;

        System.out.println(result);
    }
}