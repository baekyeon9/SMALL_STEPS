package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {


  public CommBoardDetailHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    super(commBoardDTOList, commBoardReplyDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while(true) {
      System.out.println();
      System.out.println("[  소통해요/ 나눔이야기/ 상세보기  ]");
      System.out.println();

      int no = Prompt.inputInt("번호? ▶ ");

      CommBoardDTO commBoardDTO = findByNo(no);

      if (commBoardDTO == null) {
        System.out.println("[  해당 게시글이 없습니다.  ]");
        return;
      }
      //AuthLoginHandler.loginUser.getId(),

      System.out.printf("아이디 ▶ %s\n", commBoardDTO.getOwner().getId());
      System.out.printf("번호 ▶ %s\n", commBoardDTO.getCommNo());
      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
      System.out.printf("첨부파일 ▶ %s\n", commBoardDTO.getFileUpload());

      commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
      System.out.printf("조회수 ▶ %d\n", commBoardDTO.getViewCount());
      System.out.printf("좋아요♡  %d\n", commBoardDTO.getLike());
      System.out.printf("댓글수  %d\n", commBoardDTO.getReplyCount());
      System.out.println();

      JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 

      if (loginUser == null) {
        //      System.out.println("로그인 해주세요.");
        return;
      }

      if (commBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("변경(U), 삭제(D), 댓글(R), 이전(0)>");
          switch (input) {
            case "U":
            case "u":
              request.getRequestDispatcher("/commBoard/update").forward(request);
              return;
            case "D":
            case "d":
              request.getRequestDispatcher("/commBoard/delete").forward(request);
              return;
            case "R":
            case "r":
              request.getRequestDispatcher("/commBoardReply/connect").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      } 

      if (loginUser!= null) {

        request.setAttribute("no", no);

        while (true) {
          String input = Prompt.inputString("좋아요(L), 댓글(R), 이전(0)>");
          switch (input) {
            case "L":
            case "l":
              request.getRequestDispatcher("/commBoard/like").forward(request);
              return;
            case "R":
            case "r":
              request.getRequestDispatcher("/commBoardReply/connect").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      }

    }
  }




}

