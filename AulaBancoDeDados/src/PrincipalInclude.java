import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class PrincipalInclude extends Login {

	public static void main(String[] args) {
		Login usuario = new Login();
		Login senha = new Login();
		final String user = usuario.getUsuario();
		final String password = senha.getSenha();
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		final String instrucao_insert = "INSERT INTO PROFESSOR(idade, nome) VALUES (?,?)";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucao_insert);
			preparedStatement.setInt(1, 37);
			preparedStatement.setString(2, "Marcos");
			preparedStatement.executeUpdate();
			
			System.out.println("Inclusão realizada com sucesso");
			
			
		}catch(Exception exception) {
			System.out.println("Erro na conexão com o Banco de Dados");
		}

	}

}
