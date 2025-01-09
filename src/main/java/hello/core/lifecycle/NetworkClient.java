package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;

@Data
public class NetworkClient {

  private String url;

  // 초기화 시 호출
  public void connect() {
    System.out.println("Connect : " + url);
  }

  //서비스 종료시 호출
  public void disconnect() {
    System.out.println("Close : " + url);
  }

  @PostConstruct
  public void init() {
    connect();
  }

  @PreDestroy
  public void close() {
    disconnect();
  }
}
