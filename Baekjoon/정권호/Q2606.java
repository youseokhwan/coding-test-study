import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        int C = Integer.parseInt(reader.readLine()); // 컴퓨터의 수
        int connected = Integer.parseInt(reader.readLine()); // 연결된 수
        HashMap<Integer, List<Integer>> crossed = new HashMap<>(); // 연결된 컴퓨터들을 담을 객체

        for (int i = 0; i < connected; i++) { // 연결된 컴퓨터들 저장
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int point1 = Integer.parseInt(tokenizer.nextToken());
            int point2 = Integer.parseInt(tokenizer.nextToken());

            List<Integer> list1 = crossed.getOrDefault(point1, new ArrayList<>()); // 해당 점이 컴퓨터들을 가지고 있으면 그컴퓨터들 반환, 아니면 빈 List 반환
            list1.add(point2);
            List<Integer> list2 = crossed.getOrDefault(point2, new ArrayList<>());
            list2.add(point1);
            crossed.put(point1, list1);
            crossed.put(point2, list2);
        }

        boolean[] visited = new boolean[C + 1]; // 컴퓨터들 연결을 확인할 배열, boolean 의 기본값은 false
        int bfs = bfs(crossed, 1, visited); // bfs 호출
        System.out.println(bfs); // 감염된 컴퓨터 수 출력
    }

    public static int bfs(HashMap<Integer, List<Integer>> crossed, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>(); // 연결된 컴퓨터들을 담을 객체
        int count = -1; // 자기 자신은 제외하고 감연된 컴퓨터의 수를 찾는것이니 -1로 시작
        queue.add(start);
        visited[start] = true; // 시작 컴퓨터는 연결됬다고 저장
        while (!queue.isEmpty()) { // 연결된 컴퓨터들이 남아있을때까지
            int now = queue.poll(); // start 를 연결된 컴퓨터들중 하나를 빼서 갱신
            count++; // 감연된 컴퓨터를 빼는거니 감염된 컴퓨터 수 1증가
            List<Integer> integers = crossed.get(now); // 뺀 컴퓨터와 연결된 컴퓨터들
            if (integers != null) { // 연결된 컴퓨터가 존재한다면
                integers.forEach(i -> { // 각 컴퓨터에 대한 반복
                    if (!visited[i]) { // 각 컴퓨터가 연결된 컴퓨터가 아니라면
                        queue.add(i); // 연결된 컴퓨터들을 저장
                        visited[i] = true; // 연결된 컴퓨터이니 연결됬다고 저장
                    }
                });
            }
        }
        return count; // 감연된 컴퓨터의 수 반환
    }
}
