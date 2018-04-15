package faculdade.sistemasDistribuidos.trabalho1.telas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import faculdade.sistemasDistribuidos.trabalho1.rmi.RepositorioNotasClient;
import javax.swing.SwingConstants;

public class QuintaTela extends JFrame {

	public JFrame frame;
	public String str;
	public JButton btnNewButton;

	/**
	 * Create the application.
	 */
	public QuintaTela() {
		initialize();
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent ev) {
			try {
				RepositorioNotasClient.window1.frame.setVisible(true);
				RepositorioNotasClient.window5.frame.setVisible(false);
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
		
		JLabel lblStr = new JLabel(str);
		lblStr.setVerticalAlignment(SwingConstants.TOP);
		lblStr.setBounds(80, 30, 300, 200);
		frame.getContentPane().add(lblStr);
		
		btnNewButton = new JButton("Início");
		btnNewButton.setBounds(330, 220, 89, 25);
		frame.getContentPane().add(btnNewButton);
	}
}
