2021-08-23

### [ 제네릭 (generic) ]

* 제네릭 사용

  * 다루는 타입을 제한할 수 있다.
    * 어떤 종류(Type, class)의 객체를 저장할 것인지 지정할 수 있다.
    * 지정된 타입 외에 다른 타입은 저장할 수 없다. (오류발생)
  * 제네릭을 지정하면 그와 관련된 메서드의 타입 정보가 자동으로 바뀐다. => 형변환의 번거로움이 없음

  * 한 개의 클래스로 형변환 없이 특정 타입 전용 클래스로 만들 수 있다.

    

* 제네릭 문법이 없다면?

  * 값을 꺼낼 때 마다 형변환 해야함.
  * 형변환 하지 않을 경우 값의 종류별로 ArrayList를 만들어야 한다.

  

* 제네릭 문법

  * 클래스명 옆에 다루고자 하는 타입의 이름을 지정한다.

    클래스명<타입명>

    ```java
    ArrayList<Member> list = new ArrayList<Member>(); 
    ```

  * 레퍼런스 선언에 제네릭 정보가 있다면 new 연산자에서는 생략 가능.

    ```java
    ArrayList<Member> list2 = new ArrayList</*Member*/>(); 
    ```

  * 레퍼런스와 인스턴스 생성

    * 

      ```java
      ArrayList<Object> list1;
      // 제네릭 타입을 Object로 지정하면 그렇게 지정된 ArrayList 객체만 list1에 저장할 수 있다.
      
      list1 = new ArrayList<Object>();
      
      // ArrayList<Object> 로 만든 객체는 다음과 같이 Object의 모든 객체를 담을 수 있다.
      list1.add(new String()); 
      list1.add(new java.util.Date());
      list1.add(new Integer(100));
      list1.add(new StringBuffer());
      
      ```

      



* 제네릭 타입 파라미터로 많이 사용하는 이름 (보통 긴이름을 사용하지 않는다.)
  * T - Type이라는 의미를 표현할 수 있어 많이 사용하는 이름
  * E - Element라는 의미로 목록의 항목을 가리킬 때 사용
  * K - Key 객체를 가리킬 때 사용
    * N - Number의 의미로 숫자 타입을 가리킬 때 주로 사용한다.
      // V - Value의 의미로 값의 타입을 가리킬 때 사용한다.
      // S,U,V 등 - 한 번에 여러 타입을 가리킬 때 두 번째, 세 번째, 네 번째 이름으로 주로 사용한다.
      //



> 
>
> ```java
> public static void main(String[] args) {
>     // m1(ArrayList<? super B1>)
>     // => B1 타입 및 그 상위 타입에 대해서 ArrayList 객체를 파라미터로 넘길 수 있다.
>     //
>     m1(new ArrayList<Object>()); // OK
>     m1(new ArrayList<A>()); // OK
>     m1(new ArrayList<B1>()); // OK 
> ```
>
> 



타입이 물음표일 경우

- extend, super에 따라 넘겨줄 수 있는것 / 없는 것 있다.
- 