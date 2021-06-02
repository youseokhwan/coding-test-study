package programers.lv2._0530;

public class Q60057 {
    class Solution {
        public int solution(String s) {
            int answer = s.length(); // 압축을 안한것보다 못하면 의미 없음

            for (int i = 1; i <= s.length() / 2; i++) { // 절반 이상으로 쪼개는 것은 의미 x
                String a = s.substring(0, i); // 압축 기준 단어
                int length = i; // 각 단위갯수로 잘랐을 때 길이, 압축 기준 선정 하면서 해당 단어 수 추가
                int cnt = 1; // 반복 횟수
                boolean check = false; // 최종적으로 잘랐는가?
                int end = 0; // 문자의 끝 부분 까지 잘랐는가?

                for (int j = i; j <= s.length() - i; j = j + i) {
                    String substring = s.substring(j, j + i);
                    end = s.length() - j - i; // (총 길이 - 자른 부분까지의 위치) = 자르지 못한 남은 부분의 개수

                    if (a.equals(substring)) { // 압축이 되면
                        cnt++; // 압축한 갯수 추가
                        check = false;
                        continue;
                    }

                    check = true;
                    if (cnt > 1) { // 압축 1개면 아무것도 안붙임, 2개부터
                        length++;
                        if (cnt > 9) { // 압축 10개 이상이면 두자리 숫자
                            length++;
                            if (cnt > 99) { // 100개 이상이면 세자리
                                length++;
                                if (cnt < 999) { // 1000개 이상이면 네자리
                                    length++;
                                }
                            }
                        }
                    }
                    a = substring; // 새로운 기준
                    length += i; // 새로운 기준 단어 수 추가
                    cnt = 1;
                }

                if (!check) {
                    if (cnt > 1) {
                        length++;
                        if (cnt > 9) {
                            length++;
                            if (cnt > 99) {
                                length++;
                                if (cnt < 999) {
                                    length++;
                                }
                            }
                        }
                    }
                }

                length += end;
                answer = Math.min(answer, length);

            }
            return answer;
        }
    }
}


