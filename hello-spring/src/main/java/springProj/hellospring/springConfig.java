package springProj.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springProj.hellospring.repository.MemberRepository;
import springProj.hellospring.repository.MemoryMemberRepository;
import springProj.hellospring.service.MemberService;

@Configuration
public class springConfig {
    //스프링 빈을 등록할 거야!
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
