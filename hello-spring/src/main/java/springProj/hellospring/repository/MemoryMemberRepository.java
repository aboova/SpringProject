package springProj.hellospring.repository;

import springProj.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository { //alt + enter로 methods 추가하기

    private static Map<Long, Member> store = new HashMap<>(); //ctrl + space롤 모듈 import,
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //null 반환될 수 있기 때문에
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() //loop로 돌리기
            .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
