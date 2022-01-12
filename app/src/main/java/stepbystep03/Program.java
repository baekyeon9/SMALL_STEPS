package stepbystep03;

import java.util.Scanner;

public class Program {

  public static void main(String[] args) {

    ExamList list = new ExamList();
    ExamList.init(list);

    int menu;
    boolean keepLoop = true;

    while(keepLoop) 
    {
      menu = inputMenu();

      switch(menu) {
        case 1:
          ExamList.inputList(list);
          break;
        case 2:
          ExamList.printList(list);
          break;
        case 3:
          System.out.println("Bye~~");

          keepLoop = false;
          break;

        default:
          System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지 입니다."); 

      }
    }

  }




  static int inputMenu() {

  } 
