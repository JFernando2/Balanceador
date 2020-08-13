package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Balanceador extends JFrame {

	private JPanel contentPane;
	private JTable table1;
	private List<Usuario> list;
	private JTable table2;
	public static int time;
	/**
	 * Launch the application.
	 */
	
	
	public Balanceador(List lista) {
		list = lista;
		time = 1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balanceador");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 29));
		lblNewLabel.setBounds(144, 29, 161, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Concluir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Admin().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(92, 266, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(256, 266, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 93, 161, 162);
		contentPane.add(scrollPane);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Time 1"
			}
		));
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(218, 93, 161, 162);
		contentPane.add(scrollPane_1);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Time 2"
			}
		));
		scrollPane_1.setViewportView(table2);
		
		
		listarJogadores();
	}
	
	public void listarJogadores(){		
		
			DefaultTableModel dados1 = (DefaultTableModel) table1.getModel();
			dados1.setNumRows(0);
			for(Usuario u1:list) {
				if(u1.getTime() == 1) {
					
				dados1.addRow(new Object[] {
						u1.getNome()						
				});
			}
			
			DefaultTableModel dados = (DefaultTableModel) table2.getModel();
			dados.setNumRows(0);
			for(Usuario u:list) {
				if(u.getTime() == -1) {
					dados.addRow(new Object[] {
							u.getNome()
					});
				}
				
			}
		}
		
	}
}
