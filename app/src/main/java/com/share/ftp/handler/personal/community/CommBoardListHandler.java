package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;

public class CommBoardListHandler extends AbstractCommBoardHandler {

  public CommBoardListHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }


  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/목록  ]");
    System.out.println();

    if (commBoardDTOList.isEmpty()) {
      System.out.println("[  작성된 게시글이 없습니다.  ]");
      return;
    }

    System.out.println("------------------------------------------------------------------");
    System.out.println("NO    제목 [댓글수]      작성자     작성일  조회 LIKE    첨부");
    System.out.println("------------------------------------------------------------------");
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {


      System.out.printf("%d, %s[%d], %s, %s, %d, %d, %s\n", 
          // AuthLoginHandler.loginUser.getId(),
          commBoardDTO.getCommNo(), 
          commBoardDTO.getTitle(), 
          commBoardDTO.getReplyCount(),
          commBoardDTO.getOwner().getId(),
          commBoardDTO.getRegisteredDate(), 
          commBoardDTO.getViewCount(),
          commBoardDTO.getLike(),
          commBoardDTO.getFileUpload());
      // commBoardDTO.getContent(),
      //commBoardDTO.getPassword(),
    }
  }
}




