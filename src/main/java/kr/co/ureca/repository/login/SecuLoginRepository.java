package kr.co.ureca.repository.login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.dto.UserDTO;

@Repository
public class SecuLoginRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<RoleDTO> sequrityLoginRole(String username) {
		List<RoleDTO> list = sqlSession.selectList("SecuLoginMapper.sequrityLoginRole", username);
		return list;
	}

	public UserDTO sequrityLoginCheck(String username) {
		UserDTO user = sqlSession.selectOne("SecuLoginMapper.sequrityLoginCheck", username);
		return user;
	}

}
