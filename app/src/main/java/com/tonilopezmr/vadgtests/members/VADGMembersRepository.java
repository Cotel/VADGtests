package com.tonilopezmr.vadgtests.members;

import java.util.ArrayList;
import java.util.List;

public class VADGMembersRepository {

  private RetrofitApi api;
  private ArrayList<VADGMember> membersCache;
  private long lastCacheTime;

  public VADGMembersRepository(RetrofitApi api) {
    membersCache = new ArrayList<>();
    api = api;
  }

  public List<VADGMember> getMembers() {
    if (isExpired()) {
      try {
        persistTime();
        List<VADGMember> members = api.getMembers();
        addToCache(members);
        return members;
      } catch (InterruptedException e) {
        e.printStackTrace();
        return membersCache;
      }
    } else {
      return membersCache;
    }
  }

  private void addToCache(List<VADGMember> members) {
    membersCache.clear();
    membersCache.addAll(members);
  }

  public void add(VADGMember vadgMember) {
    try {
      api.add(vadgMember);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    membersCache.add(vadgMember);
  }

  private void persistTime() {
    lastCacheTime = System.currentTimeMillis();
  }

  private boolean isExpired() {
    return (lastCacheTime + 120000) < System.currentTimeMillis(); //2 minutes cache
  }
}
