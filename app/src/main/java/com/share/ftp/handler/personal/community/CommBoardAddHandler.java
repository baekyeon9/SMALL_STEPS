package com.share.ftp.handler.personal.community;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardAddHandler extends AbstractCommBoardHandler {

  public CommBoardAddHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  메인/소통해요/나눔이야기/등록  ]");

    CommBoardDTO commBoardDTO = new CommBoardDTO();

    commBoardDTO.setTitle(Prompt.inputString("제목 ▶ "));
    commBoardDTO.setContent(Prompt.inputString("내용 ▶ "));
    commBoardDTO.setFileUpload(Prompt.inputString("첨부파일 ▶ "));
    // commBoardDTO.setPassword(Prompt.inputString("비밀번호 ▶ "));
    commBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commBoardDTO.setOwner(AuthLoginHandler.getLoginUser());
    // System.out.println(commNo); 게시글 넘버 확인0

    commBoardDTO.setCommNo(getNextNum());

    commBoardDTOList.add(commBoardDTO);

    System.out.println();
    System.out.println("[  ✔️ 게시글 등록이 완료되었습니다.  ]");
  }

}