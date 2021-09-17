21/09/16



#### 메타데이터(Metadata)

* **정의**  
  * 데이터에 대한 데이터
  * 어떤 목적을 가지고 만들어진 데이터 ("Constructed data with a purpose" - Karen Colye)
  * 대량의 정보 가운데 찾고 있는 정보를 효율적으로 찾아내서  이용하기 위해 일정한 규칙에 따라 콘텐츠에 대하여 부여되는 데이터
  * 구조화된 데이터를 분석, 분류하고 부가적 정보를 추가하기 위해 그 데이터 뒤에 함께 따라가는 정보 
  * 컴퓨터에서는 보통 메타데이터를 데이터를 표현하기 위한 목적 및 데이터를 빨리 찾기 위한 목적으로 사용 
  * e.g.) 디지털카메라 촬영 시, 사진에 카메라 정보, 촬영 시간, 노출, 해상도 등의 사진 정보를 화상 데이터와 같이 저장된다. 이 데이터를 분석하여 이용하면 GPS 기능을 사용하여 위치 정보 또한 사진의 메타데이터에 입력할 수 있다.



* **JSON**

  * 브라우저와 서버간의 통신을 위해 사용되는 표준 파일 포맷
  * 데이터를 전송할 때 사람이 해석할 수 있는 형태로 전송한다.
  * 형태 : Key/ Value / 텍스트와 숫자만 지원

  * { "no" : 100, "name" : "홍길동", ...}
    * Data (= content) : 100, 홍길동
    * Metadata (= mark up) : Data를 설명하는 data - "no", "name"



#### 콜렉션 (Collection)

* Iterable << interface>> : 목록에 데이터를 꺼내는 기능

  * iterator()

  * forEach()

    

* Collection << interface >> : 목록에 데이터를 추가/ 삭제 / 검사하는 기능

  * add()

  * remove()

  * isEmpty()

  * contains()

    

* List << interface>> : 목록에 데이터를 index로 다루는 기능

  * get()

  * set()

  * indexOf()

    

* ArrayList << interface>> : 데이터 조회/ 추가/ 삭제/ 검사 + index 

