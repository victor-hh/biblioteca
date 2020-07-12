package exercicio_biblioteca;

public class Biblioteca {
	private Livro[] livros;
	private int totLivros;
	private int tamLivros;
	private Editora[] editoras; //array com todas as editoras cadastradas
	private int totEdits; //total de editoras cadastradas
	private int tamEdits; //tamanho do array editoras
	
	public Biblioteca(int tamArrayLivros, int tamArrayEdits) {
		this.livros= new Livro[tamArrayLivros];
		this.totLivros = 0;
		this.tamLivros = tamArrayLivros;
		this.editoras = new Editora[tamArrayEdits];
		this.totEdits = 0;
		this.tamEdits = tamArrayEdits;
	}
	
	public int insereLivro(Livro l) {
		if (totLivros==tamLivros) {//cadastro está cheio
			return 1;
		}
		for (int i=0; i<totLivros; i++) {
			if(l.getNome().equalsIgnoreCase(livros[i].getNome())) {
				return 2;
			}
		}
		for (int i=0; i<totEdits; i++) {
			if(l.getCodEditora()==editoras[i].getCodigo()) {
				livros[totLivros]=l;
				totLivros++;
				return 0;
			}
		}
		return 3;//editora não cadastrada
	}
	
	public boolean removeLivroPeloNome(String nomeRemover) {
		for (int i=0;i<totLivros;i++) {
			if(livros[i].getNome().equalsIgnoreCase(nomeRemover)) {
				totLivros--;
				livros[i]=livros[totLivros];
				return true;
			}
		}
		return false;
	}
	
	public String livrosToString() {
		String livrosString="";
		
		for (int i=0; i<totLivros; i++) {
			livrosString += ("Livro "+(i+1)+"\n");
			livrosString +=("\tNome: "+livros[i].getNome()+"\n\tAutor: "+livros[i].getAutor()+"\n");
			for (int j=0; j<tamEdits; j++) {
				if (livros[i].getCodEditora()==editoras[j].getCodigo()) {
					livrosString+=("\tEditora: "+editoras[j].getNome()+"\n");
					break;
					}
				}
			livrosString+=("\tNumero de Páginas: "+livros[i].getNumPaginas()+"\n");
		}
	return livrosString;
	}
	
	public int insereEditora (Editora editoraInserir) {
		if (tamEdits==totEdits) {
			return 1;//cadastro cheio
		}else{
			for (int i=0; i<totEdits; i++) {
				if (editoraInserir.getCodigo()==editoras[i].getCodigo()) {
					return 2;//código já utilizado
				}
			}
			editoras[totEdits]=editoraInserir;
			totEdits++;
			return 0;
		}
	}

	public boolean removeEditoraNome(String nomeRemover) {
		for (int i=0; i<totEdits; i++) {
			if(editoras[i].getNome().equalsIgnoreCase(nomeRemover)) {
				for (int j=0;j<totLivros;j++) {
					if(livros[j].getCodEditora()==editoras[i].getCodigo()) {
						totLivros--;
						livros[j]=livros[totLivros];					
					}
				}
				totEdits--;
				editoras[i]=editoras[totEdits];
				return true;
			}
		}
	return false;
	}
	
	public boolean removeEditoraCodigo(int codigoRemover) {
		for (int i=0; i<totEdits; i++) {
			if(editoras[i].getCodigo()==codigoRemover) {
				for (int j=0;j<totLivros;j++) {
					if(livros[j].getCodEditora()==codigoRemover) {
						totLivros--;
						livros[j]=livros[totLivros];					
					}
				}
				totEdits--;
				editoras[i]=editoras[totEdits];
				return true;
			}
		}
	return false;		
	}

	public boolean removeLivroPelaEditoraNome(String nome) {
		for (int i=0; i<totEdits; i++) {
			if(editoras[i].getNome().equalsIgnoreCase(nome)) {
				for (int j=0; j<totLivros; j++) {
					if(editoras[i].getCodigo()==livros[j].getCodEditora()) {
						totLivros--;
						livros[j]=livros[totLivros];
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public boolean removeLivroPelaEditoraCodigo(int codigo) {
		for (int i=0; i<totEdits; i++) {
			if(editoras[i].getCodigo()==codigo) {
				for (int j=0; j<totLivros; j++) {
					if(codigo==livros[j].getCodEditora()) {
						totLivros--;
						livros[j]=livros[totLivros];
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public String editorasToString() {
		String editorasString="";
		for(int i=0; i<totEdits; i++) {
			editorasString+=editoras[i]+"\n";
		}
		return editorasString;
	}
}
	