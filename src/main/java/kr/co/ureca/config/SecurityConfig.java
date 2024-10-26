package kr.co.ureca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 필터 체인 등록.
@EnableMethodSecurity(prePostEnabled = true) // @PreAuthorize, @PreFilter, @PostAuthorize, @PostFilter
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder encodePassWord() {
		return new BCryptPasswordEncoder();
	} // encodePassWord

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.csrf(CsrfConfigurer::disable)
					.authorizeHttpRequests(
							authorize -> authorize
							.requestMatchers("/role/**").hasRole("SYSTEM")
							.requestMatchers("/member/**").hasRole("ADMIN")
							.anyRequest().permitAll()
					)
					.formLogin(formLogin -> {
						formLogin.loginPage("/security/form")
						.loginProcessingUrl("/login")
						.defaultSuccessUrl("/");
					})
					.logout( logout -> logout
										.logoutRequestMatcher( new AntPathRequestMatcher("/logout") )
										.logoutSuccessUrl("/")
										.invalidateHttpSession(true) );

		return httpSecurity.build();

	} // filterChain

} // class
