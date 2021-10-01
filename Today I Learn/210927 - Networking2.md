21/09/27



#### Networking2 



* **Internet**

  * **LAN - Local Area Network**

    * LAN card(Network Interface Card - **NIC**)

       : 컴퓨터와 로컬 네트워크 연결을 위해 사용

  * **WAN - Wide Area Network**

    * Gateway 장비 : LAN과 LAN 연결



* Networking - 1대의 컴퓨터에서 통신 (LAN 카드 = NIC 이용)

  * [Client App]  <-----------------X----------------> [Server App]

  * 1대의 컴퓨터 내 프로그램간의 데이터를 직접 주고받을 수 없다.

  * LAN 카드를 통해 주고 받음. 데이터가 LAN 밖으로 나가지 않음

    

* Networking - 2대의 컴퓨터에서 통신 (LAN 카드 = NIC 이용)

  * [Client App]  <---- 데이터 직접전송 X ---->  [Server App]

    ​     

    ​        ↑↓                                                                     ↑↓

    ​                                                                  

    [    컴퓨터   ]   <-----------------------------------   [    컴퓨터    ]

    [     (NIC)     ]   ----------------------------------->   [     (NIC)      ]  

    

* **Socket**

  * Socket class : NIC을 통해 Application끼리 데이터를 주고받을 수 있게 하는 객체

  * **Socket과 SeverSocket**

    * Socket : 요청하는 쪽 (ClientApp)
    * ServerSocket : 요청 받는 쪽 (ServerApp)

  * Port Number(포트번호)

    * 통신할 대상을 구분하는 고유의 번호
    * Client측, Server측 모두 port 번호가 있어야 한다.

  * Socket/ SeverSocket과 포트번호

    * [Client App]  <---- 데이터 직접전송 X ---->  [Server App]

      ​        ↑↓                                                                     ↑↓                                                   

      [    Socket  ]   <-----------------------------------   [   ServerSocket   ]





ip address - 컴퓨터를 구분

port#