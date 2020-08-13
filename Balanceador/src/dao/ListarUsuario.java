package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class ListarUsuario {

	public List<Usuario> ListarUsuario(){
		
		ConectionFactory conn = new ConectionFactory();
		
		List<Usuario> list = new ArrayList<>();
		
		try {
			
			conn.ConnectionFactory();
			String query = "Select * from nomes";
			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Usuario nomes = new Usuario();
				nomes.setNome(rs.getString("nome"));
				nomes.setUsuario(rs.getString("usuario"));
				nomes.setPatente(rs.getString("patente"));
				
				list.add(nomes);
				
			}
			
			conn.FecharConexao();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			
			return null;
		}		
	}	
}
