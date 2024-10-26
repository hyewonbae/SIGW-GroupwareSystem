package kr.co.ureca.controller.vocation;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import kr.co.ureca.controller.login.LoginController;
import kr.co.ureca.dto.ApproveDocument;
import kr.co.ureca.dto.ApproveProcessDTO;
import kr.co.ureca.dto.CommonCode;
import kr.co.ureca.dto.Department;
import kr.co.ureca.dto.Employee;
import kr.co.ureca.service.approve.ApproveService;
import kr.co.ureca.service.department.DeptService;
import kr.co.ureca.service.member.EmployeeService;
import kr.co.ureca.service.vocation.VocationService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/vocation")
public class VocationController {

	public static final Logger logger = LoggerFactory.getLogger(VocationController.class);

	@Autowired
	private VocationService service;

	@Autowired
	private DeptService deptService;

	@Autowired
	private EmployeeService empService;

	@Autowired
	private ApproveService apprvService;

	@PostMapping("/apprv/update")
	@ResponseBody
	public String apprvUpdate( ApproveProcessDTO dto ) {

		int successCount = 0;
		successCount = apprvService.apprvUpdate(dto);

		return successCount + "";
	} // apprvUpdate

	@GetMapping("/apprv/list")
	public String apprvList(Model model, Principal principal) {
		List<ApproveDocument> aprvDocList = apprvService.apprvList( principal.getName() );
		model.addAttribute("aprvDocList", aprvDocList);
		return "vocation/apprv_list";
	} // apprvList

	@PostMapping("/insert")
	@ResponseBody
	public String insert( ApproveDocument dto ) {

		int successCount = 0;
		successCount = service.insert(dto);

		return successCount + "";
	} // insert

	@GetMapping("/form")
	public String form( HttpSession session, Model model, Principal principal ) {

		Employee emp = empService.getEmpByUsername(principal.getName());
		model.addAttribute("employee", emp);

		//Employee emp = (Employee) session.getAttribute("rebmem");
		List<Department> deptList = deptService.getApprvLine(emp);
		model.addAttribute("deptList", deptList);

		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
		String toDateStr = format.format(today);
		model.addAttribute("toDate", toDateStr);

		List<CommonCode> docCategoryList = service.getDocCategoryList();
		model.addAttribute("docCategoryList", docCategoryList);

		List<CommonCode> docTypeList = service.getDocTypeList();
		model.addAttribute("docTypeList", docTypeList);

		List<CommonCode> vocTypeList = service.getVocTypeList();
		model.addAttribute("vocTypeList", vocTypeList);

		return "vocation/form";
	} // home

} // class
