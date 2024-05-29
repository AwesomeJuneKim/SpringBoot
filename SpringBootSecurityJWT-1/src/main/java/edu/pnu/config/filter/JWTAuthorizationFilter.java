package edu.pnu.config.filter;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Member;
import edu.pnu.persistence.MemberRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JWTAuthorizationFilter extends OncePerRequestFilter{
	private final MemberRepository memberRepository;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String srcToken = request.getHeader("Authorization");//로그인할 때 생성되었던 토큰을 얻어온다
		if(srcToken ==null ||!srcToken.startsWith("Bearer ")) {//토큰이 없거나 Bearer로 시작하지 않는다면 필터를 그냥 통과한다???
			filterChain.doFilter(request, response);
			return;
		}
		String jwtToken = srcToken.replace("Bearer ", "");//토큰의 Bearer를 제거한다.
		
		String username = JWT.require(Algorithm.HMAC256("edu.pnu.jwt")).build().verify(jwtToken).getClaim("username").asString();//토큰에서 username추출한다.
		
		Optional<Member> opt = memberRepository.findById(username);//토큰에서 얻은 username으로 DB에서 사용자를 검색한다.
		if(!opt.isPresent()) { //username이 없다면
			filterChain.doFilter(request, response);//필터를 그냥 통과
			return;
		}
		Member findMember = opt.get();//찾은 사용자를 객체로 저장해 준다.
		User user = new User(findMember.getUsername(), findMember.getPassword(), AuthorityUtils.createAuthorityList(findMember.getRole().toString()));
		//username, password는 findMember에 있는 그대로 들고오면 되지만 권한은 authorityUtils로 옮겨야 한다.
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());//확인 된 객체를 생성
		
		//시큐리티 세션에 등록한다.
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		filterChain.doFilter(request, response);
		
		
	}

}
