package springProj.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 컴포넌트 스캔은
 * springProj.hellospring 포함 하위 패키지들을 스프링이 뒤져서
 * 모두 스프링빈에 등록시켜놓는다.
 * => 같은 스프링빈이면 같은 인스턴스이다.
 * ex) memberService 이외에 주문 service가 생기고 memberRepository를 @Autowired로 엮어줄 경우
 * 같은 memberRepository를 넣어준다.
 * */

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
