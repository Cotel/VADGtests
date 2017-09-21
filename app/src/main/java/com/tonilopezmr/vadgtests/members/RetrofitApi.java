package com.tonilopezmr.vadgtests.members;

import java.util.Arrays;
import java.util.List;

public class RetrofitApi {

  public List<VADGMember> getMembers() throws InterruptedException {
    Thread.sleep(1000);
    return Arrays.asList(
        new VADGMember("Kevin"),
        new VADGMember("Carlos"),
        new VADGMember("Miguel"),
        new VADGMember("Conri")
    );
  }

  public void add(VADGMember vadgMember) throws InterruptedException {
    Thread.sleep(1000);
  }

}
