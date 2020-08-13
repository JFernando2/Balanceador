package View;

import java.awt.BorderLayout;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.CadastrarUsuarioDao;
import dao.ConectionFactory;
import dao.ListarUsuario;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private List<Usuario> list;
	private static int time;
	
	/**
	 * Create the frame.
	 */
	
	public Usuarios() {		
		list = new ArrayList<>();
		time = 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rios");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 29));
		lblNewLabel.setBounds(155, 23, 123, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 107, 309, 216);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Nick", "Patente"
			}
		));
		scrollPane.setViewportView(table);
		ListarLista();
		
		
		btnNewButton = new JButton("Balancear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Balanceador(list).setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(72, 352, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Admin().setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(286, 352, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Select");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel dados = (DefaultTableModel)getTable().getModel();
				time = time *-1;
				String nome = (String) table.getModel().getValueAt(table.getSelectedRow(),0);
				String usuario = (String) table.getModel().getValueAt(table.getSelectedRow(),1);
				String patente = (String) table.getModel().getValueAt(table.getSelectedRow(),2);
				
				Usuario user ;
				user = new Usuario();
				user.setNome(nome);	
				user.setUsuario(usuario);
				user.setPatente(patente);
				user.setTime(time);
				list.add(user);                                                                               
				dados.removeRow(table.getSelectedRow());
				dados.fireTableRowsDeleted(table.getSelectedRow(), table.getSelectedRow());
				
			}
		});
		btnNewButton_2.setBounds(181, 352, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		setResizable(false);
	}
	
	
	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public void ListarLista() {
		ListarUsuario dao = new ListarUsuario();
		List<Usuario> list = dao.ListarUsuario();
		
		DefaultTableModel dados = (DefaultTableModel)getTable().getModel();
		dados.setNumRows(0);
		
		for(Usuario a:list){
			dados.addRow(new Object[] {
					a.getNome(),
					a.getUsuario(),
					a.getPatente()
					
			});
		}		
	}
}
