package kr.co.ureca.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.service.member.RoleService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/form")
	public String form( Model model ) {
		List<RoleDTO> roleList = roleService.getAllList();
		model.addAttribute("roleList", roleList);
		return "role/form";
	} // form

	@ResponseBody
	@PostMapping("/insert")
	public String insertRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = roleService.insertRole(dto);
		return successCnt + "";
	} // insertRole

	@ResponseBody
	@PostMapping("/delete")
	public String deleteRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = roleService.deleteRole(dto);
		return successCnt + "";
	} // deleteRole

} // class
