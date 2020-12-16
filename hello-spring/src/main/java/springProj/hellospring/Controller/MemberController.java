package springProj.hellospring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import springProj.hellospring.service.MemberService;

@Controller
/**
 * 의존관계 :
 * -> MemberController는 MemberService를 통해 회원가입을 하고, 조회를 할 수 있어야 한다.
 * 스프링이 뜰 때 컨테이너라는 빈 깡통이 생긴다.
 * Controller anotation이 있으면 컨테이너 안에 MemberController라는
 * 객체를 생성하고 스프링에 넣어두고 관리.
 */
public class MemberController {

    //new로 객체를 생성해서 사용하지 않고 컨테이너에 등록해서 사용하기 -> 한개만 가능
    //private final MemberService memberService = new MemberService();

    private final MemberService memberService;

    //@Autowired = memberService를 스프링이 컨테이너에 있는 memService와 연결시켜줌
    //이렇게만 선언하면 membersService는 그냥 자바클래스이기 때문에(스프링이 알 수가 없음)

    /**
     * MemberController이 생성될 때 스프링빈에 있는 memberService를 가져다 넣어줌
     * ==> Dependency Injection
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
