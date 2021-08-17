package programers.lv3._0808;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q42895 {
    class Solution {
        public int solution(int N, int number) {
            if (N == number) {
                return 1;
            }
            int answer = -1;
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            List<Integer> list = new ArrayList<Integer>();
            list.add(N);
            map.put(1, list);

            for (int i = 2; i < 9; i++) {
                if (i == 2) {
                    List<Integer> listLeft = new ArrayList<Integer>();
                    listLeft.add(N + N);
                    listLeft.add(N - N);
                    listLeft.add(N * N);
                    listLeft.add(N / N);
                    listLeft.add(N * 11);
                    map.put(i, listLeft);
                } else {
                    List<Integer> listLeft = new ArrayList<Integer>();
                    List<Integer> listRight = new ArrayList<Integer>();
                    HashSet<Integer> buf = new HashSet<Integer>();
                    String num = "";
                    for (int j = 0; j < i; j++) {
                        num += N;
                    }
                    buf.add(Integer.parseInt(num));
                    for (int j = 1; j <= i - j; j++) {
                        listLeft = map.get(j);
                        listRight = map.get(i - j);
                        for (int k = 0; k < listLeft.size(); k++) {
                            for (int k2 = 0; k2 < listRight.size(); k2++) {
                                buf.add(listLeft.get(k) + listRight.get(k2));
                                buf.add(listLeft.get(k) * listRight.get(k2));
                                buf.add(listLeft.get(k) - listRight.get(k2));
                                buf.add(listRight.get(k2) - listLeft.get(k));
                                if (listRight.get(k2) != 0) {
                                    buf.add(listLeft.get(k) / listRight.get(k2));
                                }
                                if (listLeft.get(k) != 0) {
                                    buf.add(listRight.get(k2) / listLeft.get(k));
                                }
                            }
                        }
                    }

                    List<Integer> list2 = new ArrayList<Integer>();
                    list2.addAll(buf);
                    map.put(i, list2);
                }

                if (map.get(i).contains(number)) {
                    return i;
                }
            }

            return answer;
        }
    }
}
