package br.com.estudos.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.estudos.gerenciador.Usuario;
import br.com.estudos.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -855230448125135461L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		PrintWriter writer = resp.getWriter();
		if (usuario == null) {
			writer.println("<html><body>usuario nao cadastrado !!!</body></html>");
		} else {

			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usuario);

			writer.print("<html><body>usuario logado: " + email + "</body></html>");
		}

	}

}
