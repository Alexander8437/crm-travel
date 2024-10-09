package com.ms.jwt.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("Unauthorized error: {}", authException.getMessage());
		final Map<String, Object> body = new HashMap<>();
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		System.out.println(authException.getClass().getName());

		
		if (authException.getMessage().equalsIgnoreCase("User account is locked")) {

			body.put("error", Map.of("code", HttpServletResponse.SC_FORBIDDEN, "type", "Unauthorized", "message",
					authException.getMessage(), "details",
					"Your account has been temporarily locked due to 3 consecutive failed login attempts."
							+ "It will remain locked for 24 hours. Please try logging in again after the lockout period has expired.If you encounter any issues,"
							+ "please contact support for assistance."));

		} else {
			
			body.put("error",
					Map.of("code", HttpServletResponse.SC_UNAUTHORIZED, "type", "Unauthorized", "message",
							authException.getMessage(), "details",
							"You must be authenticated to access this endpoint. Please provide valid credentials."));

		}
		body.put("path", request.getServletPath());
		body.put("timestamp", java.time.Instant.now().toString()); //
		System.out.println("==========================" + body);
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), body);
	}

}
