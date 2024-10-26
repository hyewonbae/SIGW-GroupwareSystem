package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleDTO extends BaseDTO {

	private String roleid;

	private String rolename;

	private String roledesc;

}
