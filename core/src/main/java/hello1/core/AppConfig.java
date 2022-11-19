package hello1.core;

import hello1.core.discount.DiscountPolicy;
import hello1.core.discount.FixDiscountPolicy;
import hello1.core.discount.RateDiscountPolicy;
import hello1.core.member.MemberRepository;
import hello1.core.member.MemberService;
import hello1.core.member.MemberServiceImpl;
import hello1.core.member.MemoryMemberRepository;
import hello1.core.order.OrderService;
import hello1.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
