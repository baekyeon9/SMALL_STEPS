package com.share.ftp;

import java.util.List;
import com.share.ftp.domain.community.VolBoardDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolBoardDao {

  // 나눔이야기 게시글
  void insert(VolBoardDTO volBoardDTO) throws Exception;
  List<VolBoardDTO> findAll() throws Exception;
  List<VolBoardDTO> findByKeyword(String keyword) throws Exception;
  VolBoardDTO findByNo(int no) throws Exception;
  void updateCount(int no) throws Exception;
  void update(VolBoardDTO volBoardDTO) throws Exception;
  void delete(VolBoardDTO volBoardDTO) throws Exception;
  //  void like(VolBoardDTO volBoardDTO) throws Exception;

}
