package kr.co.ureca.aop;

import java.time.LocalDateTime;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import kr.co.ureca.dto.BaseDTO;

@Aspect
@Component
public class SetCreatedAOP {

	public static final Logger logger = LoggerFactory.getLogger(SetCreatedAOP.class);

	@Before( "execution(* kr.co.ureca.controller..*.*(..))" )
	public void setCreated(JoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();

		for( Object arg : args ) {
			if ( arg instanceof BaseDTO ) {
				BaseDTO dto = (BaseDTO) arg;
				dto.setCreated(SecurityContextHolder.getContext().getAuthentication().getName());
				dto.setUpdated(SecurityContextHolder.getContext().getAuthentication().getName());
			}
		}

	} // setCreated

} // class
