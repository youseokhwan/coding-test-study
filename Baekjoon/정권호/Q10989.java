import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        StringBuilder builder = new StringBuilder(); // 출력할 결과물을 담을 객체
        int N = Integer.parseInt(reader.readLine()); // 배열의 크기
        int[] arr = new int[N]; // 정렬할 배열
        int max = -1; // 최대값

        for (int i = 0; i < N; i++) { // 배열 원소 입력
            arr[i] = Integer.parseInt(reader.readLine());
            if (Math.abs(arr[i]) > max) { // 최대값 찾기
                max = Math.abs(arr[i]);
            }
        }

        CountingSort sort = new CountingSort(); // 카운팅 정렬 객체
        int[] answer = sort.sort(arr, max); // 카운팅 정렬

        for (int i = 0; i < N; i++) { // 출력물 생성
            builder.append(answer[i]).append("\n");
        }
        System.out.println(builder); // 결과 출력
    }

    public static class CountingSort {
        public int[] sort(int[] input, int Max) {
            int[] counting = new int[Max + 1]; // 0과 양수 카운팅 배열
            int[] nCounting = new int[Max + 1]; // 음수 카운팅 배열
            int nNum = 0; // 음수의 수

            for (int i = 0; i < input.length; i++) {
                if (input[i] < 0) { // 음수면 음수 카운팅 배열에서 해당 음수의 갯수 추가(배열의 인덱스는 음수가 안됨으로 양수로 만 바꿔서)
                    nCounting[-(input[i])]++;
                    nNum++; // 음수의 수 추가
                    continue;
                }
                counting[input[i]]++; // 아니면 0과 양수 카운팅 배열에서 해당 수의 갯수 추가
            }

            for (int i = 1; i < Max + 1; i++) { // 비어있는 수를 건너뛰기 위한 과정
                counting[i] += counting[i - 1];
                nCounting[Max - i] += nCounting[Max - i + 1];

            }

            int[] sorted = new int[input.length]; // 정렬된 배열

            for (int i = 0; i < input.length; i++) {
                if (input[i] < 0) {
                    sorted[--nCounting[Math.abs(input[i])]] = input[i];
                    continue;
                }
                sorted[--counting[input[i]] + nNum] = input[i];
            }
            return sorted;
        }
    }
}