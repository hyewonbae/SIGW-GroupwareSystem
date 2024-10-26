package kr.co.ureca.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.service.member.RoleService;

@Controller
@RequestMapping("/common/combo")
public class CommonComboController {

	@Autowired
	private RoleService roleService;

	@ResponseBody
	@GetMapping("/role_all")
	public List<RoleDTO> roleAll() {
		List<RoleDTO> roleList = roleService.getAllList();
		return roleList;
	} // roleAll

} // class
