package com.share.ftp;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.share.ftp.domain.join.JoinDTO;

@SuppressWarnings("serial")
public class VolBoardDTO implements Serializable {

  private int no;
  private int replyCount;
  private String title;
  private String id;
  private String content;
  private String fileUpload;
  private String password;
  private Date registeredDate;
  private JoinDTO owner;
  private int like;
  private int viewCount;
  private int rank;
  private int bestRank; // 게시글 랭킹

  private List<VolBoardCommentDTO> commentList;
  private List<JoinDTO> likeMembers = new ArrayList<>();

  @Override
  public String toString() {
    return "CommBoardDTO [no=" + no + ", replyCount=" + replyCount + ", title=" + title
        + ", id=" + id + ", content=" + content + ", fileUpload=" + fileUpload + ", password="
        + password + ", registeredDate=" + registeredDate + ", owner=" + owner + ", like=" + like
        + ", viewCount=" + viewCount + ", rank=" + rank + ", bestRank=" + bestRank
        + ", commentList=" + commentList + ", likeMembers=" + likeMembers + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(bestRank, no, commentList, content, fileUpload, id, like, likeMembers,
        owner, password, rank, registeredDate, replyCount, title, viewCount);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    VolBoardDTO other = (VolBoardDTO) obj;
    return bestRank == other.bestRank && no == other.no
        && Objects.equals(commentList, other.commentList) && Objects.equals(content, other.content)
        && Objects.equals(fileUpload, other.fileUpload) && Objects.equals(id, other.id)
        && like == other.like && Objects.equals(likeMembers, other.likeMembers)
        && Objects.equals(owner, other.owner) && Objects.equals(password, other.password)
        && rank == other.rank && Objects.equals(registeredDate, other.registeredDate)
        && replyCount == other.replyCount && Objects.equals(title, other.title)
        && viewCount == other.viewCount;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
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
  public int getLike() {
    return like;
  }
  public void setLike(int like) {
    this.like = like;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
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
  public List<VolBoardCommentDTO> getCommentList() {
    return commentList;
  }
  public void setCommentList(List<VolBoardCommentDTO> commentList) {
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

