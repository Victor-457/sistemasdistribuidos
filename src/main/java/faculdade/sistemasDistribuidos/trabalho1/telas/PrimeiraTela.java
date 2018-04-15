package faculdade.sistemasDistribuidos.trabalho1.telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraTela {

	public JFrame frame;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;


	/**
	 * Create the application.
	 */
	public PrimeiraTela() {
		initialize();
		btnNewButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					RepositorioNotasClient.window2.frame.setVisible(true);
					RepositorioNotasClient.window1.frame.setVisible(false);
				} catch (Exception e){
					e.printStackTrace();
				}
			}		
		});
		btnNewButton_1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {	
					RepositorioNotasClient.window3.frame.setVisible(true);
					RepositorioNotasClient.window1.frame.setVisible(false);
				} catch (Exception e){
					e.printStackTrace();
				}	
			}
		});
		btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					RepositorioNotasClient.window6.frame.setVisible(true);
					RepositorioNotasClient.window1.frame.setVisible(false);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					RepositorioNotasClient.window4.frame.setVisible(true);
					RepositorioNotasClient.window1.frame.setVisible(false);
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
			
		
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Consultar nota");
		btnNewButton.setBounds(80, 30, 300, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar notas");
		btnNewButton_1.setBounds(80, 90, 300, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Consultar CR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(80, 150, 300, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cadastrar nota");
		btnNewButton_3.setBounds(80, 210, 300, 25);
		frame.getContentPane().add(btnNewButton_3);
	}
}
