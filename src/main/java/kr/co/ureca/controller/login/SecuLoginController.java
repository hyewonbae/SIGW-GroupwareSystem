package kr.co.ureca.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import kr.co.ureca.dto.Employee;
import kr.co.ureca.dto.LoginDTO;
import kr.co.ureca.service.login.LoginService;

@Controller
@RequestMapping("/security")
public class SecuLoginController {

	public static final Logger logger = LoggerFactory.getLogger(SecuLoginController.class);

	@GetMapping("/form")
	public String form() {
		return "login/secu_form"; // 스프링 프레임워크에서는 컨트롤러를 거쳐서 화면(~.jsp)을 부른다.
	}

} // class
