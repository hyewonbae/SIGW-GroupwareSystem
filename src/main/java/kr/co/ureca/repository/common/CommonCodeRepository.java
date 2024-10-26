package kr.co.ureca.repository.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.CommonCodeDTO;
import kr.co.ureca.dto.SearchDTO;

@Repository
public class CommonCodeRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<CommonCodeDTO> getAllList( SearchDTO searchDTO ) {
		List<CommonCodeDTO> codeList
			= sqlSession.selectList("CommonCodeMapper.getAllList", searchDTO);
		return codeList;
	} // getAllList

	public int insertCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.insert("CommonCodeMapper.insertCode", dto);
		return successCnt;
	} // insertCode

	public int deleteCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.delete("CommonCodeMapper.deleteCode", dto);
		return successCnt;
	} // deleteCode

} // class
