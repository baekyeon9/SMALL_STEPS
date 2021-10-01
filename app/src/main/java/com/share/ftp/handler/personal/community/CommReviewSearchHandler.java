package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class CommReviewSearchHandler extends AbstractCommReviewHandler {

  public CommReviewSearchHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    String input = Prompt.inputString("[  검색어를 입력하세요.  ]");

    for(CommReviewDTO commReviewDTO : commReviewDTOList) {
      if(!commReviewDTO.getContent().contains(input)) {
        continue;
      }

      System.out.printf("내용 ▶ %s\n", commReviewDTO.getContent());
    }
  }
}











