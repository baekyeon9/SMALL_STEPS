package com.share.ftp;

import java.util.List;
import com.share.ftp.domain.community.VolShortReviewDTO;

//역할
//- happyshare 나눔이야기(후기게시판)의 데이터를 처리하는 객체 사용법을 정의한다.

public interface VolShortReviewDao {

  // 한 줄 후기 
  void insert(VolShortReviewDTO addcommReview) throws Exception;
  List<VolShortReviewDTO> findAll() throws Exception;
  List<VolShortReviewDTO> findByKeyword(String commReviewkeyword) throws Exception;
  VolShortReviewDTO findByNo(int commReviewNo) throws Exception;
  void update(VolShortReviewDTO updateCommReview) throws Exception;
  void delete(VolShortReviewDTO deleteCommReview) throws Exception;

  // 나눔이야기 BEST



}
