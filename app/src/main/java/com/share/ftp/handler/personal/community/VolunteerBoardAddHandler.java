package com.share.ftp.handler.personal.community;

import java.sql.Date;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardAttachedFile;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

public class VolunteerBoardAddHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;
  SqlSession sqlSession;

  public VolunteerBoardAddHandler(VolunteerBoardDao volunteerBoardDao, SqlSession sqlSession) {
    this.volunteerBoardDao =  volunteerBoardDao;
    this.sqlSession = sqlSession;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[  나눔이야기 등록  ]");

    VolunteerBoardDTO volunteerBoardDTO = new VolunteerBoardDTO();

    volunteerBoardDTO.setTitle(Prompt.inputString("제목 ▶ "));
    volunteerBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
    volunteerBoardDTO.setOwner(AuthLoginHandler.getLoginUser());
    volunteerBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    volunteerBoardDTO.setFileUpload(GeneralHelper.promptBoardFileUpload());

    try {
      volunteerBoardDao.insert(volunteerBoardDTO);
      for (VolunteerBoardAttachedFile volunteerBoardAttachedFile : volunteerBoardDTO.getFileUpload()) {
        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerBoardAttachedFile.getFilepath());
      }
      sqlSession.commit();

    }  catch (Exception e) {
      sqlSession.rollback();
    }
    System.out.println("[  게시글 등록이 완료되었습니다.  ]");
  }
}

