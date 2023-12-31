package com.numble.tossserverbatch.domain.auth.service;

import com.numble.tossserverbatch.domain.auth.controller.dto.request.SignInRequestDto;
import com.numble.tossserverbatch.domain.auth.controller.dto.response.SignInResponseDto;
import com.numble.tossserverbatch.domain.auth.jwt.JwtTokenProvider;
import com.numble.tossserverbatch.domain.auth.jwt.type.JwtTokenType;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserDetailsService userDetailsService;
    private final RedisTemplate<Long, String> redisTemplate;


    public SignInResponseDto signIn(SignInRequestDto request ){
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getLoginId());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword(), userDetails.getAuthorities())
        );

        return createJwtToken(authentication);
    }


    private SignInResponseDto createJwtToken(Authentication authentication) {
        String accessToken = tokenProvider.createTokenByType(authentication, JwtTokenType.ACCESS);
        String refreshToken = tokenProvider.createTokenByType(authentication, JwtTokenType.REFRESH);
        return new SignInResponseDto(accessToken, refreshToken);

    }

}
