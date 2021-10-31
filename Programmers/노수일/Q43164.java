import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q43164 {

  String result = "ZZZ";

  public String[] solution(String[][] tickets) {

    boolean[] visited = new boolean[tickets.length];

    List<List<String>> ticketList = new ArrayList<>();
    for (int i = 0; i < tickets.length; i++) {
      List<String> startEnd = new ArrayList<>();
      startEnd.add(tickets[i][0]);
      startEnd.add(tickets[i][1]);
      ticketList.add(startEnd);
    }

    Collections.sort(ticketList, new Comparator<List<String>>() {

      @Override
      public int compare(List<String> l1, List<String> l2) {

        if (l1.get(0).equals(l2.get(0))) {
          return l1.get(1).compareTo(l2.get(1));
        }
        return l1.get(0).compareTo(l2.get(0));
      }
    });

    for (int i = 0; i < ticketList.size(); i++) {
      if ("ICN".equals(ticketList.get(i).get(0))) {
        visited[i] = true;
        List<String> path = new ArrayList<>();
        path.add(ticketList.get(i).get(0));
        dfs(ticketList, i, visited, 1, path);
        visited[i] = false;
      }
    }
    return result.split(",");
  }

  private void dfs(List<List<String>> ticketList, int current, boolean[] visited, int depth,
      List<String> path) {

    if (depth == ticketList.size() && path.size() == ticketList.size()) {
      path.add(ticketList.get(current).get(1));
      String resultPath = String.join(",", path);
      if (resultPath.compareTo(result) < 0) {
        result = resultPath;
      }
      return;
    }

    for (int i = 0; i < ticketList.size(); i++) {
      if (visited[i]) {
        continue;
      }

      if (ticketList.get(current).get(1).equals(ticketList.get(i).get(0))) {
        visited[i] = true;
        path.add(ticketList.get(i).get(0));
        dfs(ticketList, i, visited, depth + 1, path);
        path.remove(path.size() - 1);
        visited[i] = false;
      }
    }
  }

}
