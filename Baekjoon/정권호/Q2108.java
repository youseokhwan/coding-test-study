import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        int N = Integer.parseInt(reader.readLine()); // N 개의 수
        int[] arr = new int[N]; // N 개의 배열
        int min = 4001; // 최솟값
        int max = -4001; // 최대값
        double sum = 0; // 합계

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine()); // 수 입력받기
            sum += arr[i]; // 합계
            if (min > arr[i]) { // 최솟값 구하기
                min = arr[i];
            }
            if (max < arr[i]) { // 최대값 구하기
                max = arr[i];
            }
        }

        int numRange = Math.abs(max); // 카운팅 배열의 범위
        if (Math.abs(min) > numRange) { // 음수의 범위도 체크
            numRange = Math.abs(min);
        }

        int[] answer = new int[4]; // 통계값을 담을 배열
        answer[0] = (int) Math.round(sum / N); // 평균값 Math 라이브러리리에 round 함수를 이용하여 소수점 첫째 자리에서 반올림
        answer[3] = max - min; // 범위

        answer = solution(arr, answer, numRange); // 나머지 통계갑을 구하는 함수 호출

        for (int i = 0; i < answer.length; i++) { // 각 통계값 출력
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(int[] input, int[] answer, int max) {
        int[] counting = new int[max * 2 + 1]; // 카운팅 배열, 음수의 빈도수도 체크해야함으로 2배로
        int frequency = 0; // 최빈값의 빈도수

        for (int i = 0; i < input.length; i++) { // 각수의 빈도수 구하기
            counting[input[i] + max]++;
            if (frequency < counting[input[i] + max]) { // 가장 많이 나타나는 수의 빈도수 구하기
                frequency = counting[input[i] + max];
            }
        }

        int[] min = {max + 1, max + 1}; // 최빈값 중에 가장 작은 값과 두번째 값 (min[0] 에는 가장 작은 값, min[1] 에는 두번째로 작은 값)

        for (int i = 0; i < counting.length; i++) {
            if (counting[i] == frequency) { // 해당 수의 빈도수가 최빈값이면
                if (min[1] > i - max) { // 두번째로 작은 값보다 작은지
                    min[1] = i - max;
                }
                if (min[0] > min[1]) { // 가장 작은 값보다 작은지
                    int temp = min[0];
                    min[0] = min[1];
                    min[1] = temp;
                }
            }
            if (i > 0) { // 비어있는 수를 건너 뛰는 작업
                counting[i] += counting[i - 1];
            }
        }

        if (min[1] > max) { // 최빈값이 한개일 때는 두번째로 작은 값이 없음으로 가장 작은값으로 리턴
            min[1] = min[0];
        }

        answer[2] = min[1]; // 최빈값

        int[] sorted = new int[input.length]; // 정렬된 배열

        for (int i = 0; i < input.length; i++) { // 카운팅 배열을 이용하여 정렬
            sorted[(--counting[input[i] + max])] = input[i];
        }

        answer[1] = sorted[input.length / 2]; // 중간값

        return answer;
    }
}

