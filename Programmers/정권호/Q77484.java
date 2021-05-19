package programers.lv1._0509;

public class Q77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] counting = new int[46]; // 카운팅 배열

        for (int i = 0; i < lottos.length; i++) { // 
            counting[lottos[i]]++;
        }

        int cnt = 0;
        for (int i = 0; i < win_nums.length; i++) {
            counting[win_nums[i]]++;
            if (counting[win_nums[i]] == 2) {
                cnt++;
            }
        }

        int min = cnt;
        int max = Math.min(6, cnt + counting[0]);

        answer[0] = 7 - max;
        if (answer[0] > 6) {
            answer[0] = 6;
        }

        answer[1] = 7 - min;

        if (answer[1] > 6) {
            answer[1] = 6;
        }


        return answer;
    }
}
