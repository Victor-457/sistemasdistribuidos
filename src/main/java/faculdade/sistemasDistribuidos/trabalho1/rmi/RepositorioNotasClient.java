package faculdade.sistemasDistribuidos.trabalho1.rmi;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.rmi.Naming;

import faculdade.sistemasDistribuidos.trabalho1.telas.PrimeiraTela;
import faculdade.sistemasDistribuidos.trabalho1.telas.QuartaTela;
import faculdade.sistemasDistribuidos.trabalho1.telas.QuintaTela;
import faculdade.sistemasDistribuidos.trabalho1.telas.SegundaTela;
import faculdade.sistemasDistribuidos.trabalho1.telas.SextaTela;
import faculdade.sistemasDistribuidos.trabalho1.telas.TerceiraTela;

public class RepositorioNotasClient {
	public static PrimeiraTela window1;
	public static SegundaTela  window2;
	public static TerceiraTela window3;
	public static QuartaTela   window4;
	public static QuintaTela   window5;
	public static SextaTela    window6;
	public static RepositorioNotasInterface repo;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					repo = (RepositorioNotasInterface) Naming.lookup("rmi://localhost/RepositorioNotas");
					/*
					 *  Eu só adicionei o código abaixo e o pacote com as telas. Não mexi em mais nada
					 */
					window1 = new PrimeiraTela();
					window2 = new SegundaTela();
					window3 = new TerceiraTela();
					window4 = new QuartaTela();
					window5 = new QuintaTela();
					window6 = new SextaTela();
					
					window1.frame.setVisible(true);
					window2.frame.setVisible(false);
					window3.frame.setVisible(false);
					window4.frame.setVisible(false);
					window5.frame.setVisible(false);
					window6.frame.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

}
