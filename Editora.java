package exercicio_biblioteca;

public class Editora {
	private String nome;
	private int codigo;
	
	public Editora() {
	}

	public Editora(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString() {
		return "Nome da Editora: "+nome+"\tCódigo: "+codigo;	
	}
}