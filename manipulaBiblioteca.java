package exercicio_biblioteca;

public class manipulaBiblioteca {
	private Biblioteca bib;
	Teclado t=new Teclado();
	
	public manipulaBiblioteca() {
		bib = new Biblioteca(20,10);

	}
	
	public void rodaBiblioteca() {
		//insere editoras de teste
		bib.insereEditora(new Editora("e1", 1));
		bib.insereEditora(new Editora("e2", 2));
		bib.insereEditora(new Editora("e3", 3));
		//insere livros de teste
		bib.insereLivro(new Livro("l1", "a1", 1, 100));
		bib.insereLivro(new Livro("l2", "a2", 2, 200));
		bib.insereLivro(new Livro("l3", "a3", 3, 300));
		
		boolean repetir = true;
		while (repetir==true) {
			imprimeMenu();
			int opcao= t.leInt("Insira a opção desejada");
			switch (opcao) {
			case 1:// insere livro
				insereLivroNoCadastro(criaLivro());
				break;
			case 2: //remove livro pelo nome
				removeLivroPeloNome();
				break;
			case 3: //remove livro pela editora
				removeLivroPelaEditora();
				break;
			case 4: //listar livros
				System.out.println("Livros Cadastrados:");
				System.out.println(bib.livrosToString());
				break;
			case 5: //inserir editora
				insereEditora();
				break;
			case 6://remove editora
				removeEditora();
				break;
			case 7: //listar editoras
				System.out.println("Editoras Cadastradas:");
				System.out.println(bib.editorasToString());
				break;
			default:
				System.out.println("Opção escolhida: ENCERRAR O PROGRAMA");
				repetir=false;
				break;
			}
		}
	}
	private void imprimeMenu() {
		System.out.println("1 - Inserir um Livro");
		System.out.println("2 - Remove livro pelo nome");
		System.out.println("3 - Remove livro pela editora");
		System.out.println("4 - Listar livros");
		System.out.println("5 - Inserir editora");
		System.out.println("6 - Remove editora");
		System.out.println("7 - Listar editoras");
		System.out.println("Outro Valor -> ENCERRA PROGRAMA");
	}
	private Livro criaLivro() {
		String nome;
		String autor;
		int codEditora;
		int numPaginas;
		
		nome=t.leString("Insira o nome do livro");		
		autor=t.leString("Insira o autor do livro");		
		codEditora=t.leInt("Insira o código da editora");
		numPaginas=t.leInt("Insira o numero de páginas");
		Livro livro = new Livro(nome, autor, codEditora, numPaginas);
		
		return livro;
	}
	private void insereLivroNoCadastro(Livro liv) {
		int c= bib.insereLivro(liv);
		if (c==0) {
			System.out.println("Livro inserido com sucesso!");
		}else if(c==1) {
			System.out.println("Erro ao inserir o livro");
			System.out.println("Cadastro cheio");
		}else if(c==2) {
			System.out.println("Erro ao inserir o livro");
			System.out.println("Já há um livro cadastrado com este nome!");
		}else {
			System.out.println("Erro ao inserir o livro");
			System.out.println("Editora não cadastrada");
		}
	}
	private void removeLivroPeloNome() {
		String nomeLivro = t.leString("Insira o nome do livro a ser removido");
		if (bib.removeLivroPeloNome(nomeLivro) ) {
			System.out.println("Livro \""+nomeLivro+"\" removido com SUCESSO");
		}else {
			System.out.println("Erro ao remover o livro \""+nomeLivro+"\"");
		}
	}
	private void removeLivroPelaEditora() {
		System.out.println("1. Remover por Nome");
		System.out.println("2. Remover por Código");
		int opcao = t.leInt("Insira o numero da opção desejada: "); 
		switch (opcao) {
		case 1:
			String nomeEditora = t.leString("Insira o nome da editora para remover os livros");
			if (bib.removeLivroPelaEditoraNome(nomeEditora)) {
				System.out.println("Sucesso na remoção dos livros");
			}else {
				System.out.println("Erro na remoção");
				System.out.println("Não há livros cadastrados com este nome!");
			}
			return;
		case 2:
			int codEditora = t.leInt("Insira o código da editora: ");
			if (bib.removeLivroPelaEditoraCodigo(codEditora)) {
				System.out.println("Sucesso na remoção dos livros");
			}else {
				System.out.println("Erro na remoção");
				System.out.println("Não há livros cadastrados com este código!");	
			}
			return;
		default:
			System.out.println("Opção não valida");
			return;
		}
	}	
	private void insereEditora() {
		String nome = t.leString("Insira o nome da editora");
		int codigo = t.leInt("Insira o código da editora");
		int c=bib.insereEditora(new Editora(nome, codigo));
		if (c==0) {
			System.out.println("Editora inserida com sucesso!");
		}else if(c==1){
			System.out.println("Não foi possível inserir a editora");
			System.out.println("O cadastro já está cheio!");
		}else {
			System.out.println("Não foi possível inserir a editora");
			System.out.println("O código desta editora já foi cadastrado!");
		}
	}
	private void removeEditora() {
		System.out.println("1. Remover por Nome");
		System.out.println("2. Remover por Código");
		int opcao = t.leInt("Insira o numero da opção desejada: "); 
		switch (opcao) {
		case 1:
			String nomeEditora = t.leString("Insira o nome da editora a ser removida: ");
			if (bib.removeEditoraNome(nomeEditora)) {
				System.out.println("Editora e seus livros removidos com sucesso");
			}else {
				System.out.println("Esta editora não está cadastrada!");
			}
			return;
		case 2:
			int codEditora = t.leInt("Insira o código da editora: ");
			if (bib.removeEditoraCodigo(codEditora)) {
				System.out.println("Editora e seus livros removidos com sucesso");
			}else {
				System.out.println("Esta editora não está cadastrada!");
			}
			return;
		}
	}	
}