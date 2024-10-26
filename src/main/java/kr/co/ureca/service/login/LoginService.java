package kr.co.ureca.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.LoginDTO;
import kr.co.ureca.repository.login.LoginRepository;

@Service
public class LoginService {

	@Autowired
	LoginRepository repository;

	public Employee loginCheck(LoginDTO loginDTO) {
		Employee emp = repository.loginCheck(loginDTO);
		return emp;
	}

}
