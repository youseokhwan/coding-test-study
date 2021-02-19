import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 객체
        int num = Integer.parseInt(reader.readLine()); // 로프 수 입력
        int[] lope = new int[num]; // 로프의 수 만큼 로프에 걸리는 중량을 담을 배열
        int weight = 0; // 최종 중량

        for (int i = 0; i < lope.length; i++) { // 로프의 수만큼 로프에 걸리는 중량 배열에 대입
            lope[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(lope); // 로프에 걸리는 중량을 오름차순으로 정렬
        weight = lope[0] * num; // 최종 중량을 가장 적게 나가는 로프의 무게 * 총 로프의 수로 대입

        for (int i = 1; i < lope.length; i++) { // 그다음으로 적게 나가는 로프부터 반복
            int lopeNum = num - i; // 로프의 수는 1개씩 줄어듬
            int nextWeight = lope[i] * lopeNum; // 그다음으로 적게 나가는 로프 * 로프의 수
            if (weight < nextWeight) { // 현재 최종 중량과 nextWeight과 비교하여 최종 중량이 더 작으면
                weight = nextWeight; // nextWeight 가 더 크면 최종 중량에 nextWeight 대입
            }
        }

        System.out.println(weight); // 최종중량 출력
    }
}


