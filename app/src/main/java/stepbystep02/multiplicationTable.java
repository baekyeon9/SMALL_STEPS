package stepbystep02;

public class multiplicationTable {

  public static void main (String[] args) { 
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        System.out.println(i + "단:" + i + "x" + j + "=" + i*j);
      }
    }
  }
}
