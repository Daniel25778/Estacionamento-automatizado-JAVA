package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import br.com.estacionafacil.model.Cliente;

public class ClienteDao {
	
	
	private Cliente cliente;
	public String LOCAL_ARQUIVO = "C:/Users/21192960/movimento.txt";
	
	public Cliente getCliente() {
		return cliente;
	}

	public ClienteDao(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public ClienteDao() {

	}

	public  void salvar() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(cliente.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			
            e.printStackTrace();
			//System.out.println("Não foi possível gravar os dados!");
		}

	}
	
	
	public  void salvarSaida() {

		Path path = Paths.get(LOCAL_ARQUIVO);

		try {

			BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("ISO-8859-1"),
					StandardOpenOption.WRITE, StandardOpenOption.APPEND);

			writer.write(cliente.toString());
			writer.newLine();
			writer.close();

		} catch (Exception e) {
			
            e.printStackTrace();
			//System.out.println("Não foi possível gravar os dados!");
		}

	}
	
	public ArrayList<Cliente> listarClientes() {
		// Procedimento para abrir um arquivo para leitura ou escrita

		// Passo 1 - Obter o caminho do arquivo
		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo

		try {

	        BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
            
	        String linha = reader.readLine();
	        ArrayList<Cliente> clientes = new ArrayList<>();
	        
	        while (linha != null) {
	           String[]vetorCliente = linha.split(";");
	           
	           Cliente cliente = new Cliente();
	           cliente.setCodigo(vetorCliente[0]);
	           cliente.setPlaca(vetorCliente[1]);
	           cliente.setModelo(vetorCliente[2]);
	           cliente.setDataDeEntrada(vetorCliente[3]);
	          
	           clientes.add(cliente);
	           
			
	           linha = reader.readLine();
	        }
	        
	        System.out.println(clientes);
	        
	        reader.close();
	 
	        return clientes;
	        
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	

	public Cliente buscarClientes(String placa) {
		// Procedimento para abrir um arquivo para leitura ou escrita

		// Passo 1 - Obter o caminho do arquivo
		Path path = Paths.get(LOCAL_ARQUIVO);

		// Criar o Buffer para o arquivo

		try {

	        BufferedReader reader = Files.newBufferedReader(path, Charset.forName("ISO-8859-1"));
            
	        String linha = reader.readLine();
	        Cliente cliente = new Cliente();
	        
	        while (linha != null) {
	           String[]vetorCliente = linha.split(";");
	           
	           if (vetorCliente[1].equals(placa)) {
	          
		           cliente.setModelo(vetorCliente[2]);
		           cliente.setHoraDeEntrada(vetorCliente[3]);
		           cliente.setDataDeEntrada(vetorCliente[4]);
		           cliente.setHoraDeSaida(vetorCliente[5]);
		           cliente.setDataDeSaida((vetorCliente[6]));
		           cliente.setTempoEstacionado(vetorCliente[7]);
		           cliente.setValorDePagamento(vetorCliente[8]);
		           break;
	          
	           }
			
	           linha = reader.readLine();
	        }
	        
	       
	        reader.close();
	 
	        return cliente;
	        
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	
}
