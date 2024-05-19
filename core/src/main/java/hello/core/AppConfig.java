package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 객체의 생성과 연결은 각각의 impl이 하지 않고 App config에서 다 처리한다. -> 관심사의 분리
 app config는 외부 역할을 한다. => 그러므로 내부(impl에서는 실행에만 집중을 하면 된다)
 -> 각 Impl에서 보면 의존관계를 마치 외부에서 주입해주는 것 같다고 해서 "DI"(Dependency Injection)
 즉 의존관계 주입 또는 의존성 주입이라고 한다.*/
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }// 생성자 주입

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }// 생성자 주입

    @Bean
    public DiscountPolicy discountPolicy(){
///      return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    /* memberRepository, memberRepository를 안만들고 그냥 new MemoryMemberRepository, new FixDiscountPolicy
    를 사용해도 되지만 그러면 역할이 명확하게 보이지 않아서 이렇게 만든 것이다.
     */
}
