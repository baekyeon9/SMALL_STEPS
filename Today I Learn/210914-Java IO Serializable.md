21-09-14



#### java.io.Serializable

* OutputOutStream/ ObjectInputStream을 통해 인스턴스의 값을 바이트 배열로 자동으로 변환하여 출력/ 읽기 할 때 구현해야하는 인터페이스.

* 인스턴스  → 바이트 배열로 자동으로 출력될 수 있는지 허락하는 용도.

* Serializable interface 내에는 메서드가 선언되어있지 않다. (단지 Serialize를 활성화시키는 기능을 수행)

* 이 interface를 구현한 객체만이 

  ObjectInputStream/ ObjectOutputStream으로 

  serialize/ deserialize 할 수 있다.

  

#### Serializable과 SerialVersionUID

* **serialVersionUID** 

  *  java.io.Serializable 이 붙은 클래스는 항상 이 변수를 내장한다.

  * 인스턴스를 serialize 하고 deserialize 할 때,   인스턴스 형식에 대한 검증 번호로 사용 됨.

  * 개발자가 이 변수의 값을 명시적으로 지정하지 않으면  컴파일러가 자동 부여함. 

    (컴파일러는 클래스가 다르면 이 변수의 값도 다르게 한다.)

  * serialVersionUID 값을 가지고 serialize 된 인스턴스의 값을  읽을 수 있는지 없는지 판단한다.

  * 필드를 추가하거나 변경, 삭제 하더라도 serialVersionUID 값만 같다면  JVM은 같은 형식으로 판단한다.

  

#### Transient Modifier Field

* transient(일시적인) + modifier(변경) - serialize 대상에서 제외해야하는 변수를 serialize 되지 않도록 변경한다.



#### MIME(Multi Internet Mail Extensions) type

* 인터넷 상에서 Data를 보내고 받을 때 어떤 형식의 data인지 알려주는 이름.

  → 처음에는 전자우편을 주고 받을 때 데이터포맷을 지정하는 용도로 사용했다. 

  → 현재는 웹상에서 data를 주고받을 때도 사용한다.)

* 국제적으로 표준 포맷이 정의되어 있다.

* |    Type     |  Sub Type  |
  | :---------: | :--------: |
  |    text     |    html    |
  |    text     |    CSS     |
  |    text     | javascript |
  |    text     |    csv     |
  | application |    pdf     |
  | application |    zip     |
  | application |   msword   |

  

