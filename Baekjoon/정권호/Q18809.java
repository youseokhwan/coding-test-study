import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][][] map;
    static int N;
    static int M;
    static int Red;
    static int Green;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int cnt = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        Green = Integer.parseInt(tokenizer.nextToken());
        Red = Integer.parseInt(tokenizer.nextToken());

        // map 에서 green: 3, red: 4
        map = new int[N][M][2];
        List<Integer[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j][0] = Integer.parseInt(tokenizer.nextToken());
                if (map[i][j][0] == 2) {
                    list.add(new Integer[]{i, j});
                }
            }
        }
        combination(list, 0, Green, Red, new ArrayList<>(), new ArrayList<>());
        System.out.println(max);
    }

    public static void combination(List<Integer[]> list, int idx, int green, int red, List<Integer[]> greenList, List<Integer[]> redList) {
        if (idx == list.size()) {
            int[][][] clone = new int[N][M][2];
            for (int i = 0; i < clone.length; i++) {
                for (int i1 = 0; i1 < clone[i].length; i1++) {
                    clone[i][i1][0] = map[i][i1][0];
                    clone[i][i1][1] = map[i][i1][1];
                }
            }
            bfs(clone, greenList, redList);
            max = Math.max(max, cnt);
            cnt = 0;
            return;
        }

        Integer[] integers = list.get(idx);
        int leave = list.size() - idx;
        if (leave > red + green) { // 배양지를 넘기는 경우
            combination(list, idx + 1, green, red, greenList, redList);
        }

        if (green > 0) { // 배양지에 초록색 주입
            greenList.add(integers);
            combination(list, idx + 1, green - 1, red, greenList, redList);
            greenList.remove(integers);
        }

        if (red > 0) { // 배양지에 빨강 주입
            redList.add(integers);
            combination(list, idx + 1, green, red - 1, greenList, redList);
            redList.remove(integers);
        }

    }

    public static void bfs(int[][][] mapBuf, List<Integer[]> greenList, List<Integer[]> redList) {
        Queue<Integer[]> redQueue = new LinkedList<>();
        Queue<Integer[]> greenQueue = new LinkedList<>();


        int day = 0;
        // 각 색깔의 배양지를 각각의 queue 에 추가
        for (Integer[] greens : greenList) {
            greenQueue.add(new Integer[]{greens[0], greens[1], day});
        }
        for (Integer[] reds : redList) {
            redQueue.add(new Integer[]{reds[0], reds[1], day});
        }

        List<Integer[]> greenBuf = new ArrayList<>();
        List<Integer[]> redBuf = new ArrayList<>();

        while (!redQueue.isEmpty() || !greenQueue.isEmpty()) {
            greenBuf.clear();
            redBuf.clear();
            // 각 큐에 날짜가 같은 경우만 각 list 에 저장
            while (!greenQueue.isEmpty()) {
                Integer[] peek = greenQueue.peek();
                if (peek[2] != day) {
                    break;
                }
                Integer[] green = greenQueue.poll();
                greenBuf.add(green);
            }
            while (!redQueue.isEmpty()) {
                Integer[] peek = redQueue.peek();
                if (peek[2] != day) {
                    break;
                }
                Integer[] red = redQueue.poll();
                redBuf.add(red);
            }

            for (int i = 0; i < redBuf.size(); i++) {
                int ny = redBuf.get(i)[0];
                int nx = redBuf.get(i)[1];
                if (mapBuf[ny][nx][0] == 1 || mapBuf[ny][nx][0] == 2){ // 빨간 배양액이 내릴 수 있는 땅인 경우
                        mapBuf[ny][nx][0] = 4;
                        mapBuf[ny][nx][1] = day;
                        boolean pass = false;
                    for (int j = 0; j < greenBuf.size(); j++) { // 초록 배양액과 겹치는 경우
                        if (ny == greenBuf.get(j)[0] && nx == greenBuf.get(j)[1]) {
                            mapBuf[ny][nx][0] = -1;
                            mapBuf[ny][nx][1] = -1;
                            cnt++;
                            pass = true;
                            break;
                        }
                    }
                    if (pass) continue; // 배양액이 겹치면 더이상 안퍼짐
                    for (int k = 0; k < dy.length; k++) {
                        int y = ny + dy[k];
                        int x = nx + dx[k];
                        if (y >= 0 && y < N && x >= 0 && x < M) {
                            if (mapBuf[y][x][0] == 1 || mapBuf[y][x][0] == 2) {
                                redQueue.add(new Integer[]{y, x, day + 1});
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < greenBuf.size(); i++) {
                int ny = greenBuf.get(i)[0];
                int nx = greenBuf.get(i)[1];
                if (mapBuf[ny][nx][0] == 1 || mapBuf[ny][nx][0] == 2) { // 나머지 겹치지 않은 초록 배양액
                    mapBuf[ny][nx][0] = 3;
                    mapBuf[ny][nx][1] = day - 1;
                    for (int k = 0; k < dy.length; k++) {
                        int y = ny + dy[k];
                        int x = nx + dx[k];
                        if (y >= 0 && y < N && x >= 0 && x < M) {
                            if (mapBuf[y][x][0] == 1 || mapBuf[y][x][0] == 2) {
                                greenQueue.add(new Integer[]{y, x, day + 1});
                            }
                        }
                    }
                }
            }
            day++; // 다음날
        }
    }
}
