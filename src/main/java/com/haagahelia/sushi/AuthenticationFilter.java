/**
Project name: sushi
File name: AuthenticationFilter.java
Author: Lorenzo Lamberti
Date of creation: 27 nov. 2018
*/
package com.haagahelia.sushi;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.haagahelia.sushi.AuthenticationService;

public class AuthenticationFilter extends GenericFilterBean {
	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	    Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest)request);
	    SecurityContextHolder.getContext().
        setAuthentication(authentication);
    filterChain.doFilter(request, response);
  }
}
