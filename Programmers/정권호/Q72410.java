package programers.lv1._0502;

public class Q72410 {
    public static String solution(String new_id) {
        String answer = "";
        answer = new_id;

        String special = "~!@#$%^&*()=+[{]}:?,<>/";
        char[] chars = special.toCharArray();

        answer = answer.toLowerCase();

        for (int i = 0; i < chars.length; i++) {
            answer = answer.replace(chars[i] + "", "");
        }

        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }


        if (answer.endsWith("")) {
            answer = answer.substring(0, answer.length()-1);
        }

        if (answer.isEmpty()) {
            answer = "a";
        }

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
        }

        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }

        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length()-1);
        }

        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}
