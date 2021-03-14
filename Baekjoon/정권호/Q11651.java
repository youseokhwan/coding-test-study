import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 객체
        int N = Integer.parseInt(reader.readLine()); // 점의 수 N
        int[][] xy = new int[N][2]; // 좌표 배열

        for (int i = 0; i < N; i++) { // 좌표 입력 받기
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            xy[i][0] = Integer.parseInt(tokenizer.nextToken());
            xy[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(xy, new Comparator<int[]>() { // 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // y 좌표가 같으면
                    return o1[0] - o2[0]; // x 좌표로 정렬
                }
                return o1[1] - o2[1]; // y 좌표로 정렬
            }
        });

        StringBuilder builder = new StringBuilder(); // 출력시간을 줄여줄 객체

        for (int i = 0; i < N; i++) {
            builder.append(xy[i][0]).append(" ").append(xy[i][1]).append("\n"); // 출력할 값 이어 붙이기
        }
        System.out.println(builder); // 정답 출력
    }
}
