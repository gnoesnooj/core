package hello.core.member;

public class MemberServiceImpl implements MemberService{
    
    //private final MemberRepository memberRepository = new MemoryMemberRepository(); // 문제점 : 추상화와 구체화에 모두 의존하고 있다 -> DIP 위배
    private final MemberRepository memberRepository; // 인터페이스에만 의존하고 있으므로 추상화에만 의존하고 있다.

    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자를 통한 의존성 주입
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
