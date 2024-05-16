package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	//IDENTITY(이외 여러가지 존재) = 자동으로 만들어주는 값의 전략 ->auto-increment를 이용해서 기본키를 생성
	private Long seq;
	private String title;
	private String writer;
	private  String content;
	@Temporal(value=TemporalType.TIMESTAMP) //DB에 입력시 이해가능한 타입을 설정해줘야 한다.
	private Date createDate;
	private Long cnt;
}
