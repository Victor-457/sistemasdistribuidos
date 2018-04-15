package faculdade.sistemasDistribuidos.trabalho1.telas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;

import javax.swing.JButton;

public class QuartaTela {

	public JFrame frame;
	public JButton button;
	public String matricula;
	public String codigo_disciplina;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public QuartaTela() {
		initialize();
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
				try {
					RepositorioNotasClient.window5.str = RepositorioNotasClient.repo.consultar_nota(textField.getText(), textField_1.getText()).toString();
					RepositorioNotasClient.window5.frame.setVisible(true);
					RepositorioNotasClient.window4.frame.setVisible(false);
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
		
		JLabel label = new JLabel("Matrícula: ");
		label.setBounds(80, 30, 300, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(80, 70, 300, 20);
		frame.getContentPane().add(textField);
		matricula = textField.getText();
		
		JLabel lblNewLabel = new JLabel("Código da disciplina: ");
		lblNewLabel.setBounds(80, 110, 300, 15);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 140, 300, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		codigo_disciplina = textField_1.getText();
		
		button = new JButton("Consultar");
		button.setBounds(170, 190, 120, 25);
		frame.getContentPane().add(button);
	}

}
