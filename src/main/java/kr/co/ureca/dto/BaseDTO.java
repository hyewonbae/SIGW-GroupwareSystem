package kr.co.ureca.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseDTO {

	private String created;

	private String createdEmpname;

	private LocalDateTime createdat;

	private String updated;

	private String updatedEmpname;

	private LocalDateTime updatedat;

}
