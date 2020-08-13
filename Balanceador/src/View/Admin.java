package View;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrador");
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 29));
		lblNewLabel.setBounds(137, 27, 183, 71);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new Usuarios().setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setBounds(55, 128, 73, 62);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Cadastro().setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton_1.setBounds(181, 128, 73, 62);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Menu().setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(55, 243, 73, 62);
		contentPane.add(btnNewButton_2);
		
		JButton btnSair = new JButton("");		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		btnSair.setBounds(181, 243, 73, 62);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar");
		lblNewLabel_2.setFont(new Font("Impact", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(191, 201, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Log Off");
		lblNewLabel_3.setFont(new Font("Impact", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(65, 316, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sair");
		lblNewLabel_4.setFont(new Font("Impact", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(191, 316, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Balanceador");
		lblNewLabel_5.setFont(new Font("Impact", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(55, 201, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_4_1 = new JButton("");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new TelaPrincipal().setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_4_1.setBounds(313, 128, 73, 62);
		contentPane.add(btnNewButton_4_1);
		
		JLabel lblNewLabel_6 = new JLabel("Verificador");
		lblNewLabel_6.setFont(new Font("Impact", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(323, 201, 63, 14);
		contentPane.add(lblNewLabel_6);
		
		setResizable(false);
		
	}
}
