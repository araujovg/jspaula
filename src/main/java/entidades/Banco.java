package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import excecoes.ObjectNotFoundException;

public class Banco {
	
private static List<Pesquisa> pesquisas = new ArrayList<>();
	
	static {
		Pesquisa p1 = new Pesquisa();
		p1.setId(1);
		p1.setNome("José das Couves");
		p1.setEmail("ze@dascouves.com");
		p1.setSexo("masculino");
		p1.setCheck1(null);
		p1.setCheck2("Aventura");
		p1.setCheck3(null);
		p1.setCivil("casado(a)");
		
		Pesquisa p2 = new Pesquisa();
		p2.setId(2);
		p2.setNome("Marta Wayne");
		p2.setEmail("marta@wayneenterprises.com");
		p2.setSexo("feminino");
		p2.setCheck1("Romance");
		p2.setCheck2("Aventura");
		p2.setCheck3(null);
		p2.setCivil("casado(a)");
		
		pesquisas.add(p1);
		pesquisas.add(p2);
	}

	public Pesquisa addPesquisa(Pesquisa novaPesquisa) {
		pesquisas.add(novaPesquisa);
		return novaPesquisa;
	}
	
	public Pesquisa atualizar(Pesquisa pesquisaAtualizada) {
		Pesquisa pesquisa = procurarPeloId(pesquisaAtualizada.getId());
		if(pesquisas.contains(pesquisa)) {
			pesquisas.remove(pesquisa);
			pesquisas.add(pesquisaAtualizada);			
		}
		return pesquisaAtualizada;
	}
	
	public List<Pesquisa> getPesquisas(){
		return Banco.pesquisas;
	}
	
	public Pesquisa procurarPeloId(int id) {
		try {
			Pesquisa pesquisa = getPesquisas()
					.stream()
					.filter( p -> p.getId() == id)
					.collect(Collectors.toList())
					.get(0);
			
			return pesquisa;
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
		 
	}
	
	public Pesquisa procurarPeloEmail(String email) {
		try {
			Pesquisa pesquisa = this.getPesquisas()
					.stream()
					.filter( p -> p.getEmail().equals(email))
					.collect(Collectors.toList())
					.get(0); 
			return pesquisa;
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public boolean deletar(int id) {
		return getPesquisas().remove(procurarPeloId(id));
	}
	
}
