package com.share.ftp.handler.personal.community;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommReviewAddHandler extends AbstractCommReviewHandler {


  public CommReviewAddHandler(List<CommReviewDTO> commReviewDTOList) {
    super(commReviewDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  소통해요/ 한줄후기/ 등록  ]");

    CommReviewDTO commReviewDTO = new CommReviewDTO();

    commReviewDTO.setCommReviewNo(getNextNum());
    commReviewDTO.setContent(Prompt.inputString("내용  ▶ "));
    commReviewDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commReviewDTO.setOwner(AuthLoginHandler.getLoginUser());

    commReviewDTOList.add(commReviewDTO);

    System.out.println();
    System.out.println("[  ✔️ 후기가 등록 되었습니다. ]");
  }
}










