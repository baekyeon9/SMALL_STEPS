package com.share.ftp.domain.community;

public class VolunteerBoardLike {

  private int userNo;
  private String volNo;

  @Override
  public String toString() {
    return "VolunteerBoardLike [userNo=" + userNo + ", volNo=" + volNo + "]";
  }

  public int getUserNo() {
    return userNo;
  }

  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }

  public String getVolNo() {
    return volNo;
  }

  public void setVolNo(String volNo) {
    this.volNo = volNo;
  }

}

