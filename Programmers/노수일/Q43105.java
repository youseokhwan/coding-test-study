public class Q43105 {

  public int solution(int[][] triangle) {

    for (int i = 1; i < triangle.length; i++) {
      for (int j = 0; j <= i; j++) {

        if (j == 0) {
          triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
          continue;
        }
        if (j == i) {
          triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
          continue;
        }

        int left = triangle[i - 1][j - 1] + triangle[i][j];
        int right = triangle[i - 1][j] + triangle[i][j];

        if (left > right) {
          triangle[i][j] = left;
        } else {
          triangle[i][j] = right;
        }
      }
    }

    int answer = 0;

    for (int i = 0; i < triangle.length; i++) {
      if (triangle[triangle.length - 1][i] > answer) {
        answer = triangle[triangle.length - 1][i];
      }
    }

    return answer;
  }


  public static void main(String[] args) {
    System.out.printf("" + new Q43105().solution(
        new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
  }
}
