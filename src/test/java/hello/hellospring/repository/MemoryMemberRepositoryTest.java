package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {  //public 으로 안해도됨

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach      //메서드가 실행이 끝날 때마다 어떤 동작을 하게 해주는 콜백메서드
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("greene");

        repository.save(member);

       Member result = repository.findById(member.getId()).get();
       //Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("greene1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("greene2");
        repository.save(member2);

        Member result = repository.findByName("greene1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("greene1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("greene2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}
