package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap 이나 AtomicLong 사용을 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //싱글톤으로 만든다. 스프링을 안쓰고 만들기 때문에
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    //싱그톤으로 만들 때는 private으로 생성을 막아야 한다.
    private MemberRepository() {

    }

    //회원 저장
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //회원 찾기
    public Member findById(Long id) {
        return store.get(id);
    }

    //회원 전체 찾기
    public List<Member> findAll() {
        //store에 있는 모든 값들을 꺼내서 새로운 ArrayList에 담아서 넘겨줌
        //new ArrayList의 값을 넣거나 밖에서 조작해도 store에 있는 value리스트를 건들고 싶지 않아서
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


}
