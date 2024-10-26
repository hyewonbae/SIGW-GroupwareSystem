package kr.co.ureca.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.CommonCodeDTO;
import kr.co.ureca.dto.SearchDTO;
import kr.co.ureca.repository.common.CommonCodeRepository;

@Service
public class CommonCodeService {

	@Autowired
	private CommonCodeRepository commonCodeRepository;

	public List<CommonCodeDTO> getAllList( SearchDTO searchDTO ) {
		List<CommonCodeDTO> codeList = commonCodeRepository.getAllList( searchDTO );
		return codeList;
	} // getAllList

	public int insertCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = commonCodeRepository.insertCode(dto);
		return successCnt;
	} // insertCode

	public int deleteCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = commonCodeRepository.deleteCode(dto);
		return successCnt;
	} // deleteCode

} // class
