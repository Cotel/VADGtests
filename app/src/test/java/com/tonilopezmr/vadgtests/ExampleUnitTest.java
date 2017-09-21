package com.tonilopezmr.vadgtests;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleUnitTest {
  @Test
  public void addition_isCorrect() throws Exception {
    assertEquals(4, 2 + 2);
    assertThat(4, is(2 + 2));
  }










  class SystemUnderTest {

    public int sum(int a, int b) {
      return a + b;
    }

    public int mult(int a, int b) {
      return a * b;
    }

  }

}