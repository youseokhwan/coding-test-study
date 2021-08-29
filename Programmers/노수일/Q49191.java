class Q49191 {

  public int solution(int n, int[][] results) {
    int answer = 0;
    int[][] map = new int[n][n];

    for (int i = 0; i < results.length; i++) {
      int win = results[i][0] - 1;
      int lose = results[i][1] - 1;
      map[win][lose] = 1;
      map[lose][win] = -1;
    }

    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (i == j || map[i][j] != 0) {
            continue;
          }
          if (map[i][k] == map[k][j]) {
            map[i][j] = map[i][k];
          }
        }
      }
    }
    for (int i = 0; i < n; i++) {
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }

        if (map[i][j] == 0 && map[j][i] == 0) {
          flag = false;
          break;
        }
      }
      if (flag) {
        answer++;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.printf(
        "" + new Q49191().solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
  }
}

