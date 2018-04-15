package faculdade.sistemasDistribuidos.trabalho1.telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;


import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;

public class SextaTela extends JFrame {

	public JFrame frame;
	public JButton btnNewButton;
	public String matricula;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public SextaTela() {
		initialize();
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					RepositorioNotasClient.window5.str = RepositorioNotasClient.repo.consular_cr(textField.getText()).toString();
					
					RepositorioNotasClient.window5.frame.setVisible(true);
					RepositorioNotasClient.window6.frame.setVisible(false);
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
		
		JLabel lblMatrcula = new JLabel("Matrícula: ");
		lblMatrcula.setBounds(80, 70, 300, 15);
		frame.getContentPane().add(lblMatrcula);
		
		textField = new JTextField();
		textField.setBounds(80, 100, 300, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		matricula = textField.getText();
		
		btnNewButton = new JButton("Consultar");
		btnNewButton.setBounds(170, 190, 120, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
