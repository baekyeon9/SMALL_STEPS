package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerShortReviewUpdateHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;

  public VolunteerShortReviewUpdateHandler(VolunteerShortReviewDao volunteerShortReviewDao, SqlSession sqlSession) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[  한줄후기 변경 ]");

    int shortReviewNo = (int) request.getAttribute("shortReviewNo");

    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(shortReviewNo);

    //    if (volunteerShortReviewDTO == null) {
    //      System.out.println("[  해당 번호의 후기가 없습니다.  ]");
    //      return;
    //    }
    //
    //    if ((volunteerShortReviewDTO.getShortReviewOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
    //        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    //    } else {
    //      System.out.println("권한이 없습니다.");
    //      return;
    //    }

    //    JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 


    //    if (loginUser == null) {
    //      System.out.println("로그인 후 이용해주세요.");
    //      return;
    //    }
    //
    //    if (volunteerShortReviewDTO.getOwner().getNo() != loginUser.getNo() && 
    //        !loginUser.getId().equals("admin")) {
    //      System.out.println("본인이 작성한 글만 수정 가능합니다.");  
    //      return;
    //    }  

    String content = Prompt.inputString(String.format("내용(%s)? ", volunteerShortReviewDTO.getContent()));

    while (true) {
      String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");

      if (input.equalsIgnoreCase("n")|| input.length() == 0) {
        System.out.println("[  변경을 취소하였습니다.  ]");
        return;

      } else if(input.equals("y")) {

        volunteerShortReviewDTO.setContent(content);

        volunteerShortReviewDao.update(volunteerShortReviewDTO);
        sqlSession.commit();

        System.out.println("[  변경 되었습니다. ]");
        return;
      }
    }
  }
}










