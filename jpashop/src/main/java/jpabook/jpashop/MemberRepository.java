package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    /**
     * JPA 를 쓰기 때문에 엔티티 매니저가 있어야한다?
     * 다음과 같이 스프링 부트가 간단하게 엔티티 매니저를 동록시킨다.
      */
    @PersistenceContext
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
        /**
         * <Member 를 반환하지않고 id를 반환하는 이유></Member>
         * 스타일: 커멘드와 쿼리를 분리해라
         * 저장을 하고나면 가급적이면 부작용을 일으킬 수 있는 커멘드성이기 때문에
         * 리턴값을 안만들고 ID 정도 있으면 나중에 조회할 수 있으니까 다음과 같이 주로 설계 하신다.
          */
    }

    public Member find(Long id) {
        return  em.find(Member.class, id);
    }

}
