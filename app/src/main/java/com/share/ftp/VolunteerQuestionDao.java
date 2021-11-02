package com.share.ftp;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;

// 역할
// - 봉사 문의사항를 처리하는 객체 사용법을 정의한다.
public interface VolunteerQuestionDao {

  void insert(VolunteerQuestionDTO addVolQuestionDTO) throws Exception;
  List<VolunteerQuestionDTO> findAll() throws Exception;      
  void update(VolunteerQuestionDTO updateVolQuestion) throws Exception;          
  void delete(VolunteerQuestionDTO VolQuestion) throws Exception; 

  VolunteerQuestionDTO getQnaCount(int volunteerNo) throws Exception; 

  VolunteerQuestionDTO findByVolQuestionNo(int volNo, int volQuestionNo) throws Exception;
}
