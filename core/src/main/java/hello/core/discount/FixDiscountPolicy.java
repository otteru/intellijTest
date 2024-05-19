package hello.core.discount;
// 정해진 값을 할인 하는 코드( DiscountPolicy 상속)

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int dicountFixAmount = 1000; //픽스로 천원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return dicountFixAmount;
        } else {
            return 0;
        }
    }
}
