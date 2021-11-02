package com.share.ftp;

import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

// 역할
// - 봉사신청서를 처리하는 객체 사용법을 정의한다.
public interface VolunteerApplyDao {

  void insert(VolunteerRequestDTO addVolunteer) throws Exception;      


  VolunteerRequestDTO getCount(int volunteerNo) throws Exception;

}
