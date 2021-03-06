package de.hhn.se.embedded.zigbee.backend.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;

		HttpServletRequest request = (HttpServletRequest) req;

		response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");

		response.setHeader("Access-Control-Allow-Methods",
				"POST, PUT, PATCH, GET, OPTIONS, DELETE");
		
		response.setHeader("Access-Control-Allow-Credentials", "true");

		response.setHeader("Access-Control-Max-Age", "3600");

		response.setHeader("Access-Control-Allow-Headers",
				"x-requested-with, AUTHORIZATION, content-type, X-AUTH-TOKEN");
		
		response.setHeader("Access-Control-Expose-Headers", "X-AUTH-TOKEN");

		if (!request.getMethod().equals("OPTIONS")) {

			chain.doFilter(req, res);

		}

	}

	public void init(FilterConfig filterConfig) {

	}

	public void destroy() {

	}

}