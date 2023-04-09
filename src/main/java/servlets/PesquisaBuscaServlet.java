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
    	
    	Pesquisa pesquisa = new Pesquisa();
		pesquisa = servicoBd.procurarPeloEmail(request.getParameter("p_email"));
		if(Objects.isNull(pesquisa)) {
			throw new ObjectNotFoundException("A pesquisa não encontrou resultados");
		}
		
		response.sendRedirect("resultadoPesquisa.html");
    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa.setEmail(request.getParameter("p_email"));
		servicoBd.salvar(pesquisa);
		
		/*RequestDispatcher rd = request.getRequestDispatcher("/confirmaInsercao.jsp");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);*/
	}

}
