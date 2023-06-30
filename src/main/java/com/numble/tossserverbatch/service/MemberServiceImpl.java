package com.numble.tossserverbatch.service;


import com.numble.tossserverbatch.api.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.Member;
import com.numble.tossserverbatch.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;


    @Override
    public Long signUp (
        MemberSignUpRequestDto request
    ){
        validateDulicatedMemberByName(request.getName());
        Member createdMember = Member.withNameAndBirthDay(request.getName(), request.getBirthDay());
        return memberRepository.save(createdMember).getId();
    }

    private void validateDulicatedMemberByName(String name) {
        List<Member> findMembers = memberRepository.findByName(name);

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
