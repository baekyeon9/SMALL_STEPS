package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardLikeHandler extends AbstractCommBoardHandler {

  public CommBoardLikeHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
    while (true) {
      System.out.println("[  ❤ LIKE ❤  ]");
      System.out.println();

      int no = (int) request.getAttribute("no");
      System.out.println();

      CommBoardDTO commBoard = findByNo(no); 



      String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ] ");

      for (CommBoardDTO commBoardDTO : commBoardDTOList) {
        if (commBoardDTO.getLikeMembers().contains(joinDTO)) {
          System.out.println("좋아요는 1번만 가능합니다."); 
          return;
        }
      }

      if (input.equalsIgnoreCase("n") || input.length() == 0) {
        System.out.println("[  ❌ 좋아요 취소❌  ]");
        return;

      } else if (input.equals("y")) {
        System.out.println("[  ❤ LIKE 등록 완료 ❤  ]");
        commBoard.setLike(commBoard.getLike() + 1);
        commBoard.addLikeMember(joinDTO);

        commBoardDTOList.add(commBoard);

        return;
      } else {
        System.out.println("y 또는 n을 입력하세요.");
        continue;
      } 
    } 
  }
}

