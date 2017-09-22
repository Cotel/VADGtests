package com.tonilopezmr.vadgtests.members;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class VADGMembersRepositoryTest {

  @Test
  public void test_get_members() {
    VADGMembersRepository repo = new VADGMembersRepository(new StubRetrofitApi());

    List<VADGMember> members = repo.getMembers();

    assertEquals(members, 1);
    assertThat(members.get(0), is(StubRetrofitApi.generateDummyMemeber()));
  }



}


class StubRetrofitApi extends RetrofitApi {

  static VADGMember generateDummyMemeber() {
    return new VADGMember("Name");
  }

  @Override
  public List<VADGMember> getMembers() throws InterruptedException {
    return Arrays.asList(generateDummyMemeber());
  }
}

