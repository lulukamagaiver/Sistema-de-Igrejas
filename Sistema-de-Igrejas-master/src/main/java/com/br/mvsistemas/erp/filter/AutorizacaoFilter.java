package com.br.mvsistemas.erp.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.mvsistemas.erp.model.AdmUsuario;
import com.br.mvsistemas.erp.model.Usuario;

@WebFilter("*.xhtml")
public class AutorizacaoFilter implements Filter{
	
	@Inject
	private AdmUsuario admUsuario;

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req	, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		
		if (!admUsuario.isLogado()
		&& !request.getRequestURI().endsWith("/Login.xhtml")
		&& !request.getRequestURI()
		.contains("/javax.faces.resource/")) {
		response.sendRedirect(request.getContextPath()
		+ "/Login.xhtml");
		} else {
		chain.doFilter(req, res);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
