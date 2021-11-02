package com.share.ftp;

import java.util.List;
import com.share.ftp.domain.community.VolBoardCommentDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolBoardCommentDao {

  // 나눔이야기 게시판 댓글 
  void insert(VolBoardCommentDTO add) throws Exception;
  List<VolBoardCommentDTO> findAll() throws Exception;
  VolBoardCommentDTO findByNo(int No) throws Exception;
  void update(VolBoardCommentDTO volBoardCommentDTO) throws Exception;
  void delete(VolBoardCommentDTO volBoardCommentDTO) throws Exception;

}
