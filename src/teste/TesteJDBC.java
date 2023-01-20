package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import DAO.AlunoDAO;
import modelo.AlunoJDBC;
import utilJDBC.ConnectionFactory;

public class TesteJDBC {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionFactory.getConnection();
		
		AlunoJDBC aluno1 = new AlunoJDBC("Patricia", LocalDate.now(), "Rua dos Borracheiros, 15");
		AlunoDAO alunoDao = new AlunoDAO(conn);
		
		alunoDao.salvar(aluno1);
			
		List<AlunoJDBC> alunos = alunoDao.buscar("Joao");
		
		alunos.forEach(System.out::println);
		
		AlunoJDBC aluno2 = alunoDao.buscar(4);
		System.out.println("Achei " + aluno2);
	}
}
