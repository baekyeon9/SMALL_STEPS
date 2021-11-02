package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerShortReviewDeleteHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;
  SqlSession sqlSession;

  public VolunteerShortReviewDeleteHandler(VolunteerShortReviewDao volunteerShortReviewDao, SqlSession sqlSession) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
    this.sqlSession=sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한 줄 후기 삭제  ]");

    int shortReviewNo = (int) request.getAttribute("shortReviewNo");
    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(shortReviewNo);

    while (true) {
      String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  한 줄 후기 삭제를 취소하였습니다.  ]");
        return;

      } else if (input.equalsIgnoreCase("y")) {

        volunteerShortReviewDao.delete(shortReviewNo);
        System.out.println("[  한 줄 후기가 삭제 되었습니다. ]");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      }
    }
  }
}














