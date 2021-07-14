package programers.lv2._0627;

public class Q12951 {
    class Solution {
        public String solution(String s) {
            String answer = "";
            String[] buf = s.split(" ");

            for (int i = 0; i < buf.length; i++) {
                if (buf[i].length() == 0) { // 공백이 여러개 붙어있는 경우
                    continue;
                }

                char[] word = buf[i].toCharArray();
                if (Character.isLowerCase(word[0])) {
                    word[0] = Character.toUpperCase(word[0]);
                }

                for (int j = 1; j < word.length; j++) {
                    if (Character.isUpperCase(word[j])) {
                        word[j] = Character.toLowerCase(word[j]);
                    }
                }

                buf[i] = String.valueOf(word);
            }

            for (int i = 0; i < buf.length; i++) {
                answer += " " + buf[i];
            }

            answer = answer.substring(1);
            if (answer.length() != s.length()) { // 문자 끝에 공백이 있는 경우
                answer += " ".repeat(s.length() - answer.length());
            }
            return answer;
        }
    }
}
