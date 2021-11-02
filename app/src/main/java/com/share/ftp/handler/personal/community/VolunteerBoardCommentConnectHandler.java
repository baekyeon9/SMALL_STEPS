package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardCommentConnectHandler implements Command {

  VolunteerBoardCommentDao volunteerBoardCommentDao;


  public VolunteerBoardCommentConnectHandler (VolunteerBoardCommentDao volunteerBoardCommentDao) {
    this.volunteerBoardCommentDao = volunteerBoardCommentDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 댓글 변경 / 삭제]");

    int no = (int) request.getAttribute("no");
    int commentNo = Prompt.inputInt("댓글 번호를 입력해주세요 ▶ ");

    VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByCommBoardReplyNo(commBoardNo, commBoardReplyNo);

    if (volunteerBoardCommentDTO == null) {
      System.out.println("해당 번호의 댓글이 없습니다.");
      return;
    }

    if ((volunteerBoardCommentDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {

      System.out.printf("아이디: %s\n", volunteerBoardCommentDTO.getOwner().getId());
      System.out.printf("내용: %s\n", volunteerBoardCommentDTO.getCommentContent());
      System.out.printf("등록날짜: %s\n", volunteerBoardCommentDTO.getRegisteredDate());

    } else {
      System.out.println("본인이 작성한 글만 변경할 수 있습니다.");
      return;
    }

    System.out.println();

    request.setAttribute("commentNo", commentNo); 

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 댓글 변경");
      System.out.println("2번 ▶ 댓글 삭제");
      System.out.println("0번: 이전");
      System.out.println();
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/volunteerBoardComment/update").forward(request); break;
        case 2: request.getRequestDispatcher("/volunteerBoardComment/delete").forward(request); break;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}