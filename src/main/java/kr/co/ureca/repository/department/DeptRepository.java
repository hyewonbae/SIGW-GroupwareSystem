package kr.co.ureca.repository.department;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ureca.dto.Department;
import kr.co.ureca.dto.Employee;

@Repository
public class DeptRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<Department> getApprvLine(Employee emp) {
		List<Department> deptList = sqlSession.selectList("DeptMapper.getApprvLine", emp);
		return deptList;
	}

}
