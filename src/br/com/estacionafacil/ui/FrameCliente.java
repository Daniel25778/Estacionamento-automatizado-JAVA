package br.com.estacionafacil.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Position;

import br.com.estacionafacil.model.Cliente;
import dao.ClienteDao;

import util.Util;



public class FrameCliente {
	
	Cliente cliente = new Cliente();

	
	public Label labelHoraDeEntrada;
	public Label labelValorApagar;
	public Label labelHoraDeSaida;
	public Label labelDataDeEntrada;
	public Label labelDataDeSaida;
	public Label labelTempoEstacionado;
	public Label labelEntrada;
	public Label labelSaida;
	public Label labelPlaca;
	public Label labelPlacaSaida;
	public Label labelModelo;
	public Label labelModeloSaida;
	public TextField textPlaca;
	public TextField textValorApagar;
	public TextField textPlacaSaida;
	public TextField textModelo;
	public TextField textModeloSaida;
	public TextField textDataDeEntrada;
	public TextField textDataDeSaida;
	public TextField textHoraDeEntrada;
	public TextField textTempoEstacionado;
	public TextField textHoraDeSaida;
	public JButton buttonEntrar;
	public JButton buttonEfetuarSaida;
	public JButton buttonBuscar;
	public JButton buttonEncerrarSistema;
	
    private JScrollPane scrollTable;//Criar barra de rolagem caso a tabela for maior que a tela

	JTable tabelaClientes;//Tabela
	private DefaultTableModel tabelaClientesModelo;//Modelo de tabela padrão do Java
	
	
	
	public void criarTela() {
		
		
		JFrame tela = new JFrame();
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Estaciona Fácil");
		tela.setSize(548, 590);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
		Color minhaCor = new Color(112,173,71);
		Color meuAzul = new Color(31,125,229);
		Font entrada = new Font("Consolas", Font.BOLD, 15); // definindo como sera o texto
		Font saida = new Font("Consolas", Font.BOLD, 15); // definindo como sera o texto
		Font placa = new Font("Consolas", 0, 11); // definindo como sera o texto
		Font modelo = new Font("Consolas", 0, 11); // definindo como sera o texto
		Font caixaDeTextoPlaca = new Font("Consolas", 0, 15); // definindo como sera o texto
		Font caixaDeTextoValorApagar = new Font("Consolas", 0, 40); // definindo como sera o texto
		Font algumasLabels = new Font("Consolas", 0, 8); // definindo como sera o texto
		Font botaoEfetuarSaida = new Font("Consolas", 0, 11); // definindo como sera o texto
		
		
		
		
		labelEntrada = new Label("ENTRADA");
		labelEntrada.setBounds(10, 5, 100, 50);
		labelEntrada.setFont(entrada);
		labelEntrada.setForeground(minhaCor);
		
		labelPlaca = new Label("PLACA:");
		labelPlaca.setBounds(10, 37, 100, 50);
		labelPlaca.setFont(placa);
		
		
		textPlaca = new TextField();
		textPlaca.setBounds(10, 85, 200, 25);
		textPlaca.setFont(caixaDeTextoPlaca);
		textPlaca.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor 
	
		labelModelo = new Label("MODELO:");
		labelModelo.setBounds(220, 40, 100, 45);
		labelModelo.setFont(modelo);
		
		
		textModelo = new TextField();
		textModelo.setBounds(220, 85, 200, 25);
		textModelo.setFont(caixaDeTextoPlaca);
		textModelo.setForeground(Color.GREEN);//Deixar o texto digitado pelo o usuario, com cor
		
		buttonEntrar = new JButton("ENTRAR");
		buttonEntrar.setBounds(430, 83, 92, 30);
		buttonEntrar.setBackground(meuAzul);
		buttonEntrar.setForeground(Color.WHITE);
		
		labelSaida = new Label("SAÍDA");
		labelSaida.setBounds(10, 290, 50, 50);
		labelSaida.setFont(entrada);
		labelSaida.setForeground(minhaCor);
		

		labelPlacaSaida = new Label("PLACA:");
		labelPlacaSaida.setBounds(10, 320, 50, 50);
		labelPlacaSaida.setFont(placa);
		
		
		textPlacaSaida = new TextField();
		textPlacaSaida.setBounds(10, 365, 110, 25);
		textPlacaSaida.setFont(caixaDeTextoPlaca);
		textPlacaSaida.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor 
		
		
		buttonBuscar = new JButton("BUSCAR");
		buttonBuscar.setBounds(130, 365, 92, 30);
		buttonBuscar.setBackground(meuAzul);
		buttonBuscar.setForeground(Color.WHITE);
		
        
		labelModeloSaida = new Label("MODELO:");
		labelModeloSaida.setBounds(10, 400, 50, 30);
		labelModeloSaida.setFont(modelo);
		
		textModeloSaida = new TextField();
		textModeloSaida.setBounds(10, 430, 110, 25);
		textModeloSaida.setFont(caixaDeTextoPlaca);
		textModeloSaida.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		textDataDeEntrada = new TextField();
		textDataDeEntrada.setBounds(125, 430, 85, 25);
		textDataDeEntrada.setFont(caixaDeTextoPlaca);
		textDataDeEntrada.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		labelDataDeEntrada = new Label("DATA DE ENTRADA:");
		labelDataDeEntrada.setBounds(125, 400, 80, 30);
		labelDataDeEntrada.setFont(algumasLabels);
		
		textHoraDeEntrada = new TextField();
		textHoraDeEntrada.setBounds(215, 430, 85, 25);
		textHoraDeEntrada.setFont(caixaDeTextoPlaca);
		textHoraDeEntrada.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		labelHoraDeEntrada = new Label("HORA DE ENTRADA:");
		labelHoraDeEntrada.setBounds(215, 400, 80, 30);
		labelHoraDeEntrada.setFont(algumasLabels);
		
		
		textHoraDeSaida = new TextField();
		textHoraDeSaida.setBounds(305, 430, 85, 25);
		textHoraDeSaida.setFont(caixaDeTextoPlaca);
		textHoraDeSaida.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		labelHoraDeSaida = new Label("HORA DE SAIDA:");
		labelHoraDeSaida.setBounds(305, 400, 80, 30);
		labelHoraDeSaida.setFont(algumasLabels);
		
		
		textDataDeSaida = new TextField();
		textDataDeSaida.setBounds(395, 430, 85, 25);
		textDataDeSaida.setFont(caixaDeTextoPlaca);
		textDataDeSaida.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		
		labelDataDeSaida = new Label("DATA DE SAÍDA:");
		labelDataDeSaida.setBounds(395, 400, 80, 30);
		labelDataDeSaida.setFont(algumasLabels);
		
		
		
		textTempoEstacionado = new TextField();
		textTempoEstacionado.setBounds(485, 430, 30, 25);
		textTempoEstacionado.setFont(caixaDeTextoPlaca);
		textTempoEstacionado.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		
		labelTempoEstacionado = new Label("TEMPO:");
		labelTempoEstacionado.setBounds(485, 400, 80, 30);
		labelTempoEstacionado.setFont(algumasLabels);
		

		labelValorApagar = new Label("VALOR A PAGAR:");
		labelValorApagar.setBounds(10, 490, 92, 30);
		labelValorApagar.setFont(modelo);
		
		textValorApagar = new TextField();
		textValorApagar.setBounds(105, 470, 170, 70);
		textValorApagar.setFont(caixaDeTextoValorApagar);
		textValorApagar.setForeground(minhaCor);//Deixar o texto digitado pelo o usuario, com cor
		
		buttonEfetuarSaida = new JButton("EFETUAR SAÍDA");
		buttonEfetuarSaida.setBounds(280, 470, 120, 70);
		buttonEfetuarSaida.setBackground(meuAzul);
		buttonEfetuarSaida.setFont(botaoEfetuarSaida);
		buttonEfetuarSaida.setForeground(Color.WHITE);
		
		
		buttonEncerrarSistema = new JButton("FECHAR SISTEMA");
		buttonEncerrarSistema.setBounds(400, 470, 120, 70);
		buttonEncerrarSistema.setBackground(Color.RED);
		buttonEncerrarSistema.setFont(botaoEfetuarSaida);
		buttonEncerrarSistema.setForeground(Color.WHITE);
		
		
		criarTabela();
	
		
		tela.getContentPane().add(labelHoraDeEntrada);
		tela.getContentPane().add(labelValorApagar);
		tela.getContentPane().add(labelHoraDeSaida);
		tela.getContentPane().add(labelDataDeEntrada);
		tela.getContentPane().add(labelDataDeSaida);
		tela.getContentPane().add(labelTempoEstacionado);
		tela.getContentPane().add(buttonEntrar);
		tela.getContentPane().add(buttonEncerrarSistema);
		tela.getContentPane().add(buttonBuscar);
		tela.getContentPane().add(buttonEfetuarSaida);
		tela.getContentPane().add(labelSaida);
		tela.getContentPane().add(labelModelo);
		tela.getContentPane().add(labelModeloSaida);
		tela.getContentPane().add(textPlaca);
		tela.getContentPane().add(textTempoEstacionado);
		tela.getContentPane().add(textHoraDeEntrada);
		tela.getContentPane().add(textHoraDeSaida);
		tela.getContentPane().add(textPlacaSaida);
		tela.getContentPane().add(textModelo);
		tela.getContentPane().add(textValorApagar);
		tela.getContentPane().add(textDataDeEntrada);
		tela.getContentPane().add(textDataDeSaida);
		tela.getContentPane().add(textModeloSaida);
		tela.getContentPane().add(labelPlaca);
		tela.getContentPane().add(labelPlacaSaida);
		tela.getContentPane().add(labelEntrada);
		tela.getContentPane().add(scrollTable);
		
		tela.setVisible(true);
	   
		
		buttonBuscar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cliente cliente = new Cliente();
				ClienteDao dao = new ClienteDao();
				cliente = dao.buscarClientes(textPlacaSaida.getText());

				textModeloSaida.setText(cliente.getModelo());
				textDataDeEntrada.setText(cliente.getDataDeEntrada());
				textHoraDeEntrada.setText(cliente.getHoraDeEntrada());
			   textDataDeSaida.setText(Util.converterData(LocalDate.now()));
			   textHoraDeSaida.setText(Util.coverterHora(LocalTime.now()));
			   
			   cliente.setCodigo(Util.gerarCodigo());
				cliente.setPlaca(textPlaca.getText().trim().toUpperCase());
				cliente.setModelo(textModelo.getText().trim().toUpperCase());
				cliente.setModelo(textModelo.getText().trim().toUpperCase());
				cliente.setDataDeEntrada(Util.converterData(LocalDate.now()));
				cliente.setDataDeSaida(Util.converterData(LocalDate.now()));
				cliente.setHoraDeEntrada(Util.coverterHora(LocalTime.now()));
				cliente.setHoraDeSaida(Util.coverterHora(LocalTime.now()));
				
			   
			   dao.salvarSaida();
						
				}
				
				
				
				
			}
		);
		
		
		buttonEntrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(validarFormulario()) {
					
					cliente.setCodigo(Util.gerarCodigo());
					cliente.setPlaca(textPlaca.getText().trim().toUpperCase());
					cliente.setModelo(textModelo.getText().trim().toUpperCase());
					cliente.setModelo(textModelo.getText().trim().toUpperCase());
					cliente.setDataDeEntrada(Util.converterData(LocalDate.now()));
					cliente.setDataDeSaida(null);
					cliente.setHoraDeEntrada(Util.coverterHora(LocalTime.now()));
					cliente.setHoraDeSaida(null);
					
					
					ClienteDao dao = new ClienteDao(cliente);
					dao.salvar();
					
					JOptionPane.showMessageDialog(null, "Informações cadastradas com sucesso!");
						
					limparFormulario();//limpar todos os campos caso o cadastro for finalizado com sucesso
				
				criarTabela();
				
				
				}else {
					JOptionPane.showMessageDialog(
							null,
							"Você deve preencher todos os campos!",
							"Atenção", 
							JOptionPane.WARNING_MESSAGE);
				}
						
			}
			
		});
				
			}
		
		
        
	
	
	
	
	public void criarTabela() {
		
// ***Criando a tabela***
	    
	    //PASSO 1-criar o modelo para a nossa tabela
		
		
		
	    tabelaClientesModelo = new DefaultTableModel();
	    
	    //Adicionar as colunas da tabela
	    tabelaClientesModelo.addColumn("CÓDIGO");
	    tabelaClientesModelo.addColumn("PLACA");
	    tabelaClientesModelo.addColumn("MODELO");
	    tabelaClientesModelo.addColumn("DATA DE ENTRADA");
	    
	    ClienteDao clienteDao = new ClienteDao();
	    ArrayList<Cliente> clientes = clienteDao.listarClientes();
	    
        
	    for (Cliente cliente : clientes) {
	    	
	    	String[] vetorCliente = {cliente.getCodigo(), cliente.getPlaca(), cliente.getModelo(), cliente.getDataDeEntrada()};
		    tabelaClientesModelo.addRow(vetorCliente);	
	    	
	    }

	    
	    //PASSO 2-Criar a tabela 
	    tabelaClientes = new JTable(tabelaClientesModelo);
	    
	    //Definindo o tamamnho das colunas na tabela
	    
	    tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(100);
	    tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(300);
	    tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(200);
	    tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(200);
	    
	    //Não permitir aumentar o tamanho da coluna
	    tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
	    
	    //Não permitir mudar as colunas de lugar
	    tabelaClientes.getTableHeader().setReorderingAllowed(false);
	    
	  //Passo 3-Colocar a tabela no painel  de rolagem(Scrool)
	    scrollTable = new JScrollPane(tabelaClientes);
	    scrollTable.setBounds(10, 130, 510, 160);
		
		
	}
	
	
		
	
	private boolean validarFormulario() {
		
		boolean valido = true;
		
		if(textPlaca.getText().trim().length()== 0) {
			
		labelPlaca.setForeground(Color.RED);   
		valido = false;	
			
		}else if(textModelo.getText().trim().length() == 0) {
		
		labelModelo.setForeground(Color.RED);
		valido = false;
			
			
		}
		
		return valido;
	}
	
	private void limparFormulario() {
		textPlaca.setText("");
	    textModelo.setText("");
	    
	}

	
}
