package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.MediaTracker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import dao.CadastrarUsuarioDao;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private String img ;
	private JLabel lblImagem;
	private JLabel lblPatente;
	private JLabel lblNick;
	private JLabel lblIdSteam;
	private JLabel lblPerfil;
	private JButton btnVerificar;	
	private JButton btnNewButton;
	private JButton btnVoltar;
	
	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtID = new JTextField();
		txtID.setBounds(177, 429, 121, 19);
		contentPane.add(txtID);
		txtID.setColumns(10);

		lblPatente = new JLabel("Patente");
		lblPatente.setFont(new Font("Impact", Font.BOLD, 22));
		lblPatente.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatente.setBounds(57, 20, 355, 28);
		contentPane.add(lblPatente);

		lblNick = new JLabel("Nick");
		lblNick.setFont(new Font("Impact", Font.BOLD, 22));
		lblNick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNick.setBounds(57, 171, 355, 30);
		contentPane.add(lblNick);

		lblImagem = new JLabel("");
		lblImagem.setBounds(140, 49, 200, 80);		

		contentPane.add(lblImagem);
		
		lblIdSteam = new JLabel("ID Steam");
		lblIdSteam.setFont(new Font("Impact", Font.BOLD, 19));
		lblIdSteam.setBounds(196, 391, 102, 28);
		contentPane.add(lblIdSteam);
		
		lblPerfil = new JLabel("");
		lblPerfil.setBounds(140, 212, 184, 184);
		contentPane.add(lblPerfil);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					try {
						pegarDados();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnVerificar.setBounds(52, 474, 104, 23);
		contentPane.add(btnVerificar);
		
		btnNewButton = new JButton("Criar Conta");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {				
				new Cadastro().setVisible(true);
				setVisible(false);				
			}
			
		});
		btnNewButton.setBounds(177, 474, 110, 23);
		contentPane.add(btnNewButton);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Admin().setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(302, 474, 110, 23);
		contentPane.add(btnVoltar);
		setLocationRelativeTo(null);
	}

	public void pegarDados() throws IOException {
		String id = txtID.getText();

		Document d = Jsoup.connect("https://csgo-stats.com/player/"+id).timeout(0).get();


		Elements rank = d.getElementsByClass("rank-name");
		Elements rankSeletor = d.select("div.col-xs-4 span.rank-name");
		Elements nickSeletor = d.select("h1.steam-name");
		Elements urlImg = d.select("div.rank img.img-rank");

		Elements urlImgPerfil = d.select("div.avatar img.img-avatar");

		String elo = rankSeletor.text();

		String nick = nickSeletor.text();

		img = "https://csgo-stats.com" + urlImg.attr("src");
		
		String imgPerfil = urlImgPerfil.attr("src");
		
		lblNick.setText("Nick: " + nick);
		lblPatente.setText("Patente: " + elo);
		
		 URL urlImg1 = new URL(img);
		 URL urlImgPefil = new URL(imgPerfil);
	
		ImageIcon imgIcon = new ImageIcon(urlImg1);
		ImageIcon imgIconPerfil = new ImageIcon(urlImgPefil);
		
		String num = img.replaceAll("[\\D]", ""); //pegar apenas numero da string   (isso vai substituir todo caractere não numérico por nada.)
		
		System.out.println(num);
		
		// faz o preload da imagem
		while(imgIcon.getImageLoadStatus() == MediaTracker.LOADING); 

		// injeta o icone no label
		lblImagem.setIcon(imgIcon);
		lblPerfil.setIcon(imgIconPerfil);
	}
}