package stepbystep;

public class For_02 {
  public static void main (String[] args) {

    for (int i = 0; i < 5; i++) 

      if (i == 4) 
        System.out.printf(" %c " , 'A'+ i);
      else if (i%2==0)
        System.out.printf("%c , ", ' ');
      else
        System.out.printf("%c ," , 'A'+ i);

  } 
}
