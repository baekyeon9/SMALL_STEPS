package com.share.ftp;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class CommBoardDTO implements Serializable {
  private int no;
  private String title;
  private String id;
  private String content;
  private String fileUpload;
  private String password;
  private Date registeredDate;
  private JoinDTO owner;
  private int viewCount;


  @Override
  public String toString() {
    return "CommBoardDTO [no=" + no + ", title=" + title + ", id=" + id + ", content=" + content
        + ", fileUpload=" + fileUpload + ", password=" + password + ", registeredDate="
        + registeredDate + ", owner=" + owner + ", viewCount=" + viewCount + "]";
  }
  @Override
  public int hashCode() {
    return Objects.hash(content, fileUpload, id, no, owner, password, registeredDate, title,
        viewCount);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommBoardDTO other = (CommBoardDTO) obj;
    return Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(id, other.id) && no == other.no && Objects.equals(owner, other.owner)
        && Objects.equals(password, other.password)
        && Objects.equals(registeredDate, other.registeredDate)
        && Objects.equals(title, other.title) && viewCount == other.viewCount;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getFileUpload() {
    return fileUpload;
  }
  public void setFileUpload(String fileUpload) {
    this.fileUpload = fileUpload;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
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
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
}