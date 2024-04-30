package biblioteca.modelo;

public class Livro {

	private String titulo;
	
	private int idlivro;
	
	private int id_Editora;
	
	private String autor;
	
	private String genero;
	
	private String idioma;
	
	private String editora;
	
	private String situacao;
	
	
	
	
	
	public String getTitulo(){
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	
	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	
	public int getId_Editora() {
		return id_Editora;
	}

	public void setId_Editora(int id_Editora) {
		this.id_Editora = id_Editora;
	}

	public int getIdlivro() {
		return idlivro;
	}

	public void setIdlivro(int idlivro) {
		this.idlivro = idlivro;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	



	
	
	
}