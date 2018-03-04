package br.com.estudos.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudos.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroAuditoria implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String usuario = getUsuario((HttpServletRequest) request);

		System.out.println("Usuario " + usuario + " acessando a URI " + req.getRequestURI());

		chain.doFilter(request, resp);

	}

	private String getUsuario(HttpServletRequest request) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");

		if (usuario == null)
			return "<deslogado>";
		return usuario.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
