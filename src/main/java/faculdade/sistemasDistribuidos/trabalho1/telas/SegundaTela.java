package faculdade.sistemasDistribuidos.trabalho1.telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SegundaTela {

	public JFrame frame;
	public JButton btnNewButton;
	private JTextField textField;
	private JTextField txtAa;
	private JTextField textField_1;
	

	/**
	 * Create the application.
	 */
	public SegundaTela() {
		initialize();
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				
				BigDecimal temp = new BigDecimal(textField_1.getText());
				try {
					RepositorioNotasClient.repo.cadastrar_nota(textField.getText(), txtAa.getText(), temp);
					
					RepositorioNotasClient.window5.str = "     Nota cadastrada";
					RepositorioNotasClient.window5.frame.setVisible(true);
				
				} catch (RemoteException e) {
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
		
		JLabel lblNenotawLabel = new JLabel("Matrícula:");
		lblNenotawLabel.setBounds(80, 30, 300, 15);
		frame.getContentPane().add(lblNenotawLabel);
		
		textField = new JTextField();
		textField.setBounds(80, 50, 300, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Código disciplina:");
		lblNewLabel.setBounds(80, 80, 300, 15);
		frame.getContentPane().add(lblNewLabel);
		
		txtAa = new JTextField();
		txtAa.setBounds(80, 110, 300, 20);
		frame.getContentPane().add(txtAa);
		txtAa.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Nota: ");
		lblNewLabel_1.setBounds(80, 140, 300, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 170, 300, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
	
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(160, 210, 120, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
