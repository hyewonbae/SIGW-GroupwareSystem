package kr.co.ureca.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.Employee;
import kr.co.ureca.repository.member.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public Employee getEmpByUsername( String username ) {
		Employee emp = empRepository.getEmpByUsername(username);
		return emp;
	} // getEmpByUsername

} // class
