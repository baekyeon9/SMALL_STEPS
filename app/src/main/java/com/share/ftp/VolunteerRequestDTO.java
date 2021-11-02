package com.share.ftp;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;


public class VolunteerRequestDTO implements Serializable {

  private static final long serialVersionUID = 1L;
  private int no;
  private int userNo;
  private int memberType; 
  private Category category;
  private String title;
  private String content;
  private String tel;
  private String email;
  private Date startDate;
  private Date endDate;
  private String startTime;
  private String endTime;
  private String totalDate;
  private String remainDate;
  private int currentNum = 1; // 현재 참여 인원 (주최자는 미리 포함)
  private int limitNum; // 총 정원
  private String name;
  private int status;
  private JoinDTO owner; 
  private List<VolunteerAttachedFile> fileUpload;
  private Date submitTime; 
  private JoinDTO wish;
  private int questionCount;
  private String note;
  private List<JoinDTO> members = new ArrayList<>(); // 봉사 참여한 멤버들

  private int shortReviewNo;
  private String shortReviewContent;
  private JoinDTO shortReviewOwner;
  private Date registeredDate;



  public String getTotalDate() {
    return totalDate;
  }

  public void setTotalDate(String totalDate) {
    this.totalDate = totalDate;
  }

  public String getRemainDate() {
    return remainDate;
  }

  public void setRemainDate(String remainDate) {
    this.remainDate = remainDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }



  public int getUserNo() {
    return userNo;
  }

  public void setUserNo(int userNo) {
    this.userNo = userNo;
  }

  public int getMemberType() {
    return memberType;
  }

  public void setMemberType(int memberType) {
    this.memberType = memberType;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public JoinDTO getOwner() {
    return owner;
  }

  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }



  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public void setEndTime(String endTime) {
    this.endTime = endTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public List<VolunteerAttachedFile> getFileUpload() {
    return fileUpload;
  }

  public void setFileUpload(List<VolunteerAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }

  public Date getSubmitTime() {
    return submitTime;
  }

  public void setSubmitTime(Date submitTime) {
    this.submitTime = submitTime;
  }

  public JoinDTO getWish() {
    return wish;
  }

  public void setWish(JoinDTO wish) {
    this.wish = wish;
  }

  public int getLimitNum() {
    return limitNum;
  }

  public void setLimitNum(int limitNum) {
    this.limitNum = limitNum;
  }


  public int getCurrentNum() {
    return currentNum;
  }

  public void setCurrentNum(int currentNum) {
    this.currentNum = currentNum;
  }

  public List<JoinDTO> getMembers() {
    return members;
  }

  public void setMembers(List<JoinDTO> members) {
    this.members = members;
  }

  public void addMembers(JoinDTO volMember) {
    this.members.add(volMember);
  }

  public void removeMembers(JoinDTO volMember) {
    this.members.remove(volMember);
  }

  public int getQuestionCount() {
    return questionCount;
  }

  public void setQuestionCount(int questionCount) {
    this.questionCount = questionCount;
  }



  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getMemberNames() {
    if (members == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();


    for (JoinDTO joinDTO : members) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }

  public int getShortReviewNo() {
    return shortReviewNo;
  }

  public void setShortReviewNo(int shortReviewNo) {
    this.shortReviewNo = shortReviewNo;
  }

  public String getShortReviewContent() {
    return shortReviewContent;
  }

  public void setShortReviewContent(String shortReviewContent) {
    this.shortReviewContent = shortReviewContent;
  }

  public JoinDTO getShortReviewOwner() {
    return shortReviewOwner;
  }

  public void setShortReviewOwner(JoinDTO shortReviewOwner) {
    this.shortReviewOwner = shortReviewOwner;
  }

  public Date getRegisteredDate() {
    return registeredDate;
  }

  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }


}