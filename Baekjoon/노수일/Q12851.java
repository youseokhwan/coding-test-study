import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12851 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(stringTokenizer.nextToken());
    int k = Integer.parseInt(stringTokenizer.nextToken());

    if (n >= k) {
      System.out.println((n - k) + "\n1");
      return;
    }

    Queue<Integer> q = new LinkedList<Integer>();
    int[] time = new int[100001];
    int minTime = 987654321;
    int count = 0;

    q.add(n);
    time[n] = 1;

    while (!q.isEmpty()) {
      int now = q.poll();

      if (minTime < time[now]) {
        break;
      }

      for (int i = 0; i < 3; i++) {
        int next;

        if (i == 0) {
          next = now + 1;
        } else if (i == 1) {
          next = now - 1;
        } else {
          next = now * 2;
        }

        if (next < 0 || next > 100000) {
          continue;
        }

        if (next == k) {
          minTime = time[now];
          count++;
        }

        if (time[next] == 0 || time[next] == time[now] + 1) {
          q.add(next);
          time[next] = time[now] + 1;
        }
      }
    }

    System.out.println(minTime + "\n" + count);
  }

}