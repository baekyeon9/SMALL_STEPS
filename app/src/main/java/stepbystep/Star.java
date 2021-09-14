package stepbystep;

public class Star {

  public static void main (String[] args) {

    for(int j=10; j >= 0; j--) {
      for (int i = 0; i <= j; i++) 
        System.out.printf("%c", '☆');

      System.out.println();  
    }
  }
}
