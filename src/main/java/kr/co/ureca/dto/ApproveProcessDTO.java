package kr.co.ureca.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApproveProcessDTO {
	private String apprvid;
	private String docid;
	private String apprvseq;
	private String deptid;
	private String deptname;
	private String empid;
	private String empname;
	private int apprvstatus;
	private String apprvstatusnm;
	private String apprvcomment;
	private LocalDateTime createdat;

}
