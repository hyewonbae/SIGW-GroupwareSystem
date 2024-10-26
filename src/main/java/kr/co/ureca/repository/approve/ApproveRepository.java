package kr.co.ureca.repository.approve;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.ApproveDocument;
import kr.co.ureca.dto.ApproveProcessDTO;
import kr.co.ureca.dto.ApproveStatusDTO;

@Repository
public class ApproveRepository {

	@Autowired
	private SqlSession sqlSession;

	public int apprvProcessStatus(ApproveProcessDTO dto) {
		int minStatus = sqlSession.selectOne("ApprvMapper.apprvProcessStatus", dto);
		return minStatus;
	} // apprvProcessStatus

	public int apprvDocumentUpdate(ApproveProcessDTO dto) {
		int successCount = 0;
		successCount = sqlSession.update("ApprvMapper.apprvDocumentUpdate", dto);
		return successCount;
	} // apprvDocumentUpdate

	public int apprvProcessUpdate(ApproveProcessDTO dto) {
		int successCount = 0;
		successCount = sqlSession.update("ApprvMapper.apprvProcessUpdate", dto);
		return successCount;
	} // apprvProcessUpdate

	public List<ApproveDocument> apprvList(String username) {
		List<ApproveDocument> apprvList
				= sqlSession.selectList("ApprvMapper.apprvList", username);
		return apprvList;
	} // apprvList

	public ApproveStatusDTO getApproveStatus(String username) {
		ApproveStatusDTO dto = sqlSession.selectOne("ApprvMapper.getApproveStatus", username);
		return dto;
	} // getApproveStatus

} // class
