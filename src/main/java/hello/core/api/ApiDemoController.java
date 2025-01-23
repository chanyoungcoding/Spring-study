package hello.core.api;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiDemoController {

  private final MemberRepository memberRepository;
  private final MemberService memberService;

  @GetMapping("/apiTest")
  public Member apiDemo() {

    Member member = new Member(1L, "chan", Grade.VIP);
    memberRepository.save(member);

    return memberService.findMember(1L);

  }
}
