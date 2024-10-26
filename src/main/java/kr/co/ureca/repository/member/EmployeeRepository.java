package kr.co.ureca.repository.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private SqlSession sqlSession;

	public Employee getEmpByUsername(String username) {
		Employee emp = sqlSession.selectOne("EmpMapper.getEmpByUsername", username);
		return emp;
	}

} // class
