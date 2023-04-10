package servicos;

import java.util.List;
import java.util.Objects;

import entidades.Banco;
import entidades.Pesquisa;

public class ServicoBD {
	
	Banco banco = new Banco();
	
	public Pesquisa salvar(Pesquisa pesquisa) {
					
		List<Pesquisa> pesquisas = procurarTodos();
		
		if(!pesquisas.isEmpty()) {
			Pesquisa ultimaPesquisa = pesquisas.get(pesquisas.size() - 1);
			pesquisa.setId(ultimaPesquisa.getId() + 1);				
			return banco.addPesquisa(pesquisa);
		}
		else {
			pesquisa.setId(1);
			return banco.addPesquisa(pesquisa);
		}
	}
	
	public Pesquisa atualizar(Pesquisa pesquisa) {
		Pesquisa pesquisaSalva = procurarPeloId(pesquisa.getId());
		
		if(!Objects.isNull(pesquisaSalva)) {
			pesquisaSalva.setNome(pesquisa.getNome());
			pesquisaSalva.setEmail(pesquisa.getEmail());
			pesquisaSalva.setSexo(pesquisa.getSexo());
			pesquisaSalva.setCheck1(pesquisa.getCheck1());
			pesquisaSalva.setCheck2(pesquisa.getCheck2());
			pesquisaSalva.setCheck3(pesquisa.getCheck3());
			pesquisaSalva.setCivil(pesquisa.getCivil());
		}
		return banco.atualizar(pesquisaSalva);
	}
	
	public void deletar(int id) {
		banco.deletar(id);
	}
	
	public List<Pesquisa> procurarTodos() {	
		return banco.getPesquisas();
	}
	
	public Pesquisa procurarPeloId(int id) {
		return banco.procurarPeloId(id);	
	}
	
	public Pesquisa procurarPeloEmail(String email) {
		return banco.procurarPeloEmail(email);
	}
	
}
