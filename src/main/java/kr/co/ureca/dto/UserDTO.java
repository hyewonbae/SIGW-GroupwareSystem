package kr.co.ureca.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO extends BaseDTO {

	private Long id;

	private String username;

	private String password;

	private String empname;

	private String roleNames;

	private List<String> roleArr;

}
