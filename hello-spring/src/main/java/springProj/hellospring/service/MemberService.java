package springProj.hellospring.service;

import springProj.hellospring.domain.Member;
import springProj.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    /**
     * Test 쉽게 : ctrl + shift + t
     */

    private final MemberRepository memberRepository;

    //new로 생성하는 게 아니라 외부에서 넣어주도록.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은 이름의 회원x

        validateDuplicateName(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateName(Member member) {
        /*Optional<Member> result = memberRepository.findByName(member.getName()); // ctrl + shift + v
            result.ifPresent(m -> {
                throw new IllegalStateException("이미 존재하는 회원입니다.");
            });*/
        memberRepository.findByName(member.getName()). //ctrl + alt + m
                ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                }
        );
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
