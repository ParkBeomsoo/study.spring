package study.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import study.study.spring.domain.Member;
import study.study.spring.repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){
    memoryMemberRepository.storeClear();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        memoryMemberRepository.save(member);
        Member result = memoryMemberRepository.findById(member.getId()).get();

//        System.out.println("result = " + (result==member));
//        Assertions.assertEquals(result,member);
        assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}
