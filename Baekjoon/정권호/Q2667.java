import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 객체
        int N = Integer.parseInt(reader.readLine()); // N 입력
        char[][] map = new char[N][N]; // 집 배열
        int home = 0; // 집의 수

        for (int i = 0; i < N; i++) { // 집 유무 입력
            char[] line = reader.readLine().toCharArray(); // 입력받은 값을 char 배열로
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j]; // i는 y 좌표, j는 x 좌표
                if (line[j] == '1') { // 집이 있으면 집의 수 증가
                    home++;
                }
            }
        }

        Queue<Integer[]> near = new LinkedList<>(); // 연결되어 있는 집을 담을 객체
        List<Integer> homeNum = new ArrayList<>(); // 연결되어 있는 집의 수 리스트

        while (home > 0) { // 집이 존재하지 않을 때 까지
            search:
            // 집을 탐색하는 배열
            {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == '1') { // 집을 찾으면
                            map[i][j] = '0'; // 해당 집을 비운다
                            near.add(new Integer[]{i, j}); // 연결되어 있는 집 리스트에 담아준다.
                            break search; // 집을 찾았으니 집 탐색배열 중지
                        }
                    }
                }
            }
            int count = 0; // 연결되어 있는 집의 수
            while (!near.isEmpty()) { // 연결되어 있는 집들이 없을 때 까지
                count++; // 연결된 집이 있어야 반복하니 연결되어 있는 집 수 증가
                home--; // 집을 비웠으니 전체 집의 수 감소
                Integer[] poll = near.poll(); // 연결되어 있는집에서 집 하나 빼기

                int y = poll[0]; // 뽑은 집의 y 좌표
                int x = poll[1]; // 뽑은 집의 x 좌표
                int left = x - 1; // 뽑은 집의 왼쪽집 x 좌표
                int right = x + 1; // 뽑은 집의 오른쪽집 x 좌표
                int up = y - 1; // 뽑은 집의 위쪽집 x 좌표
                int down = y + 1; // 뽑은 집의 아래쪽집 x 좌표

                // 각각의 상하좌우의 집이 있는지 확인하는 조건문
                if (left > -1 && map[y][left] == '1') {
                    map[y][left] = '0'; // 집이 있으면 비우고
                    near.add(new Integer[]{y, left}); // 연결되어 있는집에 추가
                }

                if (right < N && map[y][right] == '1') {
                    map[y][right] = '0';
                    near.add(new Integer[]{y, right});
                }

                if (up > -1 && map[up][x] == '1') {
                    map[up][x] = '0';
                    near.add(new Integer[]{up, x});
                }

                if (down < N && map[down][x] == '1') {
                    map[down][x] = '0';
                    near.add(new Integer[]{down, x});
                }
            }
            homeNum.add(count); // 한 단지의 집 수를 연결되어 있는 집의 수 리스트에 추가
        }

        System.out.println(homeNum.size()); // 단지의 수 출력
        Collections.sort(homeNum); // 단지 수 오름차순 정렬
        homeNum.forEach(h -> { // 각 단지의 수 출력
            System.out.println(h);
        });
    }
}

