import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7576 {
    public static int row;
    public static int col;
    public static int count = 0;
    public static int ripeCount = 0;
    public static int maxDay = -1;

    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dy = {-1, 1, 0, 0};
    public static int[] dx = {0, 0, -1, 1};
    public static Queue<Integer[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        row = Integer.parseInt(tokenizer.nextToken());
        col = Integer.parseInt(tokenizer.nextToken());
        map = new int[col][row];
        visited = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 0) { // 안 익은 토마토 수 세기
                    count++;
                }

                if (map[i][j] == 1) { // 익은 토마토 방문할 큐에 추가, 익은 토마토 주변은 다 익기 때문에 한번에 진행
                    queue.add(new Integer[]{i, j, 0}); // y, x, 날짜
                    visited[i][j] = true;
                }
            }
        }

        if (count == 0) {
            System.out.println(0);
            return;
        }

        bfs();
        System.out.println(maxDay);
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Integer[] now = queue.poll();
            maxDay = now[2];

            for (int i = 0; i < dy.length; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];

                if (y < 0 || y >= col || x < 0 || x >= row) {
                    continue;
                }

                if (map[y][x] != 0 || visited[y][x]) {
                    continue;
                }

                ripeCount++; // 익은 토마토 개수 추가
                visited[y][x] = true;
                queue.add(new Integer[]{y, x, now[2] + 1}); // y, x, 현재 일 + 1
            }
        }

        if (ripeCount != count) { // 다 익지 않았으면
            maxDay = -1;
        }
    }
}
