package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

//Junit5 부터는 public 없어도 됨.
class MemberRepositoryTest {

    //싱글톤이므로 new로하면 안됨 (스프링을 쓰면 스프링 자체가 싱글톤을 보장해 주므로 쓸필요 없음)
    MemberRepository memberRepository = MemberRepository.getInstance();
    @AfterEach //테스트가 끝날때마다 깔끔하게 초기화
    void afterEach(){
        memberRepository.clearStore(); //이 과정이 없으면 test함수 순서가 보장이 안되기 때문에 각 테스트(함수)가 끝날때마다 afterEach함수가 실행되어 clearStore해준다.
    }

    @Test
    void save(){ //새로 생성한 멤버를 저장하고, 저장한 멤버와 id를 통해 찾은 멤버가 같은지 확인하기
        //given
        Member member = new Member("hello", 20);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(saveMember.getId());
        assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll(){ //전체 멤버 수는 맞는지, 각각의 멤버들은 포함한거 맞는지 확인
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //given
        List<Member> result = memberRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1,member2); //result가 member1, member2가지고 있는지 확인

    }

}
