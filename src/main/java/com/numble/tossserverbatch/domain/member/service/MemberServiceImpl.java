package com.numble.tossserverbatch.domain.member.service;


import com.numble.tossserverbatch.domain.member.controller.dto.request.MemberSignUpRequestDto;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.MemberRole;
import com.numble.tossserverbatch.domain.member.entity.MemberStatus;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Long signUp (
        MemberSignUpRequestDto request
    ){
        validateDulicatedMember(request);

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        Member createdUser = Member.createMember(
                request.getLoginId(),
                request.getName(),
                request.getBirthDay(),
                hashedPassword,
                MemberRole.USER
        );
        return memberRepository.save(createdUser).getId();
    }

    @Override
    public void deleteMember(Long memberId) {
        log.info("what!!!!?:;" + memberId);
        Member memberToDelete = memberRepository.findByIdAndStatus(memberId, MemberStatus.ACTIVE)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않은 회원입니다."));
        log.info("memberToDelete:" + memberToDelete);
        memberToDelete.deleteMember();
    }

//    @Override
//    public MemberSignInResponseDto signIn(MemberSignInRequestDto request) {
//        Member member = memberRepository.findByLoginId(request.getLoginId()).orElseThrow();
//
//        boolean isMatched = passwordEncoder.matches(request.getPassword(), member.getHashedPassword());
//        System.out.println("isMatched = " + isMatched);
//
//        if(!isMatched){
//            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
//        }
//
//        return new MemberSignInResponseDto(tokenProvider.createToken(member.getAuthorities()))
//    }

    private void validateDulicatedMember(MemberSignUpRequestDto request) {
        boolean isExistMember = memberRepository.findByLoginIdAndStatus(request.getLoginId(), MemberStatus.ACTIVE).isPresent();

        if(isExistMember){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
