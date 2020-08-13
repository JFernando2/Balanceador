package dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class CadastrarUsuarioDao {
	public CadastrarUsuarioDao(String nome,String usuario,String patente,String senha) {

        ConectionFactory  conn = new ConectionFactory();

        try {
            conn.ConnectionFactory();
            String query = "INSERT INTO nomes(nome, usuario, patente, senha) VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, usuario);
            preparedStatement.setString(3, patente);
            preparedStatement.setString(4, senha);
    
            preparedStatement.executeUpdate();
            
            conn.FecharConexao();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado com Sucesso! :)");

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!");
            JOptionPane.showMessageDialog(null, e);
        }




    }
}
