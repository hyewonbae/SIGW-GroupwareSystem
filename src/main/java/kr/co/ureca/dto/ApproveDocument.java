package kr.co.ureca.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApproveDocument {
	private int docid;
	private String year;
	private int doccategory;
	private String doccategorynm;
	private String deptid;
	private String deptname;
	private String empid;
	private String empname;
	private int doctype;
	private String doctypenm;
	private int apprvstatus;
	private String apprvstatusnm;
	private String created;
	private LocalDateTime createdat;
	private String updated;
	private LocalDateTime updatedat;

	private String doctitle;
	private int voctype;
	private String reqtime;
	private String doccontent;
	private String satartdate;
	private String enddate;

	private List<String> apprvArray;

	private String apprvid;
	private String apprvseq;
	private String apprvcomment;
	private String apprvProStatus;
	private String apprvProStatusNM;

	private String preStatus;

}
