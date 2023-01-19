package modelo;

import java.time.LocalDate;

public class AlunoJDBC {
	private int matricula;
	private String nome;
	private LocalDate dataMatricula;
	private String endereco;
	
	public AlunoJDBC(String nome, LocalDate dataMatricula, String endereco) {
		super();
		this.nome = nome;
		this.dataMatricula = dataMatricula;
		this.endereco = endereco;
	}
		
	public AlunoJDBC() {
	
	}

	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", dataMatricula=" + dataMatricula + ", endereco="
				+ endereco + "]";
	}
	
}
