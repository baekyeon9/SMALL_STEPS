package practicemakesperfect;

import com.share.ftp.handler.CommBestHandler;
import com.share.ftp.handler.CommBoardHandler;
import com.share.ftp.handler.CommHandler;
import com.share.ftp.handler.CommReviewHandler;
import com.share.util.Prompt;

public class AppBaekyeon {


  static CommBestHandler commBestHandler = new CommBestHandler();
  static CommBoardHandler commBoardHandler = new CommBoardHandler();
  static CommHandler commHandler = new CommHandler();
  static CommReviewHandler commReviewHandler = new CommReviewHandler();

  public static void main(String[] args) {


    while (true) {
      int menuNo = doMainMenu();

      if (menuNo == 0) {
        break;
      } else if (menuNo == 2) {
        doCommMenu();
      } /* else if (menuNo == 2) {
          doMemberMenu();
        } else if (menuNo == 3) {
          doProjectMenu();
        } else if (menuNo == 4) {
          doTaskMenu();
        } */ else {
          System.out.println("메뉴 번호가 유효하지 않습니다.");
        }
      System.out.println();
    }

    Prompt.close();
  }

  static void doCommMenu() {
    while (true) {
      System.out.println("[소통해요]");
      System.out.println("1. 나눔이야기");
      System.out.println("2. 나눔이야기 베스트");
      System.out.println("3. 한줄후기");


      int menuNo = Prompt.inputInt("게시판> ");
      switch (menuNo) {
        case 1: commHandler.commBoard(); break;
        case 2: commHandler.commBest(); break;
        case 3: commHandler.commReview(); break;
        case 0: return;
        default:
          System.out.println("무효한 메뉴 번호입니다.");
      }
      System.out.println();
    }
  }

  static int doMainMenu() {
    System.out.println("[메인]");
    System.out.println("1. 함께해요");
    System.out.println("2. 소통해요");
    System.out.println("3. 첼린지");
    System.out.println("4. 모금함");
    System.out.println("5. 고객센터");
    System.out.println("6. 마이페이지");
    System.out.println("0. 종료");

    return Prompt.inputInt("번호입력>");    
  }
}
}
