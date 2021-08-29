import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Q17676 {

  private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";

  private DateTimeFormatter formmater = DateTimeFormatter.ofPattern(TIME_FORMAT);

  class LogDateTime {

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    public LocalDateTime getStartDateTime() {
      return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
      return endDateTime;
    }

    public LogDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
      this.startDateTime = startDateTime;
      this.endDateTime = endDateTime;
    }
  }

  public LogDateTime toLogDateTime(String log) {
    String[] splited = log.split(" ");
    LocalDateTime endDateTime = LocalDateTime.parse(String.join(" ", splited[0], splited[1]),
        formmater);
    LocalDateTime startDateTime = endDateTime
        .minus(Double.valueOf(Double.valueOf(splited[2].replace("s", "")) * 1000 - 1).longValue(),
            ChronoUnit.MILLIS);

    return new LogDateTime(startDateTime, endDateTime);
  }

  public int solution(String[] lines) {

    List<LogDateTime> timeList = Stream.of(lines).map(this::toLogDateTime)
        .collect(Collectors.toList());

    int answer = 0;
    for (int i = 0; i < timeList.size(); i++) {
      int count = 0;
      LogDateTime at = timeList.get(i);
      LocalDateTime comparison = at.getEndDateTime();
      for (int j = i; j < timeList.size(); j++) {

        LogDateTime after = timeList.get(j);
        LocalDateTime afterStart = after.getStartDateTime().minus(1, ChronoUnit.SECONDS);

        if (comparison.isAfter(afterStart)) {
          count++;
        }
      }

      if (count > answer) {
        answer = count;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.printf("" + new Q17676().solution(new String[]{
        "2016-09-15 20:59:57.421 0.351s",
        "2016-09-15 20:59:58.233 1.181s",
        "2016-09-15 20:59:58.299 0.8s",
        "2016-09-15 20:59:58.688 1.041s",
        "2016-09-15 20:59:59.591 1.412s",
        "2016-09-15 21:00:00.464 1.466s",
        "2016-09-15 21:00:00.741 1.581s",
        "2016-09-15 21:00:00.748 2.31s",
        "2016-09-15 21:00:00.966 0.381s",
        "2016-09-15 21:00:02.066 2.62s"}));
  }
}

