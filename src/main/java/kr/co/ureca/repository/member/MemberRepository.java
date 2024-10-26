package kr.co.ureca.repository.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.SearchDTO;
import kr.co.ureca.dto.UserDTO;

@Repository
public class MemberRepository {

	@Autowired
	private SqlSession sqlSession;

	public Employee employeeCheck(UserDTO dto) {
		Employee emp = sqlSession.selectOne("MemberMapper.employeeCheck", dto);
		return emp;
	} // employeeCheck

	public int insertUser(UserDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.insert("MemberMapper.insertUser", dto);
		return successCnt;
	} // insertUser

	public int insertUserRole(UserDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.insert("MemberMapper.insertUserRole", dto);
		return successCnt;
	} // insertUser

	public List<UserDTO> getAllList( SearchDTO searchDTO ) {
		List<UserDTO> userList = sqlSession.selectList("MemberMapper.getAllList", searchDTO);
		return userList;
	} // getAllList

	public int deleteUser(UserDTO dto) {
		int successCnt = 0;
		successCnt = sqlSession.delete("MemberMapper.deleteUser", dto);
		return successCnt;
	} // deleteUser

} // class
