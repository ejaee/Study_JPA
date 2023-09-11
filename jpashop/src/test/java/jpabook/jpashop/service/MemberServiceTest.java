package jpabook.jpashop.service;

import static org.junit.Assert.*;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class) // junit 실행할 때 스프링이랑 같이 엮어서 실행하겠다.
@SpringBootTest // 스프링 부트를 띄운 상태로 테스트 하겠다.
@Transactional // test 에서 적혀있을 때에는 기본적으로 롤백을 한다.
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(savedId));

     }

     @Test(expected = IllegalStateException.class)
     public void 중복_회원_예외() throws Exception {
        //given
         Member member1 = new Member();
         member1.setName("kim");

         Member member2 = new Member();
         member2.setName("kim");

       //when
         memberService.join(member1);
         memberService.join(member2);

       //then
         fail("예외가 발생해야 한다."); // 접근하면 틀린다.

      }

}