package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonCodeDTO extends BaseDTO {

	private String codeclass;

	private String code;

	private String codename;

	private String codedesc;

}
