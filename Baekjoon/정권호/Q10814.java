import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 객체
        int N = Integer.parseInt(reader.readLine()); // 회원의 수 N
        Object[][] arr = new Object[N][2]; // 회원 이름과 나이를 담을 배열
        int maxAge = 0; // 카운팅 배열을 위한 최대값

        for (int i = 0; i < N; i++) { // 입력받기
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int age = Integer.parseInt(tokenizer.nextToken()); // 나이
            arr[i][0] = age;

            if (age > maxAge) { // 최대 나이 찾기
                maxAge = age;
            }

            arr[i][1] = tokenizer.nextToken(); // 이름
        }

        Object[][] sorted = sort(arr, maxAge); // 정렬
        StringBuilder builder = new StringBuilder(); // 출력시간을 줄여줄 객체

        for (int i = 0; i < N; i++) { // 출력값 문자열로 이어 붙이기
            builder.append(sorted[i][0] + " " + sorted[i][1] + "\n");
        }

        System.out.println(builder); // 정답 출력

    }

    public static Object[][] sort(Object[][] input, int max) {
        int[] counting = new int[max + 1]; // 각 회원의 나이의 개수를 세줄 배열

        for (int i = 0; i < input.length; i++) { // 각 회원의 나이의 개수를 세줌
            counting[(int) input[i][0]]++;
        }

        for (int i = 1; i < max + 1; i++) { // 비어있는 수를 건너뛰기 위한 과정
            counting[i] += counting[i - 1];
        }

        Object[][] sorted = new Object[input.length][2]; // 정렬된 배열

        for (int i = input.length - 1; i >= 0.; i--) { // 뒤에서 부터 넣어주면 먼저 가입한 순서로 들어감
            sorted[--counting[(int) input[i][0]]] = input[i];
        }
        
        return sorted;
    }
}
