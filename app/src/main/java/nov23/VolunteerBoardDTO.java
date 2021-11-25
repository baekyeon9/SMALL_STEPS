package com.share.ftp.domain.community;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.share.ftp.domain.join.JoinDTO;

public class VolunteerBoardDTO  {

  private int no;
  private int userNo;
  private int replyCount;
  private String title;
  private String id;
  private String content;
  private String password;
  private String photo;
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
        + ", photo=" + photo + ", registeredDate=" + registeredDate + ", viewCount=" + viewCount
        + ", owner=" + owner + ", like=" + like + ", fileUpload=" + fileUpload + ", rank=" + rank
        + ", bestRank=" + bestRank + ", commentList=" + commentList + ", likeMembers=" + likeMembers
        + "]";
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
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

  public String getLikeMemberNames() {
    if (likeMembers == null) {
      return "";
    }
    StringBuilder names = new StringBuilder();
    for (JoinDTO joinDTO : likeMembers) {
      if (names.length() > 0) {
        names.append("\n");
      }
      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
    }
    return names.toString();
  }

  //  public String getFileNames() {
  //    if (likeMembers == null) {
  //      return "";
  //    }
  //    StringBuilder names = new StringBuilder();
  //    for (VolunteerBoardAttatchedFile joinDTO : likeMembers) {
  //      if (names.length() > 0) {
  //        names.append("\n");
  //      }
  //      names.append(joinDTO.getId()).append("("+joinDTO.getName()+")");
  //    }
  //    return names.toString();
  //  }

}
