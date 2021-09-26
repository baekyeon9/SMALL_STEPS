package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.personal.CommBoardCommentDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import practicemakesperfect.util.Prompt;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {


  public CommBoardDetailHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardCommentDTO> commBoardCommentDTOList) {
    super(commBoardDTOList, commBoardCommentDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    while(true) {
      System.out.println();
      System.out.println("[  소통해요/ 나눔이야기/ 상세보기  ]");
      System.out.println();

      int no = Prompt.inputInt("번호? ");

      CommBoardDTO commBoardDTO = findByNo(no);

      if (commBoardDTO == null) {
        System.out.println("[  해당 게시글이 없습니다.  ]");
        return;
      }
      //AuthLoginHandler.loginUser.getId(),
      request.setAttribute("no", no);

      System.out.printf("아이디 ▶ %s\n", commBoardDTO.getOwner().getId());
      System.out.printf("번호 ▶ %s\n", commBoardDTO.getCommNo());
      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
      System.out.printf("첨부파일 ▶ %s\n", commBoardDTO.getFileUpload());

      commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
      System.out.printf("조회수 ▶ %d\n", commBoardDTO.getViewCount());
      System.out.printf("좋아요♡  %d\n", commBoardDTO.getLike());
      System.out.println();



      JoinDTO loginUser = AuthLoginHandler.getLoginUser(); 

      //      if (loginUser!= null) {
      //        Like();
      //
      //      }
      if (commBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId())) {
        while (true) {
          String input = Prompt.inputString("변경(U), 삭제(D), 이전(0)>");
          switch (input) {
            case "U":
            case "u":
              request.getRequestDispatcher("/commBoard/update").forward(request);
              return;
            case "D":
            case "d":
              request.getRequestDispatcher("/commBoard/delete").forward(request);
              return;
            case "0":
              return;
            default:
              System.out.println("명령어가 올바르지 않습니다!");
          }
        } 
      } 

      if (loginUser!= null) {
        String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ]");


        if (input.equalsIgnoreCase("n"))  {
          System.out.println("[  ❌ 좋아요 취소❌  ]");
          return;
        } else if(input.equalsIgnoreCase("y")) {
          commBoardDTO.setLike(commBoardDTO.getLike() +1);
          System.out.println("[  ❤ LIKE ❤  ]");
          return;
        }

        else {
          System.out.println("[  y 또는 n을 입력하세요.  ]");
          return;
        }

      }

    }
  }

  //  private void Like() {
  //
  //    // CommBoardDTO commBoardDTO = new CommBoardDTO();
  //
  //    String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ]");
  //
  //
  //    if (input.equalsIgnoreCase("n"))  {
  //      System.out.println("[  ❌ 좋아요 취소❌  ]");
  //      return;
  //    } else if(input.equalsIgnoreCase("y")) {
  //      commBoardDTO.setLike(commBoardDTO.getLike() +1);
  //      System.out.println("[  ❤ LIKE ❤  ]");
  //      return;
  //    }
  //
  //    else {
  //      System.out.println("[  y 또는 n을 입력하세요.  ]");
  //      return;
  //    }
  //  }

}

//      if (loginUser == null || 
//          (!commBoardDTO.getOwner().getId().equals(AuthLoginHandler.getLoginUser().getId()))) {
//        return;
//      }