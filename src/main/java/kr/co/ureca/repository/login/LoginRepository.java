package kr.co.ureca.repository.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.LoginDTO;

@Repository
public class LoginRepository {

	@Autowired
	private SqlSession sqlSession;

	public Employee loginCheck(LoginDTO loginDTO) {
		Employee emp = sqlSession.selectOne("LoginMapper.loginCheck", loginDTO);
		return emp;
	}

}




