package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	

	@Bean//해당 메서드가 리턴하는 객체를 자동으로 컨테이너에 등록
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(security->security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				.requestMatchers("admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());
		http.csrf(cf->cf.disable()); //csrf 보호 비활성화(사이트간 요청 위조)
		//http.formLogin(form->{});//spring boot가 제공해주는 로그인을 사용하겠다는 설정
		http.formLogin(form->
				form.loginPage("/login")
					.defaultSuccessUrl("/loginSuccess",true));
		
		//접근 권한 없음 페이지 처리
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		//로그아웃 처리
		http.logout(logout->logout
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/login"));
		
		//데이터베이스 호출이 안되면 아래 코드 입력
		http.headers(hr->hr.frameOptions(fo->fo.disable()));
		
		http.oauth2Login(oauth2->oauth2
				.loginPage("/login")
				.defaultSuccessUrl("/loginSuccess",true)
	);

		return http.build();
	}
//	@Autowired
//	public void authenticate(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//			.withUser("manager")
//			.password("{noop}abcd")//{noop}암호화하지 않고 뒤의 문자를 암호로 사용하겠다는 의미
//			.roles("MANAGER");
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("{noop}abcd")
//			.roles("ADMIN");
//	}
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
