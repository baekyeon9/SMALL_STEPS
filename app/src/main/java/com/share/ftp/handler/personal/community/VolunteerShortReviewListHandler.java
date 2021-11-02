package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerShortReviewListHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;

  public VolunteerShortReviewListHandler(VolunteerShortReviewDao volunteerShortReviewDao) {
    this.volunteerShortReviewDao = volunteerShortReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  한줄후기 목록  ]");
    System.out.println();

    JoinDTO loginUser = AuthLoginHandler.getLoginUser();
    Collection<VolunteerShortReviewDTO> volunteerShortReviewDTOList = volunteerShortReviewDao.findAll();

    for (VolunteerShortReviewDTO volunteerShortReviewDTO : volunteerShortReviewDTOList) {
      System.out.printf("%d, %d, %s, %s, %s\n", 
          volunteerShortReviewDTO.getNo(),
          volunteerShortReviewDTO.getVolNo().getNo(), 
          volunteerShortReviewDTO.getOwner().getId(), 
          volunteerShortReviewDTO.getContent(),
          volunteerShortReviewDTO.getRegisteredDate());
    }

    System.out.println();

    int shortReviewNo = Prompt.inputInt("변경, 삭제하고자 하는 후기 번호를 입력해주세요 (이전: 0) ▶ ");

    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(shortReviewNo);

    if (volunteerShortReviewDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    if (loginUser == null) {
      System.out.println("로그인 후 이용해주세요.");
      return;
    }

    if ((volunteerShortReviewDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("권한이 없습니다.");
      return;
    }

    request.setAttribute("shortReviewNo", shortReviewNo);

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 후기 변경");
      System.out.println("2번 ▶ 후기 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {
        case 1: request.getRequestDispatcher("/volunteerShortReview/update").forward(request); return;
        case 2: request.getRequestDispatcher("/volunteerShortReview/delete").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }
    }
  }
}

