package br.com.estudos.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudos.gerenciador.Empresa;
import br.com.estudos.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns = "/novaEmpresa")
public class novaEmpresa extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3940375922931989175L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);

		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.adiciona(empresa);

		req.setAttribute("empresa", empresa);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}

}
