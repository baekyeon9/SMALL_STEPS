package com.share.ftp;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.share.ftp.domain.community.VolunteerBoardDTO;

//역할
//- 봉사 게시판의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerBoardDao {

  void insert(VolunteerBoardDTO volunteerBoardDTO) throws Exception;
  void insertFile(
      @Param("volBoardNo") int volBoardNo,
      @Param("filepath") String filepath) throws Exception; 
  List<VolunteerBoardDTO> findAll() throws Exception;
  List<VolunteerBoardDTO> findByKeyword(String keyword) throws Exception;
  VolunteerBoardDTO findByNo(int no) throws Exception;
  void updateCount(int no) throws Exception;
  void update(VolunteerBoardDTO volunteerBoardDTO) throws Exception;
  void delete(int no) throws Exception;
  void deleteFile(VolunteerBoardDTO volunteerBoardDTO) throws Exception;    
  void addLike(
      @Param("userNo") int userNo,
      @Param("volBoardNo") int volNo) throws Exception;      

}