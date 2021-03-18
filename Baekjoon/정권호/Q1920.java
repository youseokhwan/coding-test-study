import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        int N = Integer.parseInt(reader.readLine()); // N개의 자연수
        int[] arr = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 쪼개줄 객체

        for (int i = 0; i < N; i++) { // N개의 수 입력
            arr[i] = Integer.valueOf(tokenizer.nextToken());
        }

        Arrays.sort(arr); // 이분탐색을 위한 정렬
        StringBuilder builder = new StringBuilder(); // 결과물 담을 객체
        N = Integer.parseInt(reader.readLine()); // 찾아야 하는 수의 개수 N
        tokenizer = new StringTokenizer(reader.readLine()); // 쪼개줄 객체

        for (int i = 0; i < N; i++) { // 찾아야 하는 수 입력
            int num = Integer.parseInt(tokenizer.nextToken()); // 찾아야 하는 수
            int left = 0; // 왼쪽 끝
            int right = arr.length - 1; // 오른쪽 끝
            boolean isFind = false; // 찾았는지 확인할 변수

            while (left <= right) { // 좌우 끝이 같을 때 까지
                int mid = (left + right) / 2; // 중앙

                if (arr[mid] == num) { // 중앙에 위치한 값이면
                    isFind = true; // 찾고 탐색 끝
                    break;
                }

                if (arr[mid] > num) { // 중앙값보다 작으면 오른쪽 끝을 중앙 한칸 왼쪽
                    right = mid - 1;
                    continue;
                }

                if (arr[mid] < num) { // 중앙값보다 크면 왼쪽 끝을 중앙 한칸 오른쪽
                    left = mid + 1;
                    continue;
                }
            }

            if (isFind) { // 탐색 후 찾았으면 1 아니면 0
                builder.append("1").append("\n");
                continue;
            }

            builder.append("0").append("\n");

        }
        System.out.println(builder); // 결과물 출력
    }
}
