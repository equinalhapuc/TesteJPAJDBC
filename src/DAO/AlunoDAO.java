package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.AlunoJDBC;

public class AlunoDAO {
	private PreparedStatement stm = null;
	private Connection conn = null;
	
	public AlunoDAO(Connection conn) {
		this.conn = conn;
	}
	
	public boolean salvar(AlunoJDBC aluno) throws SQLException {
		stm = conn.prepareStatement("INSERT INTO ALUNOS(NOME, DATA_MATRICULA, ENDERECO) VALUES(?, ?, ?)");
		stm.setString(1, aluno.getNome());
		stm.setDate(2, Date.valueOf(aluno.getDataMatricula()));
		stm.setString(3, aluno.getEndereco());
		
		return stm.execute();
	}
	
	public List<AlunoJDBC> buscar(String nome) throws SQLException {
		stm = conn.prepareStatement("SELECT * FROM ALUNOS WHERE NOME = ?");
		stm.setString(1, nome);
		List<AlunoJDBC> lista = new ArrayList<>();
		
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			int matricula = rs.getInt("matricula");
			String nomealuno = rs.getString("nome");
			LocalDate dataMatricula = rs.getDate("data_matricula").toLocalDate();
			String endereco = rs.getString("endereco");
			AlunoJDBC aluno = new AlunoJDBC(nomealuno, dataMatricula, endereco);
			aluno.setMatricula(matricula);
			lista.add(aluno);
		}
		return lista;
	}
	
	public AlunoJDBC buscar(int matricula) throws SQLException {
		stm = conn.prepareStatement("SELECT * FROM ALUNOS WHERE matricula = ?");
		stm.setInt(1, matricula);
		ResultSet rs = stm.executeQuery();
		AlunoJDBC aluno = null;
		while(rs.next()) {
			String nomealuno = rs.getString("nome");
			LocalDate dataMatricula = rs.getDate("data_matricula").toLocalDate();
			String endereco = rs.getString("endereco");
			aluno = new AlunoJDBC(nomealuno, dataMatricula, endereco);
			aluno.setMatricula(matricula);
		}
		return aluno;		
	}
}
