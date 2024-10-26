package kr.co.ureca.controller.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ureca.dto.CommonCodeDTO;
import kr.co.ureca.dto.SearchDTO;
import kr.co.ureca.service.common.CommonCodeService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/commoncode")
public class CommonCodeController {

	@Autowired
	private CommonCodeService commonCodeService;

	@PreAuthorize("hasRole('SYSTEM')")
	@GetMapping("/form")
	public String form( SearchDTO searchDTO, Model model ) {

		List<CommonCodeDTO> codeList = commonCodeService.getAllList( searchDTO );

		model.addAttribute("codeList", codeList);
		model.addAttribute("searchDTO", searchDTO);

		return "commoncode/form";
	} // form

	@PreAuthorize("hasRole('SYSTEM')")
	@ResponseBody
	@PostMapping("/insert")
	public String insertCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = commonCodeService.insertCode(dto);
		return successCnt + "";
	} // insertCode

	@PreAuthorize("hasRole('SYSTEM')")
	@ResponseBody
	@PostMapping("/delete")
	public String deleteCode(CommonCodeDTO dto) {
		int successCnt = 0;
		successCnt = commonCodeService.deleteCode(dto);
		return successCnt + "";
	} // deleteCode

} // class
