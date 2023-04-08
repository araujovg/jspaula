package servicos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entidades.Pesquisa;

public class ServicoBD {
	
	private static final String CAMINHO_DO_ARQUIVO = "c:\\temp\\pesquisa.txt";
	
	public boolean salvar(Pesquisa pesquisa) {
		try {
			FileWriter escritor = new FileWriter(CAMINHO_DO_ARQUIVO, true);
			
			List<Pesquisa> pesquisas = procurarTodos();
			
			if(!pesquisas.isEmpty()) {
				Pesquisa ultimaPesquisa = pesquisas.get(pesquisas.size() - 1);
				pesquisa.setId(ultimaPesquisa.getId() + 1);				
				escritor.write(pesquisa.toString() + "\n");
				escritor.close();
				return true;
			}
			else {
				pesquisa.setId(1);				
				escritor.write(pesquisa.toString() + "\n");
				escritor.close();
				return true;
			}
		}
		catch(IOException error) {
			error.printStackTrace();
			return false;
		}
	}
	
	public List<Pesquisa> procurarTodos() {
		
		List<Pesquisa> todasAsPesquisas = new ArrayList<>();
		Pesquisa pesquisa = new Pesquisa();
		
		try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_DO_ARQUIVO))) {
			String linha = br.readLine();
			
			while(linha != null && !linha.isEmpty()) {
				String[] dadosPesquisa = linha.split(",");
				int id = Integer.parseInt(dadosPesquisa[0].substring(3));
				pesquisa.setId(id);
				pesquisa.setNome(dadosPesquisa[1]);
				pesquisa.setEmail(dadosPesquisa[2]);
				pesquisa.setSexo(dadosPesquisa[3]);
				pesquisa.setCheck1(dadosPesquisa[4]);
				pesquisa.setCheck2(dadosPesquisa[5]);
				pesquisa.setCheck3(dadosPesquisa[6]);
				pesquisa.setCivil(dadosPesquisa[7]);
				
				todasAsPesquisas.add(pesquisa);
				linha = br.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return todasAsPesquisas;
	}
	
	public Pesquisa procurarPeloId(int id) {
		Pesquisa pesquisa = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO_DO_ARQUIVO))) {
			String linha = br.readLine();
			
			while(linha != null) {
				String[] dadosPesquisa = linha.split(",");
				
				if(Integer.parseInt(dadosPesquisa[0].substring(3)) == id) {
					pesquisa = new Pesquisa();
					pesquisa.setId(id);
					pesquisa.setNome(dadosPesquisa[1]);
					pesquisa.setEmail(dadosPesquisa[2]);
					pesquisa.setSexo(dadosPesquisa[3]);
					pesquisa.setCheck1(dadosPesquisa[4]);
					pesquisa.setCheck2(dadosPesquisa[5]);
					pesquisa.setCheck3(dadosPesquisa[6]);
					pesquisa.setCivil(dadosPesquisa[7]);
					return pesquisa;
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return pesquisa;
	}
	
}
