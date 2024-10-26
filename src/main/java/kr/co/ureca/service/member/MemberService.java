package kr.co.ureca.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.MessageDTO;
import kr.co.ureca.dto.SearchDTO;
import kr.co.ureca.dto.UserDTO;
import kr.co.ureca.repository.member.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public MessageDTO employeeCheck(UserDTO dto) {
		Employee emp = memberRepository.employeeCheck(dto);

		MessageDTO messgeDTO = new MessageDTO();
		if( emp.getEmpid() != null ) { // employee 테이블에 유저가 있는 경우.
			if( emp.getUsername() != null ){ // user 테이블에 있는 경우.
				messgeDTO.setMessageName("fail");
				messgeDTO.setMessageDesc("이미 등록된 유저 입니다.");
			} else { // user 테이블에 없는 경우. ---> 유저 등록 진행.
				messgeDTO.setMessageName("success");
				messgeDTO.setMessageDesc("등록 가능한 유저 입니다.");
			}
		} else { // employee 테이블에 유저가 없는 경우.
			messgeDTO.setMessageName("fail");
			messgeDTO.setMessageDesc("존재하지 않는 아이디 입니다.");
		}

		return messgeDTO;
	} // employeeCheck

	@Transactional
	public int insertUser(UserDTO dto) {
		String tmpPWD = dto.getPassword();
		dto.setPassword( passwordEncoder.encode(tmpPWD) );

		int successCnt = 0, successCnt2 = 0;
		successCnt = memberRepository.insertUser(dto);
		successCnt2 = memberRepository.insertUserRole(dto);
		return successCnt + successCnt2;
	} // insertUser

	public List<UserDTO> getAllList( SearchDTO searchDTO ) {
		List<UserDTO> userList = memberRepository.getAllList(searchDTO);
		return userList;
	} // getAllList

	public int deleteUser(UserDTO dto) {
		int successCnt = 0;
		successCnt = memberRepository.deleteUser(dto);
		return successCnt;
	} // deleteUser

} // class
