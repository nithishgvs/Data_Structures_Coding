package org.twentytwentytwo.practice;

import org.junit.Test;

public class AngleBetweenHandsofaClock_1344 {


  public double angleClock(int hour, int minutes) {

    float hAngle = ((float) hour % 12 + (float) minutes / 60) * 30;
    float mAngle = (minutes % 60) * 6;

    float angle = Math.abs(hAngle - mAngle);

    return angle > 180 ? (360 - angle) : angle;

  }


  @Test
  public void test(){
    System.out.println(angleClock(12,30));
  }
}
