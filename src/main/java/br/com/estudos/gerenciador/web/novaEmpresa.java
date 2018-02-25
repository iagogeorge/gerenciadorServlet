package br.com.estudos.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.estudos.gerenciador.Empresa;
import br.com.estudos.gerenciador.dao.EmpresaDAO;


@WebServlet(urlPatterns="/novaEmpresa")
public class novaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		
		EmpresaDAO empresaDao = new EmpresaDAO();
		empresaDao.adiciona(empresa);
		
		PrintWriter writer = resp.getWriter();
		writer.print("<html><body>Empresa Adicionada:"+ nome +"</body></html>");
	
//		RequestDispatcher rd = req.getRequestDispatcher("/busca");
//        rd.forward(req, resp);
	}
	
	
}