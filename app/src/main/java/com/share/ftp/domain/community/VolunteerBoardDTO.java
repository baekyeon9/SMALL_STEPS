package com.share.ftp.domain.community;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class VolunteerBoardDTO implements Serializable {

  private int no;
  private int userNo;
  private int replyCount;
  private String title;
  private String id;
  private String content;
  private String password;
  private Date registeredDate;
  private int viewCount;
  private JoinDTO owner;
  private JoinDTO like;
  private  List<VolunteerBoardAttachedFile> fileUpload;
  private int rank;
  private int bestRank; // 게시글 랭킹

  private List<VolunteerBoardCommentDTO> commentList;
  private List<JoinDTO> likeMembers = new ArrayList<>(); // 좋아요 누른 사람들

  @Override
  public String toString() {
    return "VolunteerBoardDTO [no=" + no + ", userNo=" + userNo + ", replyCount=" + replyCount
        + ", title=" + title + ", id=" + id + ", content=" + content + ", password=" + password
        + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount + ", owner=" + owner
        + ", like=" + like + ", fileUpload=" + fileUpload + ", rank=" + rank + ", bestRank="
        + bestRank + ", commentList=" + commentList + ", likeMembers=" + likeMembers + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(bestRank, commentList, content, fileUpload, id, like, likeMembers, no,
        owner, password, rank, registeredDate, replyCount, title, userNo, viewCount);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VolunteerBoardDTO other = (VolunteerBoardDTO) obj;
    return bestRank == other.bestRank && Objects.equals(commentList, other.commentList)
        && Objects.equals(content, other.content) && Objects.equals(fileUpload, other.fileUpload)
        && Objects.equals(id, other.id) && Objects.equals(like, other.like)
        && Objects.equals(likeMembers, other.likeMembers) && no == other.no
        && Objects.equals(owner, other.owner) && Objects.equals(password, other.password)
        && rank == other.rank && Objects.equals(registeredDate, other.registeredDate)
        && replyCount == other.replyCount && Objects.equals(title, other.title)
        && userNo == other.userNo && viewCount == other.viewCount;
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

  public int getReplyCount() {
    return replyCount;
  }

  public void setReplyCount(int replyCount) {
    this.replyCount = replyCount;
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

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public JoinDTO getOwner() {
    return owner;
  }

  public void setOwner(JoinDTO owner) {
    this.owner = owner;
  }

  public JoinDTO getLike() {
    return like;
  }

  public void setLike(JoinDTO like) {
    this.like = like;
  }

  public List<VolunteerBoardAttachedFile> getFileUpload() {
    return fileUpload;
  }

  public void setFileUpload(List<VolunteerBoardAttachedFile> fileUpload) {
    this.fileUpload = fileUpload;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public int getBestRank() {
    return bestRank;
  }

  public void setBestRank(int bestRank) {
    this.bestRank = bestRank;
  }


  public List<VolunteerBoardCommentDTO> getCommentList() {
    return commentList;
  }

  public void setCommentList(List<VolunteerBoardCommentDTO> commentList) {
    this.commentList = commentList;
  }

  public List<JoinDTO> getLikeMembers() {
    return likeMembers;
  }

  public void setLikeMembers(List<JoinDTO> likeMembers) {
    this.likeMembers = likeMembers;
  }

  public void addLikeMember(JoinDTO likeMember) {
    this.likeMembers.add(likeMember);
  }

  public void removeLikeMember(JoinDTO likeMember) {
    this.likeMembers.remove(likeMember);
  }
}

