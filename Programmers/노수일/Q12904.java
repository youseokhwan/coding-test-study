public class Q12904 {

  public int solution(String s) {

    int length = s.length();
    char[] characters = s.toCharArray();
    while (length > 1) {

      for (int i = 0; i <= s.length() - length; i++) {
        boolean find = true;
        for (int j = i; j < i + (length / 2); j++) {
          if (characters[j] != characters[i + length - (j - i) - 1]) {
            find = false;
            break;
          }
        }
        if (find) {
          return length;
        }
      }
      length--;
    }

    return 1;
  }
}
