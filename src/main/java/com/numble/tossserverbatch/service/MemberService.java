package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.Member;
import com.numble.tossserverbatch.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.numble.tossserverbatch.domain.Member.createMember;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public Long signUp (
        String name,
        String birthDay
    ){
        validateDulicatedMemberByName(name);

        Member member = createMember(name, birthDay);
        return memberRepository.save(member);
    }

    private void validateDulicatedMemberByName(String name) {
        List<Member> findMembers = memberRepository.findByName(name);

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
