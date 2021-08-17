package programers.lv3._0721;

public class Q60059 {
    class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;
            int cnt = 0;
            for (int i = 0; i < lock.length; i++) {
                for (int j = 0; j < lock[i].length; j++) {
                    if (lock[i][j] == 0) {
                        cnt++;
                    }
                }
            }
            int[][] clone = key.clone();

            for (int i = 0; i < 4; i++) {
                if (i > 0) {
                    clone = new int[key.length][key.length];
                    for (int i1 = 0; i1 < clone.length; i1++) {
                        for (int i2 = 0; i2 < clone.length; i2++) {
                            clone[i2][clone.length - 1 - i1] = key[i1][i2];
                        }
                    }
                    key = clone.clone();
                }

                for (int j = -key.length + 1; j < lock.length; j++) {
                    loop:
                    for (int k = -key.length + 1; k < lock.length; k++) {
                        int keyCnt = 0;
                        for (int i1 = 0; i1 < clone.length; i1++) {
                            for (int i2 = 0; i2 < clone[i1].length; i2++) {
                                int y = i1 + j;
                                int x = i2 + k;
                                if (y < 0 || y >= lock.length || x < 0 || x >= lock.length) {
                                    continue;
                                }
                                if (clone[i1][i2] == 1 && lock[y][x] == 1) {
                                    continue loop;
                                }
                                if (clone[i1][i2] == 1 && lock[y][x] == 0) {
                                    keyCnt++;
                                }

                            }
                        }
                        if (keyCnt == cnt) {
                            return true;
                        }

                    }
                }
            }
            return answer;
        }
    }

}
