21/10/06-07



#### DBMS (DataBase Management System )

- 정의 : 데이터 보관과 조회를 서비스하는 프로그램 (S/W)
  - 예  : Oracle, MySQL, MS-SQL, Altibase, Tibero, Cubrid 등



###### Database 특징

* **실시간 접근 가능**  :  데이터 처리 요청에 즉시 응답

* **동시 공유**  :  여러 사용자가 공유

* **데이터의 독립성**  :  어플리케이션에 비종속

* **일관성**  :  데이터 처리 작업이 끝난 후, 데이터의 값은 유효한 상태를 유지해야 한다.

  ​                 e.g.) 특정 회원의 데이터 삭제 시, 삭제된 회원이 작성한 글도 삭제

* **무결성**  :  유효하지 않은 데이터의 등록과 변경, 삭제를 제한 e.g.) 게시글 작성자 삭제 불가

* **보안성**  

  * 사용자 인증(authentication) : e.g.) ID/PW 일치해야만 유효한 사용자
  * 권한 검사(authorization) :  e.g.) 기능의 이용 권한 검사 (등록 / 변경 허용?)



###### SQL (Structured Query Language)

* 표준 SQL 문법 : DBMS에 공통으로 사용할 수 있는 문법
* 각 사의 전용 문법
  * DBMS 제품마다 강/약점이 있고, 각 제품별 전용 문법(특정 DBMS에서만 사용하는 문법)이 있다.
  * 그래서 실무에서는 DBMS에 따라 코드를 변경해야 한다.
  * DBMS를 제대로 활용하려면 DBMS 전용 SQL문법을 사용해야 한다.

* 종류

  1) DDL (Data Definition Language) 데이터 구조  정의 문법

     - 데이터를 저장하고 DB객체를 정의한다.

  2) DQL (Data Query Language) 데이터 조회 요청 문법

     DML (Data Manipulation Language) 데이터 등록/변경/삭제 문법

     * DB 객체의 데이터를 다룬다.

     DB객체? Table, View, Procedure, Function...



###### Table과 Row, Culumn

* **Table**

  * 테이블 정의 :  create table 테이블명 (컬럼, ... ) 

  * 테이블 삭제 :  drop table 테이블명

  * 테이블 변경 : alter table 테이블명 변경사항

  * 테이블 정보 조회 : describe (or desc) 테이블명

    

* **키 컬럼 지정**

  - **Key** : 데이터를 구분할 때 사용할 컬럼들의 집합

    - **Primary Key**(PK) : DB 관리자가 main key로 결정한 key

      - PK 컬럼을 지정하지 않으면 데이터가 중복될 수 있다.

      - e.g.) DBMS 관리자가 id 컬럼의 값을 데이터를 구분하는 키로 사용하기로 결정했다면,

          \- 주 키는, {id} 가 된다.

          \- 주 키로 선택되지 않은 모든 candidate key는 alternate key가 된다.

    - **Alternate Key** : main 키로 선정되지 않은 나머지 후보 key (대안)

      - Candidate key 중에서 primary key로 선택된 키를 제외한 나머지 키.
      - 비록 primary key는 아니지만, primary key 처럼 데이터를 구분하는 용도로 대신 사용할 수 있다고 해서 **대안 키(alternate key)** 라 부른다.
      - **Candidate key** (최소키) : 최소 컬럼으로 구성된 키 

    - **Artificial Key(인공키)**

      - 마땅히 사용할 key가 없을 경우, 임이의 컬름을 만들어 PK로 지정한다.

        e.g.) 게시글 제목, 내용, 작성일, 작성자, 조회수, 좋아요수 + <u>인공키(게시글 번호)</u>