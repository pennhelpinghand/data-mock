import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class FitBitMock {
  // DATA TYPES
  // heartbeat flat; steps flat --> control
  static JSONObject control = new JSONObject();
  // heartbeat spike; steps flat  --> positive
  static JSONObject positive = new JSONObject();
  // heartbeat spike, steps spike  --> negative
  static JSONObject negative = new JSONObject();

  public static void main(String args[]) {
    // 5 seconds intervals // 5 minutes

    ////////////////////////////// Control JSON  ////////////////////////////////////////////////////////////
    JSONArray controlTicks = new JSONArray();
    LocalTime controlTime = LocalTime.of(1, 0, 0);
    for (int i=0; i<60; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(80, 83);
      int randomStep = ThreadLocalRandom.current().nextInt(3, 6);

      tick.put("timestamp", controlTime.plusSeconds(5));
      controlTime = controlTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      controlTicks.put(tick);
    }
    control.put("Control", controlTicks);
    System.out.println("CONTROL");
    System.out.println(control.toString() + "\n");

    ////////////////////////////// Positive JSON  ////////////////////////////////////////////////////////////
    JSONArray positiveTicks = new JSONArray();
    LocalTime positiveTime = LocalTime.of(1, 0, 0);

    for (int i=0; i<25; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(119, 131);
      int randomStep = ThreadLocalRandom.current().nextInt(3, 6);

      tick.put("timestamp", positiveTime.plusSeconds(5));
      positiveTime = positiveTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      positiveTicks.put(tick);
    }
    // SPIKE UPWARDS
    for (int i=25; i<50; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(119, (int)(131+i*1.5));
      int randomStep = ThreadLocalRandom.current().nextInt(3, 6);

      tick.put("timestamp", positiveTime.plusSeconds(5));
      positiveTime = positiveTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      positiveTicks.put(tick);
    }

    // SPIKE DOWNWARDS
    for (int i=50; i<60; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(119, 131-(i-50));
      int randomStep = ThreadLocalRandom.current().nextInt(3, 6);

      tick.put("timestamp", positiveTime.plusSeconds(5));
      positiveTime = positiveTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      positiveTicks.put(tick);
    }

    positive.put("Positive", positiveTicks);
    System.out.println("POSITIVE");
    System.out.println(positive.toString() + "\n");

    ////////////////////////////// Negative JSON  ////////////////////////////////////////////////////////////
    JSONArray negativeTicks = new JSONArray();
    LocalTime negativeTime = LocalTime.of(1, 0, 0);

    for (int i=0; i<25; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(95, 100);
      int randomStep = ThreadLocalRandom.current().nextInt(5, 8);

      tick.put("timestamp", negativeTime.plusSeconds(5));
      negativeTime = negativeTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      negativeTicks.put(tick);
    }
    // SPIKE UPWARDS
    for (int i=25; i<50; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(120, 131+(i-25));
      int randomStep = ThreadLocalRandom.current().nextInt(15, 23);

      tick.put("timestamp", negativeTime.plusSeconds(5));
      negativeTime = negativeTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      negativeTicks.put(tick);
    }

    // SPIKE DOWNWARDS
    for (int i=50; i<60; i++) {
      JSONObject tick = new JSONObject();
      int randomHB = ThreadLocalRandom.current().nextInt(105, 120-(i-50));
      int randomStep = ThreadLocalRandom.current().nextInt(3, 6);

      tick.put("timestamp", negativeTime.plusSeconds(5));
      negativeTime = negativeTime.plusSeconds(5);
      tick.put("heartbeat", randomHB);
      tick.put("steps", randomStep);
      negativeTicks.put(tick);
    }

    negative.put("Negative", negativeTicks);
    System.out.println("NEGATIVE");
    System.out.println(negative.toString() + "\n");
  }
}
