package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LoginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balanceador");
		lblNewLabel.setBounds(135, 34, 163, 48);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 29));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Counter-Strike");
		lblNewLabel_1.setBounds(145, 58, 143, 62);
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 21));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setBounds(187, 153, 58, 14);
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 17));
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(170, 178, 86, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha");
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(187, 209, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String usuario = "";
			String senha = "";
			usuario = txtUsuario.getText();
			senha = new String(txtSenha.getPassword());
			LoginDao login = new LoginDao(usuario, senha);
			
					if(login.getLogou()) {
						new Admin().setVisible(true);
						setVisible(false);	
					}else {
						JOptionPane.showMessageDialog(null, "POH IRMÃO, TA QUERENDO ME PASSAR A PERNA");
					}
				
			}
		});
		
		btnNewButton.setBounds(56, 296, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Criar Conta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Cadastro().setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(170, 296, 99, 23);
		contentPane.add(btnNewButton_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(170, 240, 86, 20);
		contentPane.add(txtSenha);
		
		JButton btnNewButton_2 = new JButton("Verificar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				String usuario = "";
				String senha = "";
				usuario = txtUsuario.getText();
				senha = new String(txtSenha.getPassword());
				LoginDao login = new LoginDao(usuario, senha);
				
						if(login.getLogou()) {
							new TelaPrincipal().setVisible(true);
							setVisible(false);	
						}else {
							JOptionPane.showMessageDialog(null, "POH IRMÃO, TA QUERENDO ME PASSAR A PERNA CARAI");
						}				
			}
		});
		btnNewButton_2.setBounds(289, 296, 89, 23);
		contentPane.add(btnNewButton_2);
		
		setResizable(false); //pra não maximizar a tela
	}
}
