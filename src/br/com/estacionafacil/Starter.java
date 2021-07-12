package br.com.estacionafacil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import br.com.estacionafacil.ui.FrameCliente;

public class Starter {

	public static void main(String[] args) {
		
		//Deixar a aparencia da tela diferente
		
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
					}
					}
					} catch (UnsupportedLookAndFeelException e) {
					// handle exception
					} catch (ClassNotFoundException e) {
					// handle exception
					} catch (InstantiationException e) {
					// handle exception
					} catch (IllegalAccessException e) {
					// handle exception
					}
				
		
		FrameCliente telaCliente = new FrameCliente();
		telaCliente.criarTela();//Chamando a classe criar tela
		

	}

}
