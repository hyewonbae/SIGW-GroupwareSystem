package kr.co.ureca.service.approve;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ureca.dto.ApproveDocument;
import kr.co.ureca.dto.ApproveProcessDTO;
import kr.co.ureca.dto.ApproveStatusDTO;
import kr.co.ureca.repository.approve.ApproveRepository;

@Service
public class ApproveService {

	@Autowired
	private ApproveRepository apprvRepository;

	@Transactional
	public int apprvUpdate(ApproveProcessDTO dto) {
		int successCount = 0, successCount2 = 0;
		successCount = apprvRepository.apprvProcessUpdate(dto);
		if(dto.getApprvstatus() == 3) {
			int minStatus = apprvRepository.apprvProcessStatus(dto);
			if(minStatus == 1) { //다른 사람들 중에 1이 있음 -> document는 2.
				dto.setApprvstatus(2);
			} else if(minStatus == 3) { //다른 사람들이 모두 3 -> document도 3.
				//문제 안됨
			}
		} else if(dto.getApprvstatus() == 4) { // 반려.
			//문제 안됨
		}
		successCount2 = apprvRepository.apprvDocumentUpdate(dto);
		return successCount + successCount2;
	} // apprvUpdate

	public List<ApproveDocument> apprvList(String username) {
		List<ApproveDocument> apprvList = apprvRepository.apprvList(username);
		return apprvList;
	} // apprvList

	public ApproveStatusDTO getApproveStatus(String username) {
		ApproveStatusDTO dto = apprvRepository.getApproveStatus(username);
		return dto;
	} // getApproveStatus

} // class
