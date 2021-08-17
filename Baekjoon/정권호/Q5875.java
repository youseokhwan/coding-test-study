import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = reader.readLine();
        char[] answerChar = answer.toCharArray();
        int cnt = 0;

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == '(') {
                cnt++;
            }
        }

        if (cnt == answer.length() / 2) {
            System.out.println(0);
            return;
        }

        if (answerChar[0] == ')' || answerChar[answerChar.length - 1] == '(') {
            System.out.println(1);
            return;
        }

        char find = '(';
        if (cnt < answer.length() / 2) {
            System.out.println(answer.length() / 2);
            return;
        }

        int sum = 1;
        cnt = 0;

        for (int i = 1; i < answerChar.length - 1; i++) {
            if (answerChar[i] == find) {
                if (sum >= 1) {
                    cnt++;
                }
            }
            if (answerChar[i] == '(') {
                sum++;
            } else {
                sum--;
            }
        }
        System.out.println(cnt);
    }

}