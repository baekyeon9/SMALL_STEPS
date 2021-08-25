2021-08-25



#### ArrayList  vs LinkedList

1) 메모리

   | ArrayList                                                    | LinkedList                                      |
   | :----------------------------------------------------------- | :---------------------------------------------- |
   | 고정 크기                                                    | 가변 크기 (값을 넣을 때 마다 새 메모리 추가)    |
   | 메모리 낭비 (크기 초과시 새로 배열 생성 - 기존 배열: 가비지) | ArrayList보다 메모리 낭비가 적고 가비지 덜 생산 |

   



#### 메서드의 유용성 다시 생각해보기

* 인터페이스가 없다면?

  * 개발자 마음대로 통일되지 않은 메서드를 정의

    e.g) 

    * ArrayList
      append( ), remove( ), update( ),...

    * LinkedList

       add( ), delete( ),  set( )...

  * 클래스 사용법이 달라서 프로그래밍 할 때 불편하다. (일관성x)

  * 클래스를 교체하기가 쉽지 않다. (코드를 많이 변경해야 한다.)

    e.g) ArrayList를 LinkedList로 교체하기 어려움



* 인터페이스를 사용하면?

  * 개발자가 클래스를 정의할 때 인터페이스가 정한 규칙(객체 사용법 정의)에 따라 메서드를 정의해야한다.

    e.g)  <<interface>> List add( ), remove( ), set( )

    * <<concrete>> ArrayList

      add( ), remove( ), set( )

    * <<concrete>> LinkedList

      add( ), remove( ), set( )

  * 클래스 사용법이 같기 때문에 프로그래밍에 일관성 부여

  * 클래스를 교체하더라도 변경해야할 코드가 적다. (유지보수가 쉽다.)

  * 구현할 기능에 맞춰 적절한 구현체로 교체하기가 쉽다.

    ArrayList  ⇄ LinkedList