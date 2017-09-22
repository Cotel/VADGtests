package com.tonilopezmr.vadgtests.members;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class VADGMembersRepositoryTest {

  @Test
  public void test_get_members_returns_objects_from_api() {
    VADGMembersRepository repo = new VADGMembersRepository(new StubRetrofitApi());

    List<VADGMember> members = repo.getMembers();

    assertEquals(members.size(), 1);
    assertThat(members.get(0), is(StubRetrofitApi.generateDummyMemeber()));
  }

  @Test
  public void test_if_member_added_to_api_lenght_increments() {
    StubRetrofitApi api = new StubRetrofitApi();
    VADGMembersRepository repo = new VADGMembersRepository(api);

    repo.add(StubRetrofitApi.generateDummyMemeber());

    assertThat(api.database.size(), is(2)); // Because we start with one member
  }

  @Test
  public void test_if_member_added_cache_length_is_1() {
    StubRetrofitApi api = new StubRetrofitApi();
    VADGMembersRepository repo = new VADGMembersRepository(api);

    repo.add(StubRetrofitApi.generateDummyMemeber());
    List<VADGMember> membersFromCache = repo.getMembersFromCache();

    assertThat(membersFromCache.size(), is(1));
    assertThat(membersFromCache.get(0), is(StubRetrofitApi.generateDummyMemeber()));
  }



}



class StubRetrofitApi extends RetrofitApi {

  static VADGMember generateDummyMemeber() {
    return new VADGMember("Name");
  }

  public ArrayList<VADGMember> database;

  StubRetrofitApi() {
    this.database = new ArrayList<>();
    this.database.add(generateDummyMemeber());
  }

  @Override
  public List<VADGMember> getMembers() throws InterruptedException {
    return this.database;
  }

  @Override
  public void add(VADGMember vadgMember) throws InterruptedException {
    this.database.add(vadgMember);
  }
}

