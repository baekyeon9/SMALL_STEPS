package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardDeleteHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardDeleteHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    try {

      System.out.println();
      System.out.println("[  나눔이야기 게시글 삭제  ]");

      int no = (int) request.getAttribute("no");

      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);


      if (volunteerBoardDTO == null) {
        System.out.println("[ 해당 게시글이 없습니다.  ]");
        return;
      }

      if ((volunteerBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {
      } else {
        System.out.println("삭제 권한이 없습니다.");
        return;
      }

      String input = Prompt.inputString("[  정말 삭제하시겠습니까?(y/N)  ]");
      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  게시글 삭제를 취소하였습니다.  ]");
        return;
      } 

      volunteerBoardDao.deleteFile(volunteerBoardDTO);
      volunteerBoardDao.delete(no);
      sqlSession.commit();

      System.out.println();
      System.out.println("[  게시글을 삭제하였습니다. ]");

    } catch (Throwable e) {

    }
  }
}



