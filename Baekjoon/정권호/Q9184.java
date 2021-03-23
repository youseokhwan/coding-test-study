import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] dynamic = new int[21][21][21];
    public static int[][] dw = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        w();

        while (true) { // 입렫받기
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == -1 && b == -1 && c == -1) { // 멈추는 조건
                break;
            }

            builder.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");

            if (a <= 0 || b <= 0 || c <= 0) {
                builder.append(1).append("\n");
                continue;
            }

            if (a > 20 || b > 20 || c > 20) {
                builder.append(dynamic[20][20][20]).append("\n");
                continue;
            }
            builder.append(dynamic[a][b][c]).append("\n");
        }

        System.out.println(builder);

    }

    public static void w() {
        for (int i = 0; i < 7; i++) { // 0 이 들어가는 원소들 1로 초기화
            dynamic[dw[i][0]][dw[i][1]][dw[i][2]] = 1;
        }

        for (int i = 1; i < 21; i++) { // 1 부터 20까지 각 원소들로 반복
            for (int j = 1; j < 21; j++) {
                for (int k = 1; k < 21; k++) {
                    if (i < j && j < k) { // i < j < k 일 떄
                        for (int q = 1; q < 4; q++) {
                            int before = dynamic[i - dw[q][0]][j - dw[q][1]][k - dw[q][2]]; // w 함수의 조건

                            if (i - dw[q][0] == 0 || j - dw[q][1] == 0 || k - dw[q][2] == 0) { // 원소중에 0이 들어가면
                                before = 1;
                            }

                            if (q == 2) { // 빼는 부분
                                dynamic[i][j][k] -= before;
                                continue;
                            }

                            dynamic[i][j][k] += before;
                        }
                        continue;
                    }

                    for (int q = 4; q < 8; q++) {
                        int before = dynamic[i - dw[q][0]][j - dw[q][1]][k - dw[q][2]];

                        if (i - dw[q][0] == 0 || j - dw[q][1] == 0 || k - dw[q][2] == 0) { // 이전 원소중에 0이 들어가면
                            before = 1;
                        }

                        if (q == 7) { // 빼는 부분
                            dynamic[i][j][k] -= before;
                            continue;
                        }

                        dynamic[i][j][k] += before;
                    }
                }
            }
        }
    }
}
