package kr.co.ureca.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ureca.dto.ApproveStatusDTO;
import kr.co.ureca.dto.VocationStatusDTO;
import kr.co.ureca.service.approve.ApproveService;
import kr.co.ureca.service.vocation.VocationService;

@Controller
public class HomeController {

	@Autowired
	private ApproveService apprvService;

	@Autowired
	private VocationService vocationService;

	@GetMapping("/")
	public String home( Model model, Principal principal ) {
		if(	principal != null
			&& principal.getName() != null
			&& !principal.getName().equals("")) {
			//결재 상태 조회
			ApproveStatusDTO apprvDtO = apprvService.getApproveStatus( principal.getName() );
			model.addAttribute("apprvDtO", apprvDtO);
			//휴가 상태 조회
			VocationStatusDTO vocationDtO = vocationService.getVocationStatus( principal.getName() );
			model.addAttribute("vocationDtO", vocationDtO);
			System.out.println(principal.getName());
			System.out.println(vocationDtO);
		}
		return "home";
	} // home

} // class
