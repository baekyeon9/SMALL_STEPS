package com.share.ftp.handler.personal.community;

import java.sql.Date;
import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardReplyAddHandler extends AbstractCommBoardReplyHandler {

  public CommBoardReplyAddHandler(
      List<CommBoardDTO> commBoardDTOList,
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 댓글 등록  ]");
    System.out.println();

    int commBoardNo = (int) request.getAttribute("no");

    CommBoardDTO commBoardDTO = findByCommBoardNo(commBoardNo);

    if (commBoardDTO == null) {
      System.out.println();
      System.out.println("해당 게시글이 없습니다!");
    }


    CommBoardReplyDTO commBoardReplyDTO = new CommBoardReplyDTO();

    commBoardReplyDTO.setCommNo(commBoardDTO.getCommNo());
    commBoardReplyDTO.setCommentcontent(Prompt.inputString("내용 ▶ "));
    commBoardReplyDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    commBoardReplyDTO.setOwner(AuthLoginHandler.getLoginUser());
    // commBoardReplyDTO.setCommReplyNo(getNextNum());
    // commBoardReplyDTO.setPassword(Prompt.inputString("비밀번호 ▶ "));

    if (commBoardDTO.getReplyCount() == 0) {
      commBoardDTO.setReplyCount(1);
      //      System.out.println("각 게시글의 첫 댓글입니다");
    } else {
      commBoardDTO.setReplyCount(getNextReplyNum(commBoardDTO));
      //      challengeReviewDTO.setReviewNo(getNextNum2()); // 해당 게시글 리뷰의 마지막 번호기억 + 1
      //      System.out.println("현재 댓글의 번호는? (commBoardReplyDTO.getReviewNo()) " + commBoardReplyDTO.getReplyNo());
      //      System.out.println("현재 댓글의 번호는? (commBoardDTO.getReplyCount()) " + commBoardDTO.getReplyCount());
    }

    commBoardReplyDTO.setCommReplyNo(commBoardDTO.getReplyCount()); 

    while (true) {
      String input = Prompt.inputString("해당 게시글에 댓글 등록을 하시겠습니까? (y/N) ");
      System.out.println();
      if (!input.equals("y") || input.length() == 0) {
        System.out.println();
        System.out.println("댓글 등록이 취소되었습니다.");
        return;

      } else if (input.equalsIgnoreCase("y")) {

        commBoardReplyDTOList.add(commBoardReplyDTO);

        System.out.println();
        System.out.println("[  ✔️ 댓글 등록이 완료되었습니다.  ]");
        break;

      } else {
        System.out.println("다시 입력해주세요.");
      }
    }
  }
}