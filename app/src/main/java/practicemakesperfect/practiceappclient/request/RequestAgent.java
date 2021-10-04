package practicemakesperfect.practiceappclient.request;


// 역할
// - 통신 프로토콜에 맞춰 서버에게 요청을 전달하고 응답을 받는 일을 한다.

public class RequestAgent {

  public static final String SUCCESS = "success";
  public static final String FAIL = "fail";

  String ip;
  int port;

  String status;
  String jsonData;

  public RequestAgent(String ip, int port) throws Exception {
    this.ip = ip;
    this.port = port;
  }

  public RequestAgent() throws Exception {

  }

}
