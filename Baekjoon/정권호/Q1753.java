import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());

        int MAX = 199991; // 점의 수가 20,000개 이고, 가중치의 최대값이 10이니 가중치의 최대값은 ((20,000 - 1) * 10) 임

        // HashMap 은 더 간단하지만, get() 메소드가 최악의 경우 O(n)의 시간복잡도를 가져서 시간초과
        // 2차원 배열로 하면 메모리 초과
        List<Integer[]>[] lines = new List[V];

        for (int i = 0; i < V; i++) {
            lines[i] = new ArrayList<>();
        }

        boolean[] visited = new boolean[V];
        int start = Integer.parseInt(reader.readLine()) - 1;

        for (int i = 0; i < E; i++) { // 입력 받기
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken()) - 1;
            int v = Integer.parseInt(tokenizer.nextToken()) - 1;
            int w = Integer.parseInt(tokenizer.nextToken());

            lines[u].add(new Integer[]{v, w});
        }

        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() { // 가중치 우선순위 큐
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });


        int[] dist = new int[V];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        queue.add(new Integer[]{start, dist[start]});

        while (!queue.isEmpty()) { // 다익스트라
            Integer[] poll = queue.poll();
            Integer now = poll[0];
            Integer distance = poll[1];

            if (distance > dist[now]) { // 중복 간선 제거, 간선이 같더라도 가중치가 더 큰 간선들을 거르는 작업
                continue;
            }

            visited[now] = true;

            lines[now].forEach(line -> { // 방문한적 없고, 현재 가중치보다 방문점의 가중치 + 방문점과 다른 점들의 가중치와 비교후 갱신
                if (!visited[line[0]]) {
                    if (dist[line[0]] > distance + line[1]) {
                        dist[line[0]] = distance + line[1];
                        queue.add(new Integer[]{line[0], distance + line[1]});
                    }
                }
            });

        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < V; i++) {
            if (dist[i] >= MAX) {
                builder.append("INF").append("\n");
                continue;
            }

            builder.append(dist[i]).append("\n");
        }
        System.out.println(builder);
    }
}
