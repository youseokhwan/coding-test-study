package programers.lv1._0512;

public class Q12918 {
    public boolean solution(String s) {
        boolean answer = true;
        if (s.length() < 4 || s.length() > 6 || s.length() == 5) {
            return false;
        }
        String check = "^[0-9]+$";
        if (s.matches(check)) {
            return true;
        }
        String test = s.replaceAll("[^0-9]","");
        if (test.equals(s)) {
            return true;
        }

        return false;
    }
}
