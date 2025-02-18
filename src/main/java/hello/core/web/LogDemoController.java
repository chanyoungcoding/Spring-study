package hello.core.web;

import hello.core.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

  private final MyLogger myLogger;

  @RequestMapping("log-demo")
  public String logDemo(HttpServletRequest request) {
    String requestUrl = request.getRequestURL().toString();
    myLogger.setRequestURL(requestUrl);

    myLogger.log("Controller Test");
    return "OK";
  }
}
