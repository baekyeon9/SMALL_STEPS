package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardAttachedFile;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardDetailHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardDetailHandler (VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao = volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while(true) {
      System.out.println();
      System.out.println("[  나눔이야기/ 상세보기  ]");

      System.out.println();
      int no = Prompt.inputInt("게시글 번호를 입력해주세요 ▶ ");

      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

      if (volunteerBoardDTO == null) {
        System.out.println("[  해당 게시글이 없습니다.  ]");
        return;
      }


      System.out.printf("번호 ▶ %s\n", volunteerBoardDTO.getNo());
      System.out.printf("아이디 ▶ %s\n", volunteerBoardDTO.getOwner().getId());
      System.out.printf("제목 ▶ %s\n", volunteerBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", volunteerBoardDTO.getContent());

      volunteerBoardDTO.setViewCount(volunteerBoardDTO.getViewCount() + 1);
      System.out.printf("조회수 ▶ %d\n", volunteerBoardDTO.getViewCount());
      //      System.out.printf("좋아요♡  %d\n", volunteerBoardDTO.getLike());

      for (VolunteerBoardAttachedFile file : volunteerBoardDTO.getFileUpload()) {
        System.out.printf("%s\n", file.getFilepath());
      }

      volunteerBoardDao.updateCount(no);
      sqlSession.commit();

      JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 

      if (loginUser == null) {
        System.out.println("로그인 해주세요.");
        return;
      }


      // if (volunteerBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {

      if ((volunteerBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
          AuthLoginHandler.getLoginUser().getId().equals("admin")) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("변경(U), 삭제(D), 댓글(R), 이전(0)>");
          switch (input) {
            case "U":
            case "u":
              request.getRequestDispatcher("/volunteerBoard/update").forward(request);
              return;
            case "D":
            case "d":
              request.getRequestDispatcher("/volunteerBoard/delete").forward(request);
              return;
            case "R":
            case "r":
              request.getRequestDispatcher("/volunteerBoardComment/list").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      } 

      if (loginUser!= null) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("좋아요(L), 댓글(R), 이전(0)>");
          switch (input) {
            case "L":
            case "l":
              request.getRequestDispatcher("/volunteerBoard/like").forward(request);
              return;
            case "R":
            case "r":
              request.getRequestDispatcher("/volunteerBoardComment/list").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 


      }
    }
  }
}

