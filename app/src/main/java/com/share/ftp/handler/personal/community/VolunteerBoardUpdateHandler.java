package com.share.ftp.handler.personal.community;

import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardAttachedFile;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class VolunteerBoardUpdateHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardUpdateHandler (VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[  나눔이야기 게시글변경  ]");

    int no = (int) request.getAttribute("no");

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);

    if (volunteerBoardDTO == null) {
      System.out.println("[  해당 게시글이 없습니다.  ]");
      return;
    }

    if ((volunteerBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("변경권한이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", volunteerBoardDTO.getTitle()));
    String content = Prompt.inputString(String.format("내용(%s)? ", volunteerBoardDTO.getContent()));
    //    String fileUpload = Prompt.inputString(String.format("첨부파일(%s)? ", volunteerBoardDTO.getFileUpload()));
    volunteerBoardDTO.setFileUpload(GeneralHelper.promptBoardFileUpload());

    String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");
    if (input.equalsIgnoreCase("n")) {
      System.out.println("[  변경을 취소하였습니다.  ]");
      return;
    }
    try {

      volunteerBoardDTO.setTitle(title);
      volunteerBoardDTO.setContent(content);

      volunteerBoardDao.update(volunteerBoardDTO);
      volunteerBoardDao.deleteFile(volunteerBoardDTO);

      for (VolunteerBoardAttachedFile volunteerBoardAttachedFile : volunteerBoardDTO.getFileUpload()) {
        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerBoardAttachedFile.getFilepath());
      }
      sqlSession.commit();
    } catch (Exception e) {
      e.printStackTrace();

      sqlSession.rollback();
    }
    System.out.println("[  게시글을 변경하였습니다.  ]");
  }

}





