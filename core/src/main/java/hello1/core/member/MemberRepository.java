package hello1.core.member;

public interface MemberRepository {
    //회원 저장
    void save(Member member);
    //ID로 회원 찾기
    Member findById(Long memberId);
}
