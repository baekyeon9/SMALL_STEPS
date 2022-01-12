package stepbystep03_2;

public class Program {

  public static void main(String[] args) {

    ExamList list = new ExamList();
    list.init();

    int menu;
    boolean keepLoop = true;

    while(keepLoop) 
    {
      menu = inputMenu();

      switch(menu) {
        case 1:
          //          ExamList.inputList(list);
          list.inputList();
          break;
        case 2:
          //          ExamList.printList(list);
          list.inputList();
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
}
