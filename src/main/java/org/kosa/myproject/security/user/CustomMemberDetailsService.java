package org.kosa.myproject.security.user;

import org.kosa.myproject.entity.Member;
import org.kosa.myproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**

 */
@RequiredArgsConstructor
@Service
@Slf4j
@Transactional(readOnly = true)
public class CustomMemberDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    /**
     * Spring Security가 인증 과정에서 자동으로 호출하는 메서드
     *
     *
     * @param username 로그인 시 입력한 사용자명
     * @return UserDetails 사용자 상세 정보
     * @throws UsernameNotFoundException 사용자를 찾을 수 없을 때
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("=== Spring Security 인증 시작 ===");
        log.info("로그인 시도: username={}", username);
       ////////////////////////////////////////////////////
       ////////////////////////////////////////////////////
        return null;
    }

    /**
     * JWT 토큰 검증 시 사용할 수 있는 추가 메서드
     * memberId로 사용자 조회
     *
     * @param memberId 회원 ID (PK)
     * @return UserDetails 사용자 상세 정보
     */
    public UserDetails loadUserByMemberId(Long memberId) {
        log.info("=== JWT 검증을 위한 사용자 조회: memberId={} ===", memberId);

        ////////////////////////////////////////////////////
        ///////////////////////////////////////////////////

        log.info("사용자 조회 성공: username={}, role={}",
                member.getUsername(), member.getRole());

        return new CustomMemberDetails(member);
    }
}