package com.tonilopezmr.vadgtests.members;

public class VADGMember {

  public final String name;

  public VADGMember(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    VADGMember that = (VADGMember) o;

    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }
}
