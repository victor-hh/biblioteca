package exercicio_biblioteca;

public class Livro {
	private String nome;
	private String autor;
	private int codEditora;
	private int numPaginas;
	
	public Livro() {
	}
	
	public Livro(String nome, String autor, int codEditora, int numPaginas) {
		this.nome = nome;
		this.autor = autor;
		this.codEditora = codEditora;
		this.numPaginas = numPaginas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getCodEditora() {
		return codEditora;
	}

	public void setCodEditora(int codEditora) {
		this.codEditora = codEditora;
	}

	public int getNumPaginas() {
		return numPaginas;
	}

	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	public String toString() {//OBJETIVO: RETORNAR UM TEXTO QUE FAZ ALGUM SENTIDO QUANDO SOLICITADO
		return "Nome: "+nome+"\tAutor: "+autor+"\tCodigo da Editora: "+codEditora+"\tNumero de Páginas: "+numPaginas;
	}
}
