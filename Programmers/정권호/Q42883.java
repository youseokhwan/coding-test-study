package programers.lv2._0616;

public class Q42883 {
    class Solution {
        public String solution(String number, int k) {
            String answer = "";
            int now = 0;
            int max = -1;
            int num = number.length() - k;

            while (num > 0) {
                for (int i = now; i <= number.length() - num; i++) {
                    if (number.charAt(i) - '0' == 9){
                        max = number.charAt(i) - '0';
                        now = i + 1;
                        break;
                    }
                    if (max < number.charAt(i) - '0') {
                        max = number.charAt(i) - '0';
                        now = i + 1;
                    }
                }
                answer += "" + max;
                num--;
                max = -1;
            }

            return answer;
        }
    }

}
