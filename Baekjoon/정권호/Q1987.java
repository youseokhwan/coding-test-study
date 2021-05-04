import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = -1;
    static int R;
    static int C;

    static char[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int y, int x, int cnt) {
        max = Math.max(max, cnt);

        int index = map[y][x] - 65;
        if (visited[index]) {
            return;
        }

        visited[index] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                continue;
            }
            dfs(ny, nx, cnt + 1);
        }

        visited[index] = false;
    }
}
