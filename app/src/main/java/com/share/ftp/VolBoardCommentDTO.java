package com.share.ftp;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class VolBoardCommentDTO implements Serializable {

  private int no;
  private int replyNo;
  private String Commentid;
  private String Commentcontent;
  private Date registeredDate;
  private JoinDTO owner;
  private int commReplyPassword;


  @Override
  public String toString() {
    return "CommBoardReplyDTO [no=" + no + ", replyNo=" + replyNo + ", Commentid=" + Commentid
        + ", Commentcontent=" + Commentcontent + ", registeredDate=" + registeredDate + ", owner="
        + owner + ", commReplyPassword=" + commReplyPassword + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(Commentcontent, Commentid, commReplyPassword, no, owner, registeredDate,
        replyNo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VolBoardCommentDTO other = (VolBoardCommentDTO) obj;
    return Objects.equals(Commentcontent, other.Commentcontent)
        && Objects.equals(Commentid, other.Commentid)
        && commReplyPassword == other.commReplyPassword && no == other.no
        && Objects.equals(owner, other.owner)
        && Objects.equals(registeredDate, other.registeredDate) && replyNo == other.replyNo;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getReplyNo() {
    return replyNo;
  }
  public void setReplyNo(int replyNo) {
    this.replyNo = replyNo;
  }
  public String getCommentid() {
    return Commentid;
  }
  public void setCommentid(String commentid) {
    Commentid = commentid;
  }
  public String getCommentcontent() {
    return Commentcontent;
  }
  public void setCommentcontent(String commentcontent) {
    Commentcontent = commentcontent;
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
  public int getCommReplyPassword() {
    return commReplyPassword;
  }
  public void setCommReplyPassword(int commReplyPassword) {
    this.commReplyPassword = commReplyPassword;
  }
}