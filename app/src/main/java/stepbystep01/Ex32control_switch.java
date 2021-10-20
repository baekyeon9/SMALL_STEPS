package stepbystep01;

import java.util.Scanner;

public class Ex32control_switch {

  public static void main(String[] args) {

    int n = 0;

    Scanner scan = new Scanner(System.in);
    System.out.print("값을 sp로 구분해서 5개 이상 입력하세요: ");

    while(scan.hasNext()) {
      n = scan.nextInt();

      if(n < 10)
        continue;

      if(n > 200)
        break;

      System.out.println(n);
    }

  }
}
