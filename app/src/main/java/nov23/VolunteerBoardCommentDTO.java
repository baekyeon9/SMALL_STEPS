package com.share.ftp.domain.community;

import java.sql.Date;
import com.share.ftp.domain.join.JoinDTO;

public class VolunteerBoardCommentDTO  {

  private int no;
  private int volBoardNo;
  private String commentContent;
  private Date registeredDate;
  private JoinDTO owner;


  @Override
  public String toString() {
    return "VolunteerBoardCommentDTO [no=" + no + ", volBoardNo=" + volBoardNo + ", commentContent="
        + commentContent + ", registeredDate=" + registeredDate + ", owner=" + owner + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getVolBoardNo() {
    return volBoardNo;
  }
  public void setVolBoardNo(int volBoardNo) {
    this.volBoardNo = volBoardNo;
  }
  public String getCommentContent() {
    return commentContent;
  }
  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public JoinDTO getOwner() {
    return owner;
  }
  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }
}