package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CadastrarUsuarioDao;
import dao.LoginDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUsuario;
	private JPasswordField passwordSenha;
	private JComboBox comboBoxPatente;

	
	/**
	 * Create the frame.
	 */
	public Cadastro()  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 29));
		lblNewLabel.setBounds(156, 11, 175, 67);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(188, 89, 50, 20);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(156, 120, 110, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rio");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(182, 154, 56, 20);
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(156, 185, 110, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Patente");
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(182, 220, 56, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(188, 282, 50, 20);
		contentPane.add(lblNewLabel_4);
		
		comboBoxPatente = new JComboBox();
		comboBoxPatente.setModel(new DefaultComboBoxModel(new String[] {"Silver1", "Silver2", "Silver3", "Silver4", "SilverSE", "SilverSEM", "GoldNova1", "GoldNova2", "GoldNova3", "GoldGNM", "Ak1", "Ak2", "AkCruzada", "Xerife", "\u00C1guia1", "\u00C1guia2", "SupremeMaster", "GlobalElite"}));
		comboBoxPatente.setBounds(156, 251, 110, 20);
		contentPane.add(comboBoxPatente);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setBounds(156, 313, 110, 20);
		contentPane.add(passwordSenha);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean podeSalvar = true;
				String nome = txtNome.getText();
				String usuario = txtUsuario.getText();
				String patente = comboBoxPatente.getSelectedItem().toString();
				String senha = new String (passwordSenha.getPassword());

					if(nome.length()<2 || nome.length()>20 ) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Tarso disse: 'Não pode usar menos que 2 nem mais que 20 caracteres no nome'");	
					}if(podeSalvar) {						
						if(usuario.length()<2 || usuario.length()>20) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Tarso disse: 'Não pode usar menos que 2 nem mais que 20 caracteres no nick'");
						}
						
					}if(podeSalvar) {						
						if(senha.length()<2 || senha.length()>10){
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Tarso disse: 'Não pode usar menos que 2 nem mais que 10 caracteres na senha'");
						}
					}
						
					if(podeSalvar) {
						int IdPatente = comboBoxPatente.getSelectedIndex()+1;
						new CadastrarUsuarioDao(nome, usuario, patente, senha);
						txtNome.setText("");
						txtUsuario.setText("");
						comboBoxPatente.setSelectedIndex(0);
						passwordSenha.setText("");
						
						System.out.println("Patente "+IdPatente);
					}
						
				
			}
			
		});
		
		btnCriar.setBounds(50, 364, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNome.setText("");
				txtUsuario.setText("");
				comboBoxPatente.setSelectedIndex(0);
				passwordSenha.setText("");
			}
		});
		btnNewButton_1.setBounds(164, 364, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Admin().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(285, 364, 89, 23);
		contentPane.add(btnNewButton_2);
		
		setResizable(false);
		
		
	}
}
