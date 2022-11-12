package hello1.core;

import hello1.core.discount.FixDiscountPolicy;
import hello1.core.member.MemberService;
import hello1.core.member.MemberServiceImpl;
import hello1.core.member.MemoryMemberRepository;
import hello1.core.order.OrderService;
import hello1.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
