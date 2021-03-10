import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        int N = Integer.parseInt(reader.readLine()); // 배열의 크기
        Integer[] arr = new Integer[N]; // 정렬할 배열
        for (int i = 0; i < N; i++) { // 배열 원소 입력
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr); // 정렬
        for (int i = 0; i < N; i++) { // 출력
            System.out.println(arr[i]);
        }
    }
}
