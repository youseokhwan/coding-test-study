import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        char[] num = reader.readLine().toCharArray(); // 수 입력

        Arrays.sort(num); // 정렬, 문자열도 정렬가능(사전순)

        for (int i = num.length - 1; i >= 0; i--) { // 정답 출력
            System.out.print(num[i]);
        }
    }
}
