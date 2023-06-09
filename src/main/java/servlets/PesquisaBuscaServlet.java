package servlets;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Pesquisa;
import excecoes.ObjectNotFoundException;
import servicos.ServicoBD;


@SuppressWarnings("serial")
@WebServlet("/PesquisaBuscaServlet")
public class PesquisaBuscaServlet extends HttpServlet {
	
	private ServicoBD servicoBd = new ServicoBD();

    public PesquisaBuscaServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa = servicoBd.procurarPeloEmail(request.getParameter("p_email"));
		
		if(Objects.isNull(pesquisa)) {
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/resultadoBusca.jsp");
        request.setAttribute("pesquisa", pesquisa);        
        rd.forward(request, response);
	}

}
