package servicos;

import java.io.FileWriter;
import java.io.IOException;

import entidades.Pesquisa;

public class ServicoBD {
	
	public boolean salvar(Pesquisa pesquisa ) {
		try {
			FileWriter escritor = new FileWriter("c:\\temp\\pesquisa.txt", true);
			escritor.write(pesquisa.toString() + "\n");
			escritor.close();
			return true;
		}
		catch(IOException error) {
			error.printStackTrace();
			return false;
		}
	}
}
