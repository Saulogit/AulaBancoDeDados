import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class PrincipalLeitura extends Login {

	public static void main(String[] args) {
		
		Login usuario = new Login();
		Login senha = new Login();
		final String user = usuario.getUsuario();
		final String password = senha.getSenha();
		final String url = "jdbc:postgresql://localhost:5432/postgres";
		final String instrucaoSelect = "SELECT * FROM professor";
		final String driverBanco = "org.postgresql.Driver";
		
		try {
			Class.forName(driverBanco);
			Connection conexao = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = conexao.prepareStatement(instrucaoSelect);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int idade = rs.getInt("idade");
				String nome = rs.getString("nome");
				System.out.println("Idade: " + idade + " - Nome: " + nome);
			}
			


			
			System.out.println("Leitura realizada com sucesso");
			
			
		}catch(Exception exception) {
			System.out.println("Erro na conexão com o Banco de Dados");
		}
		
	}

}
