package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class LoginDao {

    private boolean logou = false;

    public LoginDao(String login,String senha) {
        ConectionFactory  conn = new ConectionFactory();

        try {
            conn.ConnectionFactory();
            String resultado = "";
            String query = "select usuario,senha from nomes where usuario = ? and senha = ?";

            PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,senha);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                logou = true;
            }

            conn.FecharConexao();

        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Erro ao logar no sistema! " + e);

        }
    }

    public boolean getLogou() {
        return logou;
    }
}