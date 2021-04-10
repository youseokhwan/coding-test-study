import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int M;
    public static int min = 987654321;

    public static char[][] map;
    public static boolean[][][] visited;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2]; // 벽을 깨고 방문 + 벽을 안깨고 방문

        for (int i = 0; i < N; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        bfs();

        if (min == 987654321) {
            min = -1;
        }

        System.out.println(min);
    }

    public static void bfs() {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{0, 0, 1, 0}); // y, x, 이동 횟수, 벽 부순 횟수
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                min = Math.min(min, now[2]);
            }

            for (int i = 0; i < dy.length; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                if (y < 0 || y >= N || x < 0 || x >= M) {
                    continue;
                }

                if (now[3] == 0) { // 아직 벽을 안 부셨을 때
                    if (visited[y][x][0]) {
                        continue;
                    }

                    int breakWall = 0;
                    if (map[y][x] == '1') { // 벽있으면 부시기
                        breakWall = 1;
                    }

                    visited[y][x][0] = true;
                    queue.add(new Integer[]{y, x, now[2] + 1, breakWall});
                }

                if (now[3] == 1) { // 벽을 부셨을 때
                    if (visited[y][x][1] || map[y][x] == '1') {
                        continue;
                    }

                    visited[y][x][1] = true;
                    queue.add(new Integer[]{y, x, now[2] + 1, now[3]});
                }
            }
        }
    }
}
