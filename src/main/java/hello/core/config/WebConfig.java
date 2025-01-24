package hello.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // 모든 엔드포인트에 대해 허용
        .allowedOrigins("http://localhost7020") // 허용할 Origin
        .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드
        .allowedHeaders("*") // 허용할 헤더
        .allowCredentials(true); // 인증 정보 허용 여부
  }
}
