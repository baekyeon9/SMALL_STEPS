package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
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

    Collection<VolunteerRequestDTO> volunteerRequestDTOList = volunteerShortReviewDao.findAll();

    for (VolunteerRequestDTO volunteerRequestDTO : volunteerRequestDTOList) {
      System.out.printf("%d, %d, %s, %s, %s\n", 
          volunteerRequestDTO.getNo(),
          volunteerRequestDTO.getShortReviewNo(), 
          volunteerRequestDTO.getShortReviewOwner().getId(), 
          volunteerRequestDTO.getShortReviewContent(),
          volunteerRequestDTO.getRegisteredDate());
    }

    System.out.println();

    int shortReviewNo = Prompt.inputInt("변경, 삭제하고자 하는 후기 번호를 입력해주세요 (이전: 0) ▶ ");

    VolunteerRequestDTO volunteerRequestDTO = volunteerShortReviewDao.findByNo(shortReviewNo);

    if (volunteerRequestDTO == null) {
      System.out.println("해당 번호의 후기가 없습니다.");
      return;
    }

    if ((volunteerRequestDTO.getShortReviewOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
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

