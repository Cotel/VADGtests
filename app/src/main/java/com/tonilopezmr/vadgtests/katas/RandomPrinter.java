package com.tonilopezmr.vadgtests.katas;


import java.util.Random;

public class RandomPrinter {

  public int generateRandomBetween0And100() {
    return new Random().nextInt(100);
  }

  public boolean isEvenNumber(int number) {
    return number % 2 == 0;
  }

  public String getAndroidOrVadgForNumber(int number) {
    if (isEvenNumber(number)) return "VADG";
    else return "ANDROID";
  }


}
