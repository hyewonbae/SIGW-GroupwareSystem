package kr.co.ureca.service.vocation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ureca.dto.ApproveDocument;
import kr.co.ureca.dto.CommonCode;
import kr.co.ureca.dto.VocationStatusDTO;
import kr.co.ureca.repository.vocation.VocationRepository;

@Repository
public class VocationService {

	@Autowired
	private VocationRepository vocationRepository;

	public VocationStatusDTO getVocationStatus(String username) {
		VocationStatusDTO dto = vocationRepository.getVocationStatus(username);
		return dto;
	} // getVocationStatus

	public List<CommonCode> getDocCategoryList() {
		List<CommonCode> docCategory = vocationRepository.getDocCategoryList();
		return docCategory;
	}

	public List<CommonCode> getDocTypeList() {
		List<CommonCode> docType = vocationRepository.getDocTypeList();
		return docType;
	}

	public List<CommonCode> getVocTypeList() {
		List<CommonCode> vocType = vocationRepository.getVocTypeList();
		return vocType;
	}

	@Transactional
	public int insert(ApproveDocument dto) {
		int successCount = 0;
		successCount += vocationRepository.insert(dto);
		successCount += vocationRepository.insertVocation(dto);
		successCount += vocationRepository.insertApproveProcess(dto);
		return successCount;
	}

} // class
