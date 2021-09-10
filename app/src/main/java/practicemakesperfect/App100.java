package com.share.ftp;

import com.share.ftp.handler.admin.ShowChallengeHandler;
import com.share.ftp.handler.personal.VolListHandler;
import com.share.util.Prompt;

public class App100 {
  public static void main(String[] args) {

    VolListHandler volListHandler = new VolListHandler();

    while (true) {

      System.out.println("행복하share에 오신것을 환영합니다.");


      int menuNo = doMainMenu();

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {

        System.out.println("[메인 / 함께해요]");
        System.out.println("1. 승인목록");
        System.out.println("2. 봉사목록");
        System.out.println("3. 봉사참여");

        menuNo = Prompt.inputInt("번호 > ");
        switch (menuNo) {
          case 1: volListHandler.approveList(); break;
          case 2: volListHandler.detail(); break;
          case 3: volListHandler.join(); break;
          case 0: return;
          default:
            System.out.println("무효한 메뉴 번호입니다.");
        }
        System.out.println();
        //      } 

        //    } else if (menuNo == 2) {
        //      doMemberMenu();
        //    } else if (menuNo == 3) {
        //      doProjectMenu();
        //    } else if (menuNo == 4) {
        //      doTaskMenu();
      } else {
        System.out.println("메뉴 번호가 유효하지 않습니다.");
      }
      System.out.println();
    }

    Prompt.close();
  }

  //    void service() {
  //
  //      while (true) {
  //
  //        System.out.println("행복하share에 오신것을 환영합니다.");
  //
  //        System.out.println("1. 봉사신청");
  //
  //
  //        String input = Prompt.inputString("입력> ");
  //
  //        if (input.equals("exit") || input.equals("quit")) {
  //          System.out.println("안녕!");
  //          break;
  //        } else if (input.equals("1")) {
  //          volListHandler.approveList();

  //      } else if (input.equals("/member/list")) {
  //        memberHandler.list();
  //
  //      } else if (input.equals("/member/detail")) {
  //        memberHandler.detail();
  //
  //      } else if (input.equals("/member/update")) {
  //        memberHandler.update();
  //
  //      } else if (input.equals("/member/delete")) {
  //        memberHandler.delete();
  //
  //      }  else if (input.equals("/project/add")) {
  //        projectHandler.add(memberHandler);
  //
  //      }  else if (input.equals("/project/list")) {
  //        projectHandler.list();
  //
  //      }  else if (input.equals("/project/detail")) {
  //        projectHandler.detail();
  //
  //      }  else if (input.equals("/project/update")) {
  //        projectHandler.update(memberHandler);
  //
  //      }  else if (input.equals("/project/delete")) {
  //        projectHandler.delete();
  //
  //      }  else if (input.equals("/task/add")) {
  //        taskHandler.add(memberHandler);
  //
  //      }  else if (input.equals("/task/list")) {
  //        taskHandler.list();
  //
  //      }  else if (input.equals("/task/detail")) {
  //        taskHandler.detail();
  //
  //      }  else if (input.equals("/task/update")) {
  //        taskHandler.update(memberHandler);
  //
  //      }  else if (input.equals("/task/delete")) {
  //        taskHandler.delete();
  //
  //      }  else if (input.equals("/board/add")) {
  //        boardHandler.add();
  //
  //      }  else if (input.equals("/board/list")) {
  //        boardHandler.list();
  //
  //      }  else if (input.equals("/board/detail")) {
  //        boardHandler.detail();
  //
  //      }  else if (input.equals("/board/update")) {
  //        boardHandler.update();
  //
  //      }  else if (input.equals("/board/delete")) {
  //        boardHandler.delete();

  //} else {
  //  System.out.println("다시 입력해주세요");
  //}
  //System.out.println();
  //}
  //
  //
  //
  //// Prompt 가 소유하고 관리하고 있는 자원을 닫으라고 명령한다. 
  //Prompt.close();
  //}

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("0. 종료");
    System.out.println("1. 함께해요");
    return Prompt.inputInt("번호 > "); 
  }






  ShowChallengeHandler show = new ShowChallengeHandler();

  try {
    while (true) {
      System.out.println("메인");
      System.out.println("1. 챌린지 등록");
      System.out.println("0. 종료");
      System.out.println();
      int input = Prompt.inputInt("번호? ");

      if (input == 0) {
        return;
      } else if (input == 1) {

        LOOP: while (true) {
          System.out.println("0. 이전메뉴");
          System.out.println("1. 등록");
          System.out.println("2. 목록");
          System.out.println("3. 세부");
          System.out.println("4. 수정");
          System.out.println("5. 삭제");

          int menuNo = Prompt.inputInt("번호?> ");
          System.out.println();

          switch (menuNo) {
            case 1: show.add(); break ;
            case 2: show.list(); break ;
            case 3: show.detail(); break ;
            case 4: show.update(); break ;
            case 5: show.delete(); break ;
            case 0: break LOOP;
            default: System.out.println("다시 입력!");

          } 
        }
      } else if (input == 2) {

      } else if (input == 3) {

      } else if (input == 4) {

      } else if (input == 5) {

      } else {
        System.out.println("다시입력");
      }
    }
  } catch (Throwable e) {
    System.out.println("올바른 숫자를 입력하세요");
    System.out.println("----------------------------");
    e.printStackTrace();
  }

}