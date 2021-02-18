import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받을 BufferedReader 객체 생성
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 첫줄에서 입력받은 문자열을 " " 으로 split

        int num = Integer.parseInt(tokenizer.nextToken());  // 위에서 split 한 문자열에서 첫번째 원소 동전의 종류 수(N) -> num
        int money = Integer.parseInt(tokenizer.nextToken()); // 위에서 split 한 문자열에서 두번째 원소 가치의 합(K) -> money
        int[] coin = new int[num]; // 동전의 종류 수(N) 만큼 배열 선언

        for (int i = 0; i < num; i++) { // coin 배열에 동전의 종류 입력
            coin[i] = Integer.parseInt(reader.readLine());
        }

        int result = 0; // 필요한 동전의 갯수

        for (int i = num - 1; i >= 0; i--) { // 동전의 종류를 오름차순으로 입력받아 역순으로 순회
            result += money / coin[i]; // K 를 coin 으로 나눈 몫을 result 더함
            money %= coin[i]; // K 를 coin 으로 나눈 나머지로 대입

            if (money == 0) { // 더이상 coin 으로 나누어지지 않으면 stop
                break;
            }
        }

        System.out.println(result); // 필요한 동전의 갯수 출
    }
}


