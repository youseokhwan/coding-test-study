package programers.lv1._0512;

public class Q12935 {
    class Solution {
        public int[] solution(int[] arr) {
            int[] answer = {};
            if (arr.length == 1) {
                return new int[]{-1};
            }

            int min = arr[0];
            for (int i = 1;  i < arr.length; i++) {
                min = Math.min(min, arr[i]);
            }

            answer = new int[arr.length - 1];
            int j = 0;
            for (int i = 0 ; i < answer.length; i++) {
                if (arr[j] == min) {
                    j++;
                }
                answer[i] = arr[j++];
            }
            return answer;
        }
    }
}
