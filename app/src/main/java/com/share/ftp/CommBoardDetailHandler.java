package com.share.ftp;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardCommentDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.CommandRequest;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.util.Prompt;

public class CommBoardDetailHandler extends AbstractCommBoardHandler {

  public CommBoardDetailHandler(List<CommBoardDTO> commBoardDTOList, List<CommBoardCommentDTO> commBoardCommentDTOList) {
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

      System.out.printf("아이디 ▶ %s\n", commBoardDTO.getOwner().getId());
      System.out.printf("번호 ▶ %s\n", commBoardDTO.getCommNo());
      System.out.printf("제목 ▶ %s\n", commBoardDTO.getTitle());
      System.out.printf("내용 ▶ %s\n", commBoardDTO.getContent());
      System.out.printf("첨부파일 ▶ %s\n", commBoardDTO.getFileUpload());

      commBoardDTO.setViewCount(commBoardDTO.getViewCount() + 1);
      System.out.printf("조회수 ▶ %d\n", commBoardDTO.getViewCount());
      System.out.printf("좋아요♡  %d\n", commBoardDTO.getLike());
      System.out.println();

      try {

        if (AuthLoginHandler.getLoginUser().getId() != null) {


          System.out.printf("%d", "--------------------------------------------");
          System.out.println("[1 ▶ ❤ 좋아요 ❤]");
          System.out.println("[2 ▶ 댓글 등록]");
          System.out.println("[3 ▶ 댓글 수정]");
          System.out.println("[4 ▶ 댓글 삭제]");

          //          int input = Prompt.inputInt("분류 ▶ ");
          //          switch (input) {
          //            case 1 : addComment(askBoard); break;
          //            case 2 : updateComment(); break;
          //            case 3 : deleteComment(askBoard); break;
          //            case 4 : deleteComment(askBoard); break;
          //          //            default : return;
          //        }
          //      }
          //    }
        } 
      } catch (Throwable e) {
      }
    }


  }}




//try {
//
//  if (AuthLoginHandler.getLoginUser().getId() != null) {
//
//    String input = Prompt.inputString("[  ♡ 공감이 되셨다면 좋아요를 눌러주세요(y/N) ♡ ]");
//
//    if (AuthLoginHandler.getLoginUser().getId() ==  null) {
//      System.out.println("[  로그인을 해주세요!  ]");
//      return;
//    }
//
//    if (input.equalsIgnoreCase("n"))  {
//      System.out.println("[  ❌ 좋아요 취소❌  ]");
//      return;
//    }
//    else if(input.equals("y")) {
//      System.out.println("[  ❤ LIKE ❤  ]");
//      commBoardDTO.setLike(commBoardDTO.getLike() +1);
//      return;
//    }
//
//    else {
//      System.out.println("[  y 또는 n을 입력하세요.  ]");
//      continue;
//    }
//
//  }
//  System.out.println("\n---------------------");
//  System.out.println("1. 댓글 남기기");
//  System.out.println("2. 댓글 수정");
//  System.out.println("3. 댓글 삭제");
//  System.out.println("0. 뒤로 가기");
//  // if (AuthLoginHandler.getLoginUser().getId() != null) {        
//
//  //          int selectNo = Prompt.inputInt("선택> ");
//  //          switch (selectNo) {
//  //            case 1 : addComment(askBoard); break;
//  //            case 2 : updateComment(); break;
//  //            case 3 : deleteComment(askBoard); break;
//  //            default : return;
//  //          }
//  //        }
//
//} catch (Throwable e) {
//}
//}
//}
//}

