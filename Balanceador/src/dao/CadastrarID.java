package dao;

import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CadastrarID {
	public static void main(String[] args) {
		
		try {
			new CadastrarID().pegarDados();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void pegarDados() throws IOException {
		
        String id = JOptionPane.showInputDialog("Digite sua ID");

        Document d = Jsoup.connect("https://csgo-stats.com/player/"+id).timeout(0).get();


        Elements rank = d.getElementsByClass("rank-name");
        Elements rankSeletor = d.select("div.col-xs-4 span.rank-name");
        Elements nickSeletor = d.select("h1.steam-name");

        String elo = rankSeletor.text();

        String nick = nickSeletor.text();

        System.out.println("Elo: "+elo);
        System.out.println("Nick: "+nick);
              
    }
	
	
}
