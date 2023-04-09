package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Pesquisa;
import servicos.ServicoBD;


@SuppressWarnings("serial")
@WebServlet("/PesquisaInclusaoServlet")
public class PesquisaInclusaoServlet extends HttpServlet {
	
	private ServicoBD servicoBd = new ServicoBD();

    public PesquisaInclusaoServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setNome(request.getParameter("p_nome"));
		pesquisa.setEmail(request.getParameter("p_email"));
		pesquisa.setSexo(request.getParameter("p_sexo"));
		pesquisa.setCheck1(request.getParameter("p_ck1"));
		pesquisa.setCheck2(request.getParameter("p_ck2"));
		pesquisa.setCheck3(request.getParameter("p_ck3"));
		pesquisa.setCivil(request.getParameter("p_civil"));
		servicoBd.salvar(pesquisa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/confirmaInsercao.jsp");
        request.setAttribute("pesquisa", pesquisa);        
        rd.forward(request, response);
	}

}
