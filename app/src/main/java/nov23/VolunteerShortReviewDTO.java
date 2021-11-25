package com.share.ftp.domain.community;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

public class VolunteerShortReviewDTO {
  private int volNo;
  private int no;
  private String content;
  private JoinDTO owner;
  private Date registeredDate;
  private List<JoinDTO> reviewers = new ArrayList<>();
  private VolunteerRequestDTO volTitle;

  @Override
  public String toString() {
    return "VolunteerShortReviewDTO [volNo=" + volNo + ", no=" + no + ", content=" + content
        + ", owner=" + owner + ", registeredDate=" + registeredDate + ", reviewers=" + reviewers
        + ", title=" + volTitle + "]";
  }

  public int getVolNo() {

    return volNo;
  }

  public void setVolNo(int volNo) {
    this.volNo = volNo;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public JoinDTO getOwner() {
    return owner;
  }

  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

  public List<JoinDTO> getReviewers() {
    return reviewers;
  }

  public void setReviewers(List<JoinDTO> reviewers) {
    this.reviewers = reviewers;
  }

  public VolunteerRequestDTO getVolTitle() {
    return volTitle;
  }

  public void setVolTitle(VolunteerRequestDTO volTitle) {
    this.volTitle = volTitle;
  }

  public String getReviewerNames() {
    if (reviewers == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();
    for (JoinDTO joinDTO : reviewers) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }

  public void addReviewer(JoinDTO reviwer) {
    this.reviewers.add(reviwer);
  }

  public void removeReviewer(JoinDTO reviwer) {
    this.reviewers.remove(reviwer);
  }

}