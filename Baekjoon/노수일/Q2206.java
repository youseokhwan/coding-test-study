import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2206 {

  public class Place {

    int x;
    int y;
    int distance;
    int drill;

    public Place(int y, int x, int distance, int drill) {
      this.x = x;
      this.y = y;
      this.distance = distance;
      this.drill = drill;
    }
  }

  public int move(int n, int m, int[][] matrix, int[][] visit) {
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    int result = Integer.MAX_VALUE;

    Queue<Place> queue = new LinkedList<>();
    queue.add(new Place(0, 0, 1, 0));
    visit[0][0] = 0;

    while (!queue.isEmpty()) {
      Place place = queue.poll();
      if (place.y == n - 1 && place.x == m - 1) {
        result = place.distance;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int ny = place.y + dy[i];
        int nx = place.x + dx[i];

        if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
          continue;
        }

        if (visit[ny][nx] <= place.drill) {
          continue;
        }

        if (matrix[ny][nx] == 0) {
          visit[ny][nx] = place.drill;
          queue.add(new Place(ny, nx, place.distance + 1, place.drill));
        } else {
          if (place.drill == 0) {
            visit[ny][nx] = place.drill + 1;
            queue.add(new Place(ny, nx, place.distance + 1, place.drill + 1));
          }
        }
      }
    }
    if (result == Integer.MAX_VALUE) {
      result = -1;
    }

    return result;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] firstLine = reader.readLine().split(" ");
    int n = Integer.valueOf(firstLine[0]);
    int m = Integer.valueOf(firstLine[1]);

    int[][] matrix = new int[n][m];
    int[][] visit = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] line = reader.readLine().split("");
      for (int j = 0; j < m; j++) {
        matrix[i][j] = Integer.valueOf(line[j]);
        visit[i][j] = 2;
      }
    }

    System.out.println(new Q2206().move(n, m, matrix, visit));
  }

}

