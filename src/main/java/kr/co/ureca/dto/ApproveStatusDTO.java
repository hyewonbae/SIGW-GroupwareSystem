package kr.co.ureca.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ApproveStatusDTO {

	public String cntApprvUp; // 내가 올린 결제 건수.

	public String cntApprvIng; // 내가 올린 결제 건수에서 결제가 진행되고 있는 건수.

	public String cntApprvComplete; // 내가 올린 결제 건수에서 결제가 완료된 건수.

	public String cntApprvReturn; // 내가 올린 결제 건수에서 결제가 반려된 건수.

	public String cntApprvWait; // 내가 진행해야되는 결제 건수.

} // class
