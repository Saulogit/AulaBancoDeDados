import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrincipalDel extends Login {
	
	public static void main(String[] args) {
		Login usuario = new Login();
		Login senha = new Login();
		final String user = usuario.getUsuario();
		final String password = senha.getSenha();
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		final String instrucaoDelete = "DELETE FROM professor WHERE idade = ?";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoDelete);
			preparedStatement.setInt(1, 27);
			preparedStatement.executeUpdate();
			
			
			System.out.println("Exclusão realizada com sucesso");
			
			
		}catch(Exception exception) {
			System.out.println("Erro na conexão com o Banco de Dados");
		}

	}
	

}
