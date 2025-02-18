package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
    OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

    long memberId = 1;
    Member member = new Member(1L, "memberA", Grade.VIP);

    memberService.join(member);

    Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);
  }

}
