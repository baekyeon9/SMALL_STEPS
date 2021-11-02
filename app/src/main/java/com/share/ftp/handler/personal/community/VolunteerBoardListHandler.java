package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardAttachedFile;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class VolunteerBoardListHandler implements Command {

  VolunteerBoardDao volunteerBoardDao;

  public VolunteerBoardListHandler(VolunteerBoardDao volunteerBoardDao) {
    this.volunteerBoardDao =  volunteerBoardDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/목록  ]");
    System.out.println();

    Collection<VolunteerBoardDTO> volunteerBoardDTOList = volunteerBoardDao.findAll();

    if (volunteerBoardDTOList.isEmpty()) {
      System.out.println("게시글이 없습니다.");
      System.out.println();
    }

    System.out.println("[ 게시글 목록 ]");

    for(VolunteerBoardDTO volunteerBoardDTO : volunteerBoardDTOList) {

      System.out.printf("%d, %s, %s, %s, %d\n", 
          volunteerBoardDTO.getNo(), 
          volunteerBoardDTO.getOwner().getId(),
          volunteerBoardDTO.getTitle(), 
          volunteerBoardDTO.getRegisteredDate(), 
          volunteerBoardDTO.getViewCount());
      //          volunteerBoardDTO.getLike(),

      for (VolunteerBoardAttachedFile file : volunteerBoardDTO.getFileUpload()) {
        System.out.printf("%s\n", file.getFilepath());
      }
    }
    System.out.println();

  }
}




