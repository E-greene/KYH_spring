package hello1.core.order;

import hello1.core.discount.DiscountPolicy;
import hello1.core.discount.FixDiscountPolicy;
import hello1.core.discount.RateDiscountPolicy;
import hello1.core.member.Member;
import hello1.core.member.MemberRepository;
import hello1.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
