package hello.core.api;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ApiDemoController2 {


    private final MemberRepository memberRepository;
    private final MemberService memberService;
    private final OrderService orderService;

    @GetMapping("/apiTest3")
    @ResponseBody
    public Member apiDemo() {

        Member member = new Member(1L, "chan", Grade.VIP);
        memberRepository.save(member);

        return memberService.findMember(1L);
    }

    @GetMapping("/apiTest4")
    @ResponseBody
    public Order apiDemo2() {

        long memberId = 1;
        Member member = new Member(1L, "chan", Grade.VIP);

        memberService.join(member);

        return orderService.createOrder(memberId, "itemA", 10000);

    }
}
