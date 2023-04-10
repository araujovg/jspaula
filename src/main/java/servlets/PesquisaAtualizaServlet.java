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
@WebServlet("/PesquisaAtualizaServlet")
public class PesquisaAtualizaServlet extends HttpServlet {
	
	private ServicoBD servicoBd = new ServicoBD();

    public PesquisaAtualizaServlet() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pesquisa pesquisa = new Pesquisa();
		pesquisa = servicoBd.procurarPeloId(Integer.parseInt(request.getParameter("p_id")));

		if(Objects.isNull(pesquisa)) {
			RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
			rd.forward(request, response);
		}

		pesquisa.setNome(request.getParameter("p_nome"));
		pesquisa.setEmail(request.getParameter("p_email"));
		pesquisa.setSexo(request.getParameter("p_sexo"));
		pesquisa.setCheck1(request.getParameter("p_ck1"));
		pesquisa.setCheck2(request.getParameter("p_ck2"));
		pesquisa.setCheck3(request.getParameter("p_ck3"));
		pesquisa.setCivil(request.getParameter("p_civil"));
		servicoBd.atualizar(pesquisa);
		

		
		RequestDispatcher rd = request.getRequestDispatcher("/confirmaInsercao.jsp");
        request.setAttribute("pesquisas", servicoBd.procurarTodos());        
        rd.forward(request, response);
	}

}
