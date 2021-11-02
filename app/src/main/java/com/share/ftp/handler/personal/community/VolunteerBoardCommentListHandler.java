package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerBoardCommentListHandler implements Command {

  VolunteerBoardCommentDao volunteerBoardCommentDao;
  VolunteerBoardDao volunteerBoardDao;

  public VolunteerBoardCommentListHandler (
      VolunteerBoardCommentDao volunteerBoardCommentDao,
      VolunteerBoardDao volunteerBoardDao) {
    this.volunteerBoardCommentDao = volunteerBoardCommentDao;
    this.volunteerBoardDao=volunteerBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[  나눔이야기 댓글 목록  ]");

    //    int no = (int)request.getAttribute("no");
    //
    //    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

    Collection<VolunteerBoardCommentDTO> List = volunteerBoardCommentDao.findAll();
    for(VolunteerBoardCommentDTO volunteerBoardCommentDTO: List) {
      //        if (volunteerBoardCommentDTO.getVolBoardNo() == no) {
      System.out.printf("%d, %d, %s, %s, %s\n", 
          volunteerBoardCommentDTO.getVolBoardNo().getNo(),
          volunteerBoardCommentDTO.getCommentNo(), 
          volunteerBoardCommentDTO.getOwner().getId(),
          volunteerBoardCommentDTO.getCommentContent(),
          volunteerBoardCommentDTO.getRegisteredDate());
    }

    while (true) {
      System.out.println();
      System.out.println("1번 ▶ 댓글 등록");
      System.out.println("2번 ▶ 댓글 변경, 삭제");
      System.out.println("0번 ▶ 이전");
      int input = Prompt.inputInt("번호 입력 ▶ ");
      switch (input) {

        case 1: request.getRequestDispatcher("/volunteerBoardComment/add").forward(request); return;
        case 2: request.getRequestDispatcher("/volunteerBoardComment/connect").forward(request); return;
        case 0: return;
        default:
          System.out.println("명령어가 올바르지 않습니다!");
      }

    } 
  } 
}
