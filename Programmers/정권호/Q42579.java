package programers.lv3._0704;

import java.util.*;

public class Q42579 {
    class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            HashMap <String, Integer> genre = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                int play = genre.getOrDefault(genres[i], 0) + plays[i];
                genre.put(genres[i], play);
            }

            HashMap<Integer, String> sortedGenre = new HashMap<>();

            int[] sortedPlays = new int[plays.length];
            int cnt = 0;

            List<String> keySet = new ArrayList<>(genre.keySet());
            keySet.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return genre.get(o2) - genre.get(o1);
                }
            });

            for (String s : keySet) {
                System.out.println(s);
            }


            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < keySet.size(); i++) {

                PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
                    @Override
                    public int compare(Integer[] o1, Integer[] o2) {
                        if (o1[1] == o2[1]){
                            return o1[0] - o2[0];
                        }
                        return o2[1] - o1[1];
                    }
                });

                for (int j = 0; j < genres.length; j++) {
                    if (keySet.get(i).equals(genres[j])) {
                        queue.add(new Integer[]{j, plays[j]});
                    }
                }
                int cnt1 = 2;

                while (!queue.isEmpty() && cnt1 > 0) {
                    list.add(queue.poll()[0]);
                    cnt1--;
                }

            }

            answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
}
