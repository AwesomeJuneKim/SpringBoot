package edu.pnu.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@Entity //데이터베이스와 매핑되는 클래스라고 알려줌->자동으로 만들어 줌
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
}
