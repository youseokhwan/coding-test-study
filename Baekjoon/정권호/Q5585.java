import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받을 BufferedReader 객체 생성
        int money = 1000 - Integer.parseInt(reader.readLine()); // 입력 받은 값에서 1000원에 대한 거스름돈
        int result = 0; // 필요한 동전의 갯수

        result += money / 500; // 거스름돈을 500원 으로 나눈 몫을 result에 더함
        money %= 500; // 거스름돈을 500원으로 나눈 나머지로 대입

        result += money / 100; // 거스름돈을 100원 으로 나눈 몫을 result에 더함
        money %= 100; // 거스름돈을 100원으로 나눈 나머지로 대입

        result += money / 50; // 거스름돈을 50원 으로 나눈 몫을 result에 더함
        money %= 50; // 거스름돈을 50원으로 나눈 나머지로 대입

        result += money / 10; // 거스름돈을 10원 으로 나눈 몫을 result에 더함
        money %= 10; // 거스름돈을 10원으로 나눈 나머지로 대입

        result += money / 5; // 거스름돈을 5원 으로 나눈 몫을 result함에 더함
        money %= 5; // 거스름돈을 5원으로 나눈 나머지로 대입

        result += money; // 마지막으로 남은 나머지 값을 result에 더

        System.out.println(result); // 필요한 동전의 갯수 출력
    }
}

