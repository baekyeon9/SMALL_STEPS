package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommBoardSearchHandler extends AbstractCommBoardHandler {

  public CommBoardSearchHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    String input = Prompt.inputString("[  검색어를 입력하세요!  ");

    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if(!commBoardDTO.getTitle().contains(input) &&
          !commBoardDTO.getContent().contains(input)) {
        continue;
      }

      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
    }
  }
}
