package kr.co.ureca.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.repository.member.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<RoleDTO> getAllList() {
		List<RoleDTO> roleList = roleRepository.getAllList();
		return roleList;
	} // getAllList

	public int insertRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = roleRepository.insertRole(dto);
		return successCnt;
	} // insertRole

	public int deleteRole(RoleDTO dto) {
		int successCnt = 0;
		successCnt = roleRepository.deleteRole(dto);
		return successCnt;
	} // deleteRole

} // class
