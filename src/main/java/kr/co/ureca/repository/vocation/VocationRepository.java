package kr.co.ureca.repository.vocation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.ApproveDocument;
import kr.co.ureca.dto.CommonCode;
import kr.co.ureca.dto.VocationStatusDTO;

@Repository
public class VocationRepository {

	@Autowired
	private SqlSession sqlSession;

	public VocationStatusDTO getVocationStatus(String username) {
		VocationStatusDTO dto = sqlSession.selectOne("VocationMapper.getVocationStatus", username);
		return dto;
	} // getVocationStatus

	public List<CommonCode> getDocCategoryList() {
		List<CommonCode> docCategory = sqlSession.selectList("VocationMapper.getDocCategoryList");
		return docCategory;
	}

	public List<CommonCode> getDocTypeList() {
		List<CommonCode> docType = sqlSession.selectList("VocationMapper.getDocTypeList");
		return docType;
	}

	public List<CommonCode> getVocTypeList() {
		List<CommonCode> vocType = sqlSession.selectList("VocationMapper.getVocTypeList");
		return vocType;
	}

	public int insert(ApproveDocument dto) {
		int successCount = sqlSession.insert("VocationMapper.insertApprvDoc",dto);
		return successCount;
	}

	public int insertVocation(ApproveDocument dto) {
		int successCount = sqlSession.insert("VocationMapper.insertVocation",dto);
		return successCount;
	}

	public int insertApproveProcess(ApproveDocument dto) {
		int successCount = sqlSession.insert("VocationMapper.insertApproveProcess",dto);
		return successCount;
	}

} // class
