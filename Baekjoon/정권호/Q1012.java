import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map; // 배추 맵
    static int[] dx = {0, 0, -1, 1}; // 좌우 체크
    static int[] dy = {-1, 1, 0, 0}; // 상하 체크
    static int M; // 맵의 가로
    static int N; // 맵의 세로


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine()); // 테스트 케이스

        for (int i = 0; i < T; i++) { // 테스트 케이스만큼 반복
            StringTokenizer mapTokenizer = new StringTokenizer(reader.readLine());
            M = Integer.parseInt(mapTokenizer.nextToken());
            N = Integer.parseInt(mapTokenizer.nextToken());
            int K = Integer.parseInt(mapTokenizer.nextToken()); // 배추 수
            map = new boolean[N][M]; // 배추 맵 현재 입력받은 크기로 초기화

            for (int j = 0; j < K; j++) { // 배추의 위치 입력
                StringTokenizer cabbageTokenizer = new StringTokenizer(reader.readLine());
                int X = Integer.parseInt(cabbageTokenizer.nextToken());
                int Y = Integer.parseInt(cabbageTokenizer.nextToken());
                map[Y][X] = true;
            }

            int count = 0; // 필요한 벌레 수

            for (int cy = 0; cy < N; cy++) { // 맵 전체 탐색
                for (int cx = 0; cx < M; cx++) {
                    if (map[cy][cx]) { // 현재 맵에 배추가 있으면
                        map[cy][cx] = false; // 더이상 방문을 안하기 위해
                        BFS(cy, cx);
                        count++; // 필요한 벌레 수 추가
                    }
                }
            }
            System.out.println(count); // 필요한 벌레 수 출력
        }
    }

    static void BFS(int y, int x) {
        Queue<Integer[]> queue = new LinkedList<>(); // 벌레가 이동할 수 있는 배추 좌표
        queue.add(new Integer[]{y, x}); // 현재 배추의 좌표 입력

        while (!queue.isEmpty()) { // 벌레가 이동할 수 있는 좌표가 존재하지 않을때까지
            Integer[] poll = queue.poll(); // 이동 가능한 배추의 좌표
            for (int j = 0; j < 4; j++) { // 상하좌우 체크
                int cy = poll[0] + dy[j];
                int cx = poll[1] + dx[j];
                if (cx >= 0 && cx < M && cy >= 0 && cy < N && map[cy][cx]) { // 맵 안에 있고, 배추가 있으면
                    queue.add(new Integer[]{cy, cx}); // 이동 가능한 좌표에 추가
                    map[cy][cx] = false; // 더이상 방문을 안하기 위해
                }
            }
        }
    }
}
