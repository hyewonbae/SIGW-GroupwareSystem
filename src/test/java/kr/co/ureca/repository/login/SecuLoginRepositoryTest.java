package kr.co.ureca.repository.login;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.ureca.dto.UserDTO;

@SpringBootTest
class SecuLoginRepositoryTest {

	@Autowired
	private SecuLoginRepository repository;

	@Test
	void test() {
		UserDTO userDTO = repository.sequrityLoginCheck("2024070901");
		System.out.println(userDTO);
	}

}
