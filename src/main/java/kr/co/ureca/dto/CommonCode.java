package kr.co.ureca.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonCode {
	private String codeclass;
	private String code;
	private String codename;
	private String codedesc;
	private String created;
	private LocalDateTime createdat;
	private String updated;
	private LocalDateTime updatedat;
}
