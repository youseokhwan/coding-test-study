package programers.lv1._0502;

import java.util.Stack;

public class Q64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();

        for (int i = 0; i < moves.length; i++) {

            for (int y = 0; y < board.length; y++) {
                int x = moves[i] - 1;

                if (board[y][x] != 0) {
                    int now = board[y][x];
                    board[y][x] = 0;

                    if (!bucket.isEmpty()) {
                        Integer before = bucket.pop();
                        if (before - now == 0) {
                            answer += 2;
                            break;
                        }

                        bucket.add(before);
                        bucket.add(now);
                        break;
                    }

                    bucket.add(now);
                    break;
                }
            }
        }
        return answer;
    }
}
