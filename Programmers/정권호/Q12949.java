package programers.lv2._0627;

public class Q12949 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = {};
            if (arr1[0].length == arr2.length) { // A * B
                answer = new int[arr1.length][arr2[0].length];
                for (int i = 0; i < answer.length; i++) {
                    for (int j = 0; j < answer[i].length; j++) {
                        for (int k = 0; k < arr1[i].length; k++) {
                            answer[i][j] += arr1[i][k] * arr2[k][j];
                        }
                    }
                }
            } else { // B * A
                answer = new int[arr2.length][arr1[0].length];
                for (int i = 0; i < answer.length; i++) {
                    for (int j = 0; j < answer[i].length; j++) {
                        for (int k = 0; k < arr1.length; k++) {
                            answer[i][j] += arr2[i][k] * arr1[k][j];
                        }
                    }
                }
            }

            return answer;
        }
    }
}

