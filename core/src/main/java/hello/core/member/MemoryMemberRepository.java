package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// MemberRepository를 상속 받으면서 Map형의 store에 고객 정보들을 저장하는 걸로 보인다.
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
    store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
