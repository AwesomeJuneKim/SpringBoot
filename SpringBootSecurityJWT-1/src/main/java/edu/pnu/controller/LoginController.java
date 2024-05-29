package edu.pnu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import edu.pnu.domain.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/")
	public String index() { return "index"; }
	@GetMapping("/member")
	public String member() { return "member"; }
	@GetMapping("/manager")
	public String manager() { return "manager"; }
	@GetMapping("/admin")
	public String admin() { return "admin"; }
	
	@PostMapping("/login")
	public String login(@RequestBody Member member, HttpServletRequest request, HttpServletResponse response){
		try {
			Authentication authToken = new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());//사용자가 입력한 id, password를 토큰에 저장
			Authentication auth = authenticationManager.authenticate(authToken);//위의 토큰을 받아 사용자를 검증 후 사용자의 인증정보가 포함 된 객체 반환
			//auth는 사용자의 권한정보가 저장, user에는 사용자의 이름, 암호, 권한 등을 포함할 수 있다.
			User user = (User) auth.getPrincipal();
			String Token = JWT.create().withExpiresAt(new Date(System.currentTimeMillis()+1000*60*100))
					.withClaim("username", user.getUsername())
					.sign(Algorithm.HMAC256("com.edu.pnu.jwt"));
			response.addHeader("Authorization", "Bearer "+Token);
			return "login success";
		} catch (Exception e) {
			// TODO: handle exception
			return "login failed";
		}
	}
	//public static
}
