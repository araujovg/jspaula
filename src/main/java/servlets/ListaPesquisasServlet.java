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
@WebServlet("/ListaPesquisasServlet")
public class ListaPesquisasServlet extends HttpServlet {
	
	private ServicoBD servicoBd = new ServicoBD();

    public ListaPesquisasServlet() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher rd = request.getRequestDispatcher("/confirmaInsercao.jsp");
        request.setAttribute("pesquisas", servicoBd.procurarTodos());        
        rd.forward(request, response);
	}

}
