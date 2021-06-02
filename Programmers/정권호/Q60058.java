package programers.lv2._0519;

public class Q60058 {
    public static String solution(String p) {
        String answer = "";
        if (p.isEmpty()) {
            return answer;
        }

        char start = p.charAt(0);
        int cnt = 1;

        for (int i = 1; i < p.length(); i++) {
            if (start == p.charAt(i)) {
                System.out.println("같음!");
                cnt++;
                continue;
            }
            cnt--;

            if (cnt == 0) {
                cnt = i + 1;
                break;
            }
        }

        if (start != '(') {
            if (cnt == 0) {
                for (int i = 0; i < p.length(); i++) {
                    if (p.charAt(i) == '(') {
                        answer += ")";
                        continue;
                    }
                    answer += "(";
                }
                return answer;
            }
            String u = p.substring(0, cnt);
            String v = p.substring(cnt);

            System.out.println(p);
            System.out.println(u);
            System.out.println(v);
            System.out.println("======================");
            System.out.println();

            answer += "(";
            answer += solution(v);
            answer += ")";

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    answer += ")";
                    continue;
                }
                answer += "(";
            }
            return answer;
        }

        if (cnt == 0) {
            return p;
        }

        String u = p.substring(0, cnt);
        String v = p.substring(cnt);

        System.out.println(p);
        System.out.println(u);
        System.out.println(v);
        System.out.println("======================");
        System.out.println();

        answer += u;
        answer += solution(v);
        return answer;
    }

    public static void main(String[] args) {
//        String solution = solution("(()))()(()))(()))(((");
//        System.out.println(solution);
//        System.out.println(solution.length());

        String solution1 = solution("()))((()");
        System.out.println(solution1);
        System.out.println(solution1.length());
    }
}
