package programers.lv2._0519;

public class Q62048 {
    public static int gcd(int a, int b){ // 최대공약수
        while(b!=0){
            int r = a%b;
            a= b;
            b= r;
        }
        return a;
    }

    public static long solution(int w, int h) {
        long answer = 0;
        if (w == h) {
            return (long) w * h - w;
        }

        if (w == 1 || h == 1) {
            return 0;
        }

        for (int i = 1; i <= w; i++) {
            double ceil = Math.ceil(((double) h / w) * i);
            answer += h - ceil;
        }
        return answer * 2;
    }


}
