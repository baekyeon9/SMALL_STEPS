package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;

//역할
//- happyshare 나눔이야기(한 줄 후기)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolunteerShortReviewDao {

  // 한 줄 후기 
  void insert(VolunteerShortReviewDTO volunteerShortReviewDTO) throws Exception;
  List<VolunteerShortReviewDTO> findAll() throws Exception;
  List<VolunteerShortReviewDTO> findByKeyword(String keyword) throws Exception;
  VolunteerShortReviewDTO findByNo(int shortReviewNo) throws Exception;
  void update(VolunteerShortReviewDTO volunteerShortReviewDTO) throws Exception;
  void delete(int shortReviewNo) throws Exception;





}
