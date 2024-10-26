package kr.co.ureca.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.dto.MessageDTO;
import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.dto.SearchDTO;
import kr.co.ureca.dto.UserDTO;
import kr.co.ureca.service.member.MemberService;
import kr.co.ureca.service.member.RoleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/form")
	public String form( SearchDTO searchDTO, Model model ) {
		List<UserDTO> userList = memberService.getAllList(searchDTO);
		model.addAttribute("userList", userList);
		return "member/form";
	} // form

	@ResponseBody
	@PostMapping("/emp_check")
	public MessageDTO employeeCheck(UserDTO dto) {
		MessageDTO messageDTO = memberService.employeeCheck(dto);

		return messageDTO;
	} // employeeCheck

	@ResponseBody
	@PostMapping("/insert")
	public String insertUser(UserDTO dto) {
		int successCnt = 0;
		successCnt = memberService.insertUser(dto);
		return successCnt + "";
	} // insertUser

	@ResponseBody
	@PostMapping("/delete")
	public String deleteUser(UserDTO dto) {
		int successCnt = 0;
		successCnt = memberService.deleteUser(dto);
		return successCnt + "";
	} // deleteUser

} // class
