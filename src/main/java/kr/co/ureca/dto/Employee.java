package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee extends BaseDTO {
	private String empid;
	private String empname;
	private String rgstno;
	private String telcom;
	private String telhom;
	private String telcel;
	private String emailcom;
	private String emailpsn;
	private String emailpay;
	private String deptid;
	private String deptname;
	private String hrjp;
	private String retireyn;
	private String datehire;
	private String dateretire;

	private String username;

}
