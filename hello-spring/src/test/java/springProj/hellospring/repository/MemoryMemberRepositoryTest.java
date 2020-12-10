package springProj.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import springProj.hellospring.domain.Member;

import java.awt.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//검증할 수 있는 틀을 미리 만들고 결과물을 껴넣기 ! -> 테스트주도개발 (TDD)
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //*****테스트가 끝날 때마다 repository를 다 지워주는 작업*****
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member); //repository에 저장

        Member result = repository.findById(member.getId()).get(); //검증
        //System.out.println("result = " + (result == member)); // result=true, 항상 출력으로 볼 수는 없음.
        Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName() {
        //spring1, spring2 멤버가 회원가입 됨.
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); //Shift + f6
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
