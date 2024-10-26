package kr.co.ureca.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Department {
	private String deptid;
	private int level;
	private int ordered;
	private String deptname;
	private String pdeptid;
	private String empid;
	private String empname;
	private String hrjp;
	private String hrjpname;
	private String startdate;
	private String enddate;
	private String created;
	private LocalDateTime createdat;
	private String updated;
	private LocalDateTime updatedat;
}
