package kr.co.ureca.dto;

import lombok.Getter;

@Getter
public enum UserRole {

	SYSTEM("ROLE_SYSTEM"),
	ADMIN("ROLE_ADMIN"),
	USER("ROLE_USER");

	private String value;

	UserRole(String value) {
		this.value = value;
	}

}
