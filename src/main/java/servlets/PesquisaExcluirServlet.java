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
@WebServlet("/PesquisaExcluirServlet")
public class PesquisaExcluirServlet extends HttpServlet {
	
	private static final String URL_POS_EXCLUSAO = "/confirmaInsercao.jsp";
	
	private ServicoBD servicoBd = new ServicoBD();

    public PesquisaExcluirServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		servicoBd.deletar(Integer.parseInt(request.getParameter("p_id")));
		System.out.println("Lista: " + servicoBd.procurarTodos()
		);
		
		RequestDispatcher rd = request.getRequestDispatcher(URL_POS_EXCLUSAO);
        request.setAttribute("pesquisas", servicoBd.procurarTodos());
        rd.forward(request, response);
	}

}
