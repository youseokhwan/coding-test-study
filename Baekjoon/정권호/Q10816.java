import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        int N = Integer.parseInt(reader.readLine()); // 숫자 카드의 수 N
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine()); // 쪼개줄 객체
        HashMap<String, Integer> cards = new HashMap<>(); // 숫자카드와 숫자카드의 수를 담을 객체

        for (int i = 0; i < N; i++) { // 숫자카드 입력
            String card = tokenizer.nextToken(); // 숫자 카드
            cards.put(card, cards.getOrDefault(card, 0) + 1); // 카드가 담겨있는 객체에서 없으면 0을 반환하여 1을 더하고, 있으면 그 값에 1을 더해서 저장
        }

        StringBuilder builder = new StringBuilder(); // 결과물 답을 객체
        N = Integer.parseInt(reader.readLine()); // 찾아야하는 카드의 수 M
        tokenizer = new StringTokenizer(reader.readLine()); // 쪼개줄 객체

        for (int i = 0; i < N; i++) { // 찾을 카드 입력
            String card = tokenizer.nextToken(); // 찾을 카드
            builder.append(cards.getOrDefault(card, 0)).append(" "); // 카드가 없으면 0, 있으면 해당 카드의 수
        }

        System.out.println(builder); // 결과 출력
    }
}
