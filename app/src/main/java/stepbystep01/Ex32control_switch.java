package stepbystep01;

import java.util.Scanner;

public class Ex32control_switch {

  public static void main(String[] args) {




    int kor1, kor2, kor3;
    int total;
    float avg;
    int menu;

    Scanner scan = new Scanner(System.in);

    kor1 = 0;
    kor2 = 0;
    kor3 = 0;

    종료:
      while(true) {

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃         메인 메뉴         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println("\t1.성적입력");
        System.out.println("\t2.성적출력");
        System.out.println("\t3.종료");
        System.out.printf("\t> ");
        menu = scan.nextInt();

        switch(menu) {

          case 1:

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃         성적 입력         ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


            do {
              System.out.print("국어1: ");
              kor1 = scan.nextInt();

              if(kor1 < 0 || 100 < kor1)
                System.out.println("성적범위(0~100를 벗어났습니다.");

            } while (kor1 < 0 || 100 <  kor1) ;


            do {
              System.out.print("국어2: ");
              kor2 = scan.nextInt();

              if(kor2 < 0 || 100 < kor2)
                System.out.println("성적범위(0~100를 벗어났습니다.");

            } while (kor2 < 0 || 100 <  kor2) ;


            do {
              System.out.print("국어3: ");
              kor3 = scan.nextInt();

              if(kor3 < 0 || 100 < kor3)
                System.out.println("성적범위(0~100를 벗어났습니다.");

            } while (kor3 < 0 || 100 <  kor3) ;

            break;

          case 2 :

            total = kor1 + kor2 + kor3;
            avg = total / 3.0f;

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃         성적 출력         ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            for (int i = 0; i < 3; i++) {
              System.out.printf("\t국어%d : %3d\n", i+1, kor1);
            }
            System.out.printf("\t총점 : %3d\n", total);
            System.out.printf("\t평균 : %6.2f\n", avg);

            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            break;

          case 3 :
            break 종료;

          default :
            System.out.println("입력 오류 1~3까지만 입력할 수 있습니다.");
        }    
      }
    System.out.println("bye bye!");
  }
}
