package springProj.hellospring.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import springProj.hellospring.domain.Member;
import springProj.hellospring.repository.MemberRepository;
import springProj.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

//진짜 spring 띄우고 컨테이너 + 테스트를 함께 실행
@SpringBootTest
//Transactional anotation은 트랜잰셕 실행 -> insert -> 테스트가 끝난 후 롤백시켜줌, 반영을 안해줌 (반복 테스트 가능)
@Transactional
class MemberIntegrationTest {

    //service 생성
    //MemberService memberService = new MemberService();
    //MemoryMemberRepository memberRepository = new MemoryMemberRepository(); //새로운 객체

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));//뒤에 로직이 실행됐을 때 앞 예외가 발생해야 함. ctrl + alt + v

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

/*
        try{
            memberService.join(member2);
            fail();
        }
        catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }
*/

        //then
    }

}