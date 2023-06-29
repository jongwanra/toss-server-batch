package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.domain.Member;
import com.numble.tossserverbatch.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.numble.tossserverbatch.domain.Member.createMember;

@Service
@Transactional
@RequiredArgsConstructor()
public class MemberService {
    private final MemberRepository memberRepository;

//    @Transactional(readOnly = false)
    public Long signUp (
        String name,
        String birthDay
    ){
        Member member = createMember(name, birthDay);
        System.out.println("before member = " + member);
        return memberRepository.save(member);
    }

}
