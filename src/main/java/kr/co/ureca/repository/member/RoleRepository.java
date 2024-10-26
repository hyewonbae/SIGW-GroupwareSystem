package kr.co.ureca.repository.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.RoleDTO;

@Repository
public class RoleRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<RoleDTO> getAllList() {
		List<RoleDTO> roleList = sqlSession.selectList("RoleMapper.getAllList");
		return roleList;
	} // getAllList

	public int insertRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.insert("RoleMapper.insertRole", dto);
		return successCnt;
	} // insertRole

	public int deleteRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.delete("RoleMapper.deleteRole", dto);
		return successCnt;
	} // deleteRole

} // class
