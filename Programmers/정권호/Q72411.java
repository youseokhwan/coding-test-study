package programers.lv2._0623;

import java.util.*;


public class Q72411 {
    class Solution {
        HashSet<String> menuComb = new HashSet<>();
        HashMap<String, Integer> result = new HashMap<>();
        HashMap<Integer, Integer> maxes = new HashMap<>();

        public void combination(Character[] alphas, boolean[] visited, int cnt, int now) {
            if (cnt == 0) {
                String word = "";
                for (int i = 0; i < alphas.length; i++) {
                    if (visited[alphas[i] - 'A']) {
                        word += alphas[i];
                    }
                }
                menuComb.add(word);
                return;
            }
            if (now == alphas.length) {
                return;
            }
            visited[alphas[now] - 'A'] = true;
            combination(alphas, visited, cnt - 1, now + 1);
            visited[alphas[now] - 'A'] = false;
            combination(alphas, visited, cnt, now + 1);

        }


        public String[] solution(String[] orders, int[] course) {
            String[] answer = {};
            List<Character> menus = new ArrayList<>();

            for (int i = 0; i < orders.length; i++) {
                menus.clear();
                for (int j = 0; j < orders[i].length(); j++) {
                    menus.add(orders[i].charAt(j));
                    menus.sort(new Comparator<Character>() {
                        @Override
                        public int compare(Character o1, Character o2) {
                            return o1 - o2;
                        }
                    });
                }

                Character[] characters = menus.toArray(new Character[menus.size()]);
                for (int i1 : course) {
                    menuComb.clear();
                    combination(characters, new boolean[26], i1, 0);
                    for (String s : menuComb) {
                        result.put(s, result.getOrDefault(s, 0) + 1);
                        maxes.put(s.length(), Math.max(maxes.getOrDefault(s.length(), 0), result.get(s)));
                    }
                }
            }

            List<String> answers = new ArrayList<>();

            for (String s : result.keySet()) {
                if (maxes.get(s.length()) == result.get(s) && maxes.get(s.length()) > 1) {
                    answers.add(s);
                }
            }

            Collections.sort(answers);
            answer = answers.toArray(new String[answers.size()]);
            return answer;
        }
    }
}

