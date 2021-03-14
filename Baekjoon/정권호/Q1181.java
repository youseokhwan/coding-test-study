import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 객체
        int N = Integer.parseInt(reader.readLine()); // 단어의 개수 N
        Object[][] arr = new Object[N][2]; // 단어와 스펠링 수를 담을 배열

        for (int i = 0; i < N; i++) { // 입력받기
            String word = reader.readLine();
            arr[i][0] = word; // 단어
            arr[i][1] = word.length(); // 스펠링 수
        }

        Arrays.sort(arr, new Comparator<Object[]>() { // 정렬
            @Override
            public int compare(Object[] o1, Object[] o2) {
                if (o1[1] == o2[1]) { // 스펠링 수가 같으면
                    return o1[0].toString().compareTo(String.valueOf(o2[0])); // 사전순으로 정렬
                }
                return (int) o1[1] - (int) o2[1]; // 스펠링 수 기준으로
            }
        });

        StringBuilder builder = new StringBuilder(); // 출력시간을 줄여줄 객체
        for (int i = 0; i < N; i++) { // 출력할 값 이어붙이기
            if (i > 0 && arr[i - 1][0].equals(arr[i][0])) { // 중복 값이면 거르기
                continue;
            }
            builder.append(arr[i][0]).append("\n");
        }

        System.out.println(builder); // 정답 출력
    }
}
