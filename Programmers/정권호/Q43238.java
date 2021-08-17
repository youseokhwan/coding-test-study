package programers.lv3._0808;

public class Q43238 {
    class Solution {
        public long solution(int nbuf, int[] times) {
            long answer = 0;
            long start = 0;
            long end = 0;
            long n = (long) nbuf;
            end = Long.MAX_VALUE;

            long totalNum = 0;
            long midTime = 0;
            long min = Long.MAX_VALUE;

            while (start <= end) {
                boolean pass = false;
                totalNum = 0;
                midTime = (start + end) / (long) 2;
                for (int i = 0; i < times.length; i++) {
                    totalNum += midTime / (long) times[i];
                    if (totalNum > n) {
                        end = midTime - 1;
                        min = Math.min(min, midTime);
                        pass = true;
                        break;
                    }
                }
                if (pass) {
                    continue;
                }

                if (totalNum == n) {
                    min = Math.min(min, midTime);
                    end = midTime - 1;
                    continue;
                }
                start = midTime + 1;

            }
            return min;
        }
    } 
}
