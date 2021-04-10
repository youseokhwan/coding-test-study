import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int max = -1;
    public static int N;
    public static int M;
    public static int count = 0;
    public static int infectionCount = 0;

    public static int[][] map;
    public static boolean[][] visited;
    public static List<Integer[]> viruses = new ArrayList<>();
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        // 1억번 -> 1초

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 2) { // 바이러스 위치 추가
                    viruses.add(new Integer[]{i, j});
                }

                if (map[i][j] == 0) { // 연구실
                    count++;
                }
            }
        }

        count -= 3; // 벽을 3개 치고 시작

        // 0 -> 0, 0    1 -> 0, 1   2 -> 0, 2 ... N * M - 1 -> N - 1, M - 1
        for (int i = 0; i < N * M; i++) { // 벽을 칠 수 있는 모든 경우의 수
            int y1 = i / M;
            int x1 = i % M;

            if (map[y1][x1] != 0) {
                continue;
            }

            map[y1][x1] = 1; // 벽 치기

            for (int j = i + 1; j < N * M; j++) {
                int y2 = j / M;
                int x2 = j % M;

                if (map[y2][x2] != 0) {
                    continue;
                }

                map[y2][x2] = 1;

                for (int k = j + 1; k < N * M; k++) {
                    int y3 = k / M;
                    int x3 = k % M;
                    if (map[y3][x3] != 0) {
                        continue;
                    }

                    map[y3][x3] = 1;

                    viruses.forEach(virus -> { // 각 바이러스 별로 감염
                        bfs(virus);
                    });

                    max = Math.max(max, count - infectionCount); // 연구실 수 - 감연된 수에서 최대값 찾기
                    infectionCount = 0;
                    visited = new boolean[N][M];

                    map[y3][x3] = 0; // 벽 거두기
                }
                map[y2][x2] = 0;
            }
            map[y1][x1] = 0;
        }

        System.out.println(max);
    }

    public static void bfs(Integer[] virus) {
        if (virus[0] < 0 || virus[0] >= N || virus[1] < 0 || virus[1] >= M) {
            return;
        }

        if (map[virus[0]][virus[1]] == 1 || visited[virus[0]][virus[1]]) {
            return;
        }

        visited[virus[0]][virus[1]] = true;

        if (map[virus[0]][virus[1]] == 0) {
            infectionCount++;
        }

        for (int i = 0; i < dy.length; i++) {
            int y = virus[0] + dy[i];
            int x = virus[1] + dx[i];
            bfs(new Integer[]{y, x});
        }
    }
}
