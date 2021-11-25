package com.share.ftp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;

//역할
//- happyshare 나눔이야기(게시글 댓글)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerBoardCommentDao {

  // 나눔이야기 게시판 댓글 
  void insert(VolunteerBoardCommentDTO volunteerBoardCommentDTO) throws Exception;
  List<VolunteerBoardCommentDTO> findAll() throws Exception;
  List<VolunteerBoardCommentDTO> findAllNo(int volBoardNo) throws Exception; 
  List<VolunteerBoardCommentDTO> findByKeyword(String keyword) throws Exception;
  void update(VolunteerBoardCommentDTO volunteerBoardCommentDTO) throws Exception;
  void delete(int commentNo) throws Exception;

  VolunteerBoardCommentDTO findByCommentNo(
      @Param("volBoardNo")int volBoardNo,
      @Param("commentNo") int commentNo) throws Exception;

  VolunteerBoardCommentDTO findByNo (int commentNo) throws Exception;
}