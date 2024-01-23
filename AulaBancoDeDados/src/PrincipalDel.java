import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PrincipalDel {
	
	public static void main(String[] args) {
		final String usuario = "postgres";
		final String senha = "aluno123";
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		final String instrucaoDelete = "DELETE FROM professor WHERE idade = ?";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoDelete);
			preparedStatement.setInt(1, 27);
			preparedStatement.executeUpdate();
			
			
			System.out.println("Exlusão realizada com sucesso");
			
			
		}catch(Exception exception) {
			System.out.println("Erro na conexão com o Banco de Dados");
		}

	}
	

}
