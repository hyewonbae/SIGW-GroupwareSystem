package kr.co.ureca.service.login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.co.ureca.dto.RoleDTO;
import kr.co.ureca.dto.UserDTO;
import kr.co.ureca.dto.UserRole;
import kr.co.ureca.repository.login.SecuLoginRepository;

@Service
public class SecuUserDetailsService implements UserDetailsService {

	@Autowired
	private SecuLoginRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserDTO userDTO = repository.sequrityLoginCheck(username);

		if( userDTO.getUsername() == null || userDTO.getUsername().length() < 1 ) {
			throw new UsernameNotFoundException("사용자를 찾을수 없습니다.");
		}

		List<GrantedAuthority> authorities = new ArrayList<>();

		List<RoleDTO> roleList = repository.sequrityLoginRole(username);

		for (RoleDTO dto : roleList) {
			if(dto.getRolename().equals("ADMIN")) {
				authorities.add( new SimpleGrantedAuthority( UserRole.ADMIN.getValue() ) );
			} else if(dto.getRolename().equals("USER")) {
				authorities.add( new SimpleGrantedAuthority( UserRole.USER.getValue() ) );
			} else if(dto.getRolename().equals("SYSTEM")) {
				authorities.add( new SimpleGrantedAuthority( UserRole.SYSTEM.getValue() ) );
			}
		} // for

		return new User( userDTO.getUsername(), userDTO.getPassword(), authorities );
	}

} // class
