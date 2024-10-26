package kr.co.ureca.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.LoginDTO;
import kr.co.ureca.service.login.LoginService;

@Controller
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService service;

	@GetMapping("/login_form")
	public String form() {
		return "login/form"; // 스프링 프레임워크에서는 컨트롤러를 거쳐서 화면(~.jsp)을 부른다.
	}

	@GetMapping("/login_logout")
	public String out( HttpSession session ) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/login_rest_login")
	@ResponseBody
	public String restLogin( HttpSession session, LoginDTO loginDTO, Model model ) {
		String rtnMsg = "ok";

		Employee emp = service.loginCheck(loginDTO);
		if(emp != null && emp.getEmpid() != null && emp.getEmpid().length() > 0) {
			session.setAttribute("rebmem", emp);
		} else {
			rtnMsg = "not_ok";
		}

		return rtnMsg;
	} // restLogin

	@PostMapping("/login_login")
	public String login( HttpSession session, LoginDTO loginDTO, Model model ) {

		Employee emp = service.loginCheck(loginDTO);

		if(emp != null && emp.getEmpid() != null && !emp.getEmpid().equals("")) {
			// 로그인 성공
			session.setAttribute("rebmem", emp);
			return "redirect:/";
		} else {
			// 로그인 실패
			model.addAttribute("error_message", "login failed.");
			return "/error";
		}

	} // login

} // class
