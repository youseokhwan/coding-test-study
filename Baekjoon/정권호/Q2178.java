import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static char[][] map; // 미로 맵
    static int N; // 맵의 세로
    static int M; // 맵의 가로
    private static int[] dx = {-1, 1, 0, 0}; // 좌우 체크
    private static int[] dy = {0, 0, -1, 1}; // 상하 체크
    private static List<Integer> answer = new ArrayList<>(); // 정답 모음
    private static int[][] min; // 각 경로의 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        boolean[][] visited = new boolean[N][M]; // 방문을 체크하는 배열
        map = new char[N][M];
        min = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = reader.readLine().toCharArray(); // 한줄을 char 배열로 바꿔서 입력
        }

//        dfs(0, 0, 0, visited);
//        Collections.sort(answer);
        bfs(0, 0);
        System.out.println(answer.get(0));
    }


    public static void bfs(int y, int x) {
        Queue<Integer[]> queue = new LinkedList<>(); // 이동가능 경로를 담아줄 큐
        queue.add(new Integer[]{y, x}); // 시작점을 넣고 출발

        while (!queue.isEmpty()) { // 이동 가능한 경로가 없을때 까지
            Integer[] poll = queue.poll(); // 이동 가능한 좌표
            char now = map[poll[0]][poll[1]]; // 이동가능한 경로의 최단 거리
            for (int i = 0; i < 4; i++) { // 상하좌우 체크
                int cy = poll[0] + dy[i];
                int cx = poll[1] + dx[i];

                // map 의 범위안에 있고 아직 방문하지 않으면(0, 0 을 제외하고 나머지 는 방문을 하면 값이 무조건 1보다 커짐 그래서 1이 이미 방문을 했거나 아예 갈 수 없는 경로)
                if (cx >= 0 && cx < M && cy >= 0 && cy < N && map[cy][cx] == 1 && !(cx == 0 && cy == 0)) {
                    map[cy][cx] = (char) (now + '1'); // 이동 가능경로면 현재 경로에서 1 증가
                    queue.add(new Integer[]{cy, cx}); // 이동 가능한 경로에 추가
                }
            }
        }
        answer.add(map[N - 1][M - 1] - '0'); // 정답 출력
    }

    public static void dfs(int y, int x, int count, boolean[][] visited) {
        count++; // 방문했으므로 증가
        // map 의 범위안에 있고, 방문 가능한 경로이고, 아직 방문하지 않았으며 각 현재 경로의 최소값이 현재 경로의 값보다 크면(현재 경로의 최소값은 0으로 초기화 되어있어서 0이면 갱신을 해줘야함 )
        if (x >= 0 && x < map[0].length && y >= 0 && y < map.length && map[y][x] == '1' && !visited[y][x] && (min[y][x] > count || min[y][x] == 0)) {
            min[y][x] = count; // 현재 경로 최소값을 현재 경로값으로 갱신
            if (x == map[0].length - 1 && y == map.length - 1) { // 현재 위치가 도착지면 현재위치의 경로값 정답 리스트에 추가 하고 끝
                answer.add(count);
                return;
            }
            for (int i = 0; i < 4; i++) { // 상하좌우 체크
                visited[y][x] = true; // 현재위치 방문했다고 갱신
                int ny = y + dy[i];
                int nx = x + dx[i];
                dfs(ny, nx, count, visited);
                visited[y][x] = false; // 재귀의 특성을 이용해서 해당 방문을 다했을 때 새로운 경로를 찾기위해 방문 안했다고 갱신
            }
        }
    }


}
