package com.tonilopezmr.vadgtests.katas;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RandomPrinterTest {

  private RandomPrinter testedClass = new RandomPrinter();

  @Test
  public void generate_number_is_between_0_and_100() {
    int[] numbers = IntStream.range(1, 100).toArray();

    for (int i = 0; i < 1000; i++) {
      int generatedNumber = testedClass.generateRandomBetween0And100();
      numbers = Arrays.stream(numbers).filter(it -> it != generatedNumber).toArray();
    }

    assertThat(numbers.length, is(0));
  }


  @Test
  public void isEvenNumber() throws Exception {
    int evenNumber = 2;
    int oddNumber = 3;

    assertTrue(testedClass.isEvenNumber(evenNumber));
    assertFalse(testedClass.isEvenNumber(oddNumber));
  }

  @Test
  public void getAndroidOrVadgForNumber() throws Exception {
    int evenNumber = 2;
    int oddNumber = 3;

    assertThat(testedClass.getAndroidOrVadgForNumber(evenNumber), is("VADG"));
    assertThat(testedClass.getAndroidOrVadgForNumber(oddNumber), is("ANDROID"));
  }

}