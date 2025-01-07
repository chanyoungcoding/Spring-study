package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

  @Test
  void basicScan() {

    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);
    MemberRepository memberRepository = ac.getBean(MemberRepository.class);

    Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
  }
}
