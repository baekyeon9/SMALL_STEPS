2021-09-08



#### Streaming API (Data 입출력 관련 함수)



* **Java I/O 스트림 클래스 (java.io.*)****

  * **Data Sink Stream Classes**

  |                 | Byte Stream Class                               | Char Stream Class                                            |
  | --------------- | ----------------------------------------------- | ------------------------------------------------------------ |
  | 수퍼<br/>클래스 | 입력 : InputStream <br/>출력 : OutputStream     | 입력 : Reader <br/>출력 : Writer                             |
  | 파일            | FileInputStream <br/>FileOutputStream           | FileReader<br/>FileWriter                                    |
  | 메모리          | ByteArrayInputStream <br/>ByteArrayOutputStream | CharArrayReader/ CharArrayWriter  <br/> StringReader/ StringWriter<br/> |
  | 프로세스        | PipedInputStream <br/>PipedOutputStream         | PipedReader <br/>PipedWriter                                 |

  

  * **Data Processing Stream Classes**

|                                                              |                         Byte Stream                          |                       Character Stream                       |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
| **Decorator<**br/> ↓<br/> 다른 스트림에 <br/>연결해서 기능을 <br/>덧붙이는 역할 | DataInputStream<br/>DataOutPutStream<br/><br/>ObjectInputStream<br/>ObjectOutputStream<br><br/> BufferedInputStream<br>BufferedOutputStream | BufferedReader<br/> Bufferedwriter<br/> LineNumberReader<br/> PrintWriter (Sink Stream<br/>에도 속한다.) |

