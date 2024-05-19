package hello.core.discount;
// 물건 값의 정해진 비율을 할인하는 코드(DiscountPolicy 상속)

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price*discountPercent/100;
        } else {
            return 0;
        }
    }
}
