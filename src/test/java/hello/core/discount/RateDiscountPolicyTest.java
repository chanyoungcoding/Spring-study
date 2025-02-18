package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class RateDiscountPolicyTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    DiscountPolicy discountPolicy = applicationContext.getBean("discountPolicy", DiscountPolicy.class);
//    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10% 할인이 적용되어야 합니다.")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아니면 할인이 적용되지 않아야 합니다.")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(0);

    }

    @Test
    @DisplayName("스프링 컨테이너의 싱글톤 확인")
    void springContainer() {
        DiscountPolicy discountPolicy1 = applicationContext.getBean("discountPolicy", DiscountPolicy.class);
        DiscountPolicy discountPolicy2 = applicationContext.getBean("discountPolicy", DiscountPolicy.class);

        Assertions.assertThat(discountPolicy1).isSameAs(discountPolicy2);
    }

}
