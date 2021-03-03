import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 입렵받은 값을 쪼개줄 객체

        int N = Integer.parseInt(tokenizer.nextToken()); // 점의수 N
        int M = Integer.parseInt(tokenizer.nextToken()); // 간선의수 M
        int start = Integer.parseInt(tokenizer.nextToken()); // 시작점

        HashMap<Integer, List<Integer>> crossed = new HashMap<>(); // 두 접점

        for (int i = 0; i < M; i++) { // 각 점의 접점들 저장
            tokenizer = new StringTokenizer(reader.readLine());
            int point1 = Integer.parseInt(tokenizer.nextToken());
            int point2 = Integer.parseInt(tokenizer.nextToken());

            List<Integer> list1 = crossed.getOrDefault(point1, new ArrayList<>()); // 해당 점이 접점들을 가지고 있으면 그점들 반환, 아니면 빈 List 반환
            list1.add(point2);
            List<Integer> list2 = crossed.getOrDefault(point2, new ArrayList<>());
            list2.add(point1);
            crossed.put(point1, list1);
            crossed.put(point2, list2);
        }


        boolean[] visited = new boolean[N + 1]; // 점들의 방문을 확인할 배열, boolean 의 기본값은 false
        dfs(crossed, visited, start); // dfs 호출
        System.out.println(); // dfs 와 bfs 간의 간격
        visited = new boolean[N + 1]; // visited 초기화
        bfs(crossed, start, visited); // bfs 호출

    }

    public static void dfs(HashMap<Integer, List<Integer>> crossed, boolean[] visited, int start) {
        System.out.print(start + " "); // 현재 방문한점 출력
        visited[start] = true; // 현재점 방문
        List<Integer> points = crossed.get(start); // 현재점의 인접한 점들
        if (points != null) { // 인접한점이 있다면
            Collections.sort(points); // 인접한 점이 여러개면 값이 작은 점부터 방문해야함으로 정렬
            points.forEach(integer -> { // 각 점에 대한 반복
                if (!visited[integer]) { // 해당점이 방문을 하지 않은 점이라면
                    dfs(crossed, visited, integer); // dfs 호출
                }
            });
        }

    }

    public static void bfs(HashMap<Integer, List<Integer>> crossed, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>(); // 방문할 점들을 담을 객체
        queue.add(start); // 시작점 저장
        visited[start] = true; // 시작점 방문했으니 방문했다고 저장
        while (!queue.isEmpty()) { // 방문할 점들이 남아있을때까지
            int now = queue.poll();// 현재 방문한점의 점들중 가장 먼저 들어온 점으로 갱신
            System.out.print(now + " "); // 위에 점 출력
            List<Integer> points = crossed.get(now); // 방문한 점의 인접점들
            if (points != null) { // 인접점들이 존재한다면
                Collections.sort(points); // 인접한 점이 여러개면 값이 작은 점부터 방문해야함으로 정렬
                points.forEach(i -> { // 각 점에 대한 반복
                    if (!visited[i]) { // 각 점이 방문하지 않은 점이라면
                        queue.add(i); // 각 접점을 방문할 점들을 순서대로 저장
                        visited[i] = true; // 방문할 점들이니 방문했다고 저장
                    }
                });
            }
        }
    }
}

