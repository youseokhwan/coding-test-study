package programers.lv1._0509;

public class Q12977 {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) { // 조합 가능한 모든 경우의 수 반복
            for (int j = i + 1; j < nums.length; j++) {
                loop : for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j]+ nums[k];
                    for (int a = 2; a < num; a++) { // 2 부터 자신 값 - 1 까지 체크
                        if (num % a == 0) {
                            continue loop; // 소수가 아니면 loop 반목분 continue
                        }
                    }
                    answer++; // 위에 반복문에서 걸러지지 않았으면 소수
                }
            }
        }

        return answer;
    }
}
