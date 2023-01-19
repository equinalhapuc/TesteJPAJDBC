package teste;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import modelo.AlunoJDBC;

public class TesteJDBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		PreparedStatement stm = null;
		
		Class.forName("org.postgresql.Driver");
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/teste", "teste", "teste");
		stm = conn.prepareStatement("INSERT INTO ALUNOS(NOME, DATA_MATRICULA, ENDERECO) VALUES(?, ?, ?)");

		AlunoJDBC aluno1 = new AlunoJDBC("Joao", LocalDate.now(), "Rua Matacavalos, 10");
		
		stm.setString(1, aluno1.getNome());
		stm.setDate(2, Date.valueOf(aluno1.getDataMatricula()));
		stm.setString(3, aluno1.getEndereco());
	
		System.out.println(stm.executeUpdate());
			
		Statement stm2 = conn.createStatement();
		String sql = "SELECT * FROM ALUNOS";
		ResultSet rs = stm2.executeQuery(sql);
		
		while (rs.next()) {
			int mat = rs.getInt("matricula");
			String nome = rs.getString("Nome");
			Date dataMatricula = rs.getDate("data_matricula");
			String endereco = rs.getString("endereco");
			
//			System.out.println(dataMatricula);
			LocalDate dataMat = dataMatricula.toLocalDate();
			
			System.out.println(new AlunoJDBC(nome, dataMat, endereco));
		}
	}
}
