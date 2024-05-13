package edu.pnu.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogDTO {
	private int id;
	private String method;
	private String sqlstring;
	private Date regidate;
	private boolean success;
}
