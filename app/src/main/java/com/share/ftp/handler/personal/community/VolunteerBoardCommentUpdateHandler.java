package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.domain.community.CommBoardReplyDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class VolunteerBoardCommentUpdateHandler implements Command {

  CommunityDao communityDao;

  public VolunteerBoardCommentUpdateHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[  나눔이야기 댓글 변경  ]");
    System.out.println();

    int commBoardNo = (int) request.getAttribute("commBoardNo");
    int commBoardReplyNo = (int) request.getAttribute("commBoardReplyNo");

    CommBoardReplyDTO commBoardReplyDTO = communityDao.findByCommBoardReplyNo(commBoardNo, commBoardReplyNo);

    if (commBoardReplyDTO == null) {
      System.out.println("[  해당 댓글이 없습니다.  ]");
      return;
    }

    if ((commBoardReplyDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) ||
        AuthLoginHandler.getLoginUser().getId().equals("admin")) {
    } else {
      System.out.println("변경 권한이 없습니다.");
      return;
    }

    String content = Prompt.inputString(String.format("내용(%s)? ", commBoardReplyDTO.getCommentcontent()));

    while (true) {
      String input = Prompt.inputString("[  정말 변경하시겠습니까?(y/N)  ]");

      if (input.equalsIgnoreCase("n") || input.length() == 0)  {
        System.out.println();
        System.out.println("[  댓글 변경을 취소하였습니다.  ]");
        return;

      } else if(input.equals("y")) {
        System.out.println();
        commBoardReplyDTO.setCommentcontent(content);
        communityDao.updateCommBoardReply(commBoardReplyDTO);

        System.out.println("[  댓글을 변경하였습니다.  ]");
        return;

      } else {
        System.out.println("y 또는 n을 입력하세요.");

      } 
    }
  }
}