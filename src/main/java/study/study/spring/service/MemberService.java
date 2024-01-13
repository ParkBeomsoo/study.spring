package study.study.spring.service;

import study.study.spring.domain.Member;
import study.study.spring.repository.MemberRepository;
import study.study.spring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        validateDulicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDulicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
    * 전체 회원 조회
    *
    * */

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
