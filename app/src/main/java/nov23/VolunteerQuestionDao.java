package com.share.ftp.dao;

import java.util.List;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;

public interface VolunteerQuestionDao {

  void insert(VolunteerQuestionDTO addVolunteerQuestion) throws Exception;
  List<VolunteerQuestionDTO> findAll() throws Exception;      
  List<VolunteerQuestionDTO> findAllNo(int volunteerNo) throws Exception;      
  void update(VolunteerQuestionDTO updateVolunteerQuestion) throws Exception;
  void updateReply(VolunteerQuestionDTO updateVolunteerQuestionReply) throws Exception;
  void delete(VolunteerQuestionDTO volunteerQuestionDTO) throws Exception; 
  VolunteerQuestionDTO findByNo(VolunteerQuestionDTO volunteerQuestionDTO) throws Exception;
}
