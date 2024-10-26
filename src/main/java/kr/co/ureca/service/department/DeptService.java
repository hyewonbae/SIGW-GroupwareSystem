package kr.co.ureca.service.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.Department;
import kr.co.ureca.dto.Employee;
import kr.co.ureca.repository.department.DeptRepository;

@Service
public class DeptService {

	@Autowired
	private DeptRepository repository;

	public List<Department> getApprvLine(Employee emp) {
		List<Department> deptList = repository.getApprvLine(emp);
		return deptList;
	}

}
