package springProj.hellospring.repository;

import springProj.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    // id, name이 null 일 수 있다.
    // null 반환할 때 많이 쓰는 방법으로 Optional로 감싸기
    Optional<Member> findById(Long id); //id로 회원을 찾기
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
