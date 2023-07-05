package com.numble.tossserverbatch.domain.auth.jwt;


import com.numble.tossserverbatch.domain.auth.jwt.type.JwtTokenType;
import com.numble.tossserverbatch.domain.member.entity.Member;
import com.numble.tossserverbatch.domain.member.entity.MemberStatus;
import com.numble.tossserverbatch.domain.member.repository.MemberRepository;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
@Slf4j
public class JwtTokenProvider implements InitializingBean {

    @Autowired
    MemberRepository memberRepository;
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);
    private static final String AUTHORITIES_KEY = "auth";
    private static final String TOKEN_PREFIX = "Bearer ";
    private static final Long refreshTokenValidityInMilliseconds = 604800 * 1000L;
    private static final Long accessTokenValidityInMilliseconds = 7200 * 1000L;
    private final String secret;

    private Key key;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secret
    ) {
        this.secret = secret;
    }

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createTokenByType(Authentication authentication, JwtTokenType tokenType) {
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();

        Date validity = new Date(now +
                (tokenType == JwtTokenType.ACCESS
                        ? accessTokenValidityInMilliseconds
                        : refreshTokenValidityInMilliseconds
                ));

        return TOKEN_PREFIX + Jwts.builder()
                .setSubject(authentication.getName())
                .claim(AUTHORITIES_KEY, authorities)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(validity)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> parsedClaimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            System.out.println("parsedClaimsJws = " + parsedClaimsJws);
            Member member = memberRepository.findByIdAndStatus(Long.parseLong(parsedClaimsJws.getBody().getSubject()), MemberStatus.ACTIVE)
                    .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 유저입니다."));


            System.out.println(":: member::" + member);

            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
            logger.info("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            logger.info("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
            logger.info("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
