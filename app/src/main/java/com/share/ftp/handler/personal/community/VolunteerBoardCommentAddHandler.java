package com.share.ftp.handler.personal.community;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardCommentAddHandler implements Command {

  VolunteerBoardCommentDao volunteerBoardCommentDao;
  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardCommentAddHandler(
      VolunteerBoardCommentDao volunteerBoardCommentDao,
      VolunteerBoardDao volunteerBoardDao,
      SqlSession sqlSession) {
    this.volunteerBoardCommentDao = volunteerBoardCommentDao;
    this.volunteerBoardDao = volunteerBoardDao;
    this.sqlSession =sqlSession;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[  나눔이야기 댓글 등록  ]");

    int no = (int)request.getAttribute("no");
    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

    VolunteerBoardCommentDTO volunteerBoardCommentDTO = new VolunteerBoardCommentDTO();

    volunteerBoardCommentDTO.setVolBoardNo(volunteerBoardDTO.getNo());
    volunteerBoardCommentDTO.setCommentContent(Prompt.inputString("내용  ▶ "));
    volunteerBoardCommentDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    volunteerBoardCommentDTO.setOwner(AuthLoginHandler.getLoginUser());

    String input = Prompt.inputString("해당 게시글에 댓글 등록을 하시겠습니까? (y/N) ");
    if (!input.equals("y") || input.length() == 0) {
      System.out.println();
      System.out.println("댓글 등록이 취소되었습니다.");
      return;
    }
    volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
    sqlSession.commit();

    System.out.println("[  후기가 등록 되었습니다. ]");
  }
}





//@Override
//public void execute(CommandRequest request) throws Exception {
//
////  Collection<VolunteerBoardDTO> volunteerBoardDTOList = volunteerBoardDao.findAll();
////
////  if (volunteerBoardDTOList.isEmpty()) {
////    System.out.println("게시글이 없습니다.");
////    System.out.println();
////  }
////
////  for(VolunteerBoardDTO volunteerBoardDTO : volunteerBoardDTOList) {
////
////    System.out.printf("%d, %s, %s, %s, %d\n", 
////        volunteerBoardDTO.getNo(), 
////        volunteerBoardDTO.getOwner().getId(),
////        volunteerBoardDTO.getTitle(), 
////        volunteerBoardDTO.getRegisteredDate(), 
////        volunteerBoardDTO.getViewCount()
////        );
////    for (VolunteerBoardAttachedFile file : volunteerBoardDTO.getFileUpload()) {
////      System.out.printf("%s\n", file.getFilepath());
////    }
////  }
////
//  int volBoardNo = Prompt.inputInt("등록하고자하는 게시글 번호를 입력해주세요 (이전: 0) ▶ ");
//
//  System.out.println("[  나눔이야기 댓글 등록  ]");
//
//  VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
//
//  VolunteerBoardCommentDTO volunteerBoardCommentDTO = new VolunteerBoardCommentDTO();
//
//  volunteerBoardCommentDTO.setVolBoardNo(volunteerBoardDTO);
//  volunteerBoardCommentDTO.setCommentContent(Prompt.inputString("내용  ▶ "));
//  volunteerBoardCommentDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
//  volunteerBoardCommentDTO.setOwner(AuthLoginHandler.getLoginUser());
//
//  volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
//  sqlSession.commit();
//
//  System.out.println();
//  System.out.println("[  후기가 등록 되었습니다. ]");
//}
//}
