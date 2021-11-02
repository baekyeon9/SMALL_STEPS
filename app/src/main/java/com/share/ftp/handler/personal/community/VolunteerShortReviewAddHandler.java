package com.share.ftp.handler.personal.community;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerShortReviewAddHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;
  VolunteerDao volunteerDao;

  public VolunteerShortReviewAddHandler(
      VolunteerShortReviewDao volunteerShortReviewDao,
      SqlSession sqlSession, 
      VolunteerDao volunteerDao) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
    this.volunteerDao = volunteerDao;
  }
  @Override
  public void execute(CommandRequest request) throws Exception {

    List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();

    if (volunteerList.isEmpty()) {
      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
      return;
    }

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s \n", 
          volunteerRequestDTO.getNo(),      
          volunteerRequestDTO.getTitle(),     
          volunteerRequestDTO.getOwner().getId(), 
          volunteerRequestDTO.getCategory().getTitle(), 
          volunteerRequestDTO.getTel(),
          volunteerRequestDTO.getEmail(),
          volunteerRequestDTO.getStartDate(),
          volunteerRequestDTO.getEndDate(),
          volunteerRequestDTO.getStartTime(),
          volunteerRequestDTO.getEndTime(),
          volunteerRequestDTO.getLimitNum(),
          volunteerRequestDTO.getContent() 
          );
    }

    int volNo = Prompt.inputInt("등록하고자하는 봉사 번호를 입력해주세요 (이전: 0) ▶ ");

    System.out.println("[  한줄후기 등록  ]");

    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByVolunteerNo(volNo);

    //    if (!volunteerRequestDTO.getMemberNames().contains(AuthLoginHandler.getLoginUser().getId()) ) {
    //      System.out.println("봉사 참여한 회원만 등록이 가능합니다!");
    //      return;
    //    }

    //    if (volunteerShortReviewDTO.getReviewerNames().contains(AuthLoginHandler.getLoginUser().getId())) {
    //      System.out.println("리뷰는 한 번만 작성할 수 있습니다!");
    //      return;
    //    }

    VolunteerShortReviewDTO volunteerShortReviewDTO = new VolunteerShortReviewDTO();
    volunteerShortReviewDTO.setVolNo(volunteerRequestDTO);
    volunteerShortReviewDTO.setContent(Prompt.inputString("내용  ▶ "));
    volunteerShortReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    volunteerShortReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    volunteerShortReviewDTO.addReviewer(AuthLoginHandler.getLoginUser());
    System.out.println(volunteerShortReviewDTO.getReviewerNames());

    volunteerShortReviewDao.insert(volunteerShortReviewDTO);
    sqlSession.commit();

    System.out.println();
    System.out.println("[  후기가 등록 되었습니다. ]");
  }
}











