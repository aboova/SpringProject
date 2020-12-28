package springProj.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springProj.hellospring.repository.JdbcMemberRepository;
import springProj.hellospring.repository.MemberRepository;
import springProj.hellospring.repository.MemoryMemberRepository;
import springProj.hellospring.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class springConfig {
    //스프링 빈을 등록할 거야!

    private DataSource dataSource;

    @Autowired
    public springConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
