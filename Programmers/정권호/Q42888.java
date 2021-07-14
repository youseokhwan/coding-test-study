package programers.lv2._0616;

import java.util.HashMap;

public class Q42888 {
    class Solution {
        public String[] solution(String[] record) {
            String[] buffer = new String[record.length];
            String total = "";
            int cnt = 0;
            HashMap<String, String> nick = new HashMap<>();

            for (int i = 0; i < record.length; i++) {
                String[] msg = record[i].split(" ");

                if (msg.length < 3) {
                    buffer[cnt++] = msg[1] + " 님이 나갔습니다.";
                    continue;
                }

                if (msg[0].equals("Enter")) {
                    buffer[cnt++] = msg[1] + " 님이 들어왔습니다.";
                    nick.put(msg[1], msg[2]);
                    continue;
                }

                nick.put(msg[1], msg[2]);
            }

            String[] answer = new String[cnt];

            for (int i = 0; i < cnt; i++) {
                String[] s = buffer[i].split(" ");
                answer[i] = nick.get(s[0]) + s[1] + " " + s[2];
            }

            return answer;
        }
    }
}