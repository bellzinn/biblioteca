package biblioteca.modelo;

public class Emprestimo {
	private int idEmprestimo;
	private String dataRetirada;
	private String dataReservada;
	private String dataDevolucaoPrev;
	private String dataDevolucaoReal;
	
	
	
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	
	public String getDataRetirada() {
		return dataRetirada;
	}
	
	public void setDataRetirada(String dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	
	public String getDataReservada() {
		return dataReservada;
	}
	
	public void setDataReservada(String dataReservada) {
		this.dataReservada = dataReservada;
	}
	
	public String getDataDevolucaoPrev() {
		return dataDevolucaoPrev;
	}
	
	public void setDataDevolucaoPrev(String dataDevolucaoPrev) {
		this.dataDevolucaoPrev = dataDevolucaoPrev;
	}
	
	public String getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	
	public void setDataDevolucaoReal(String dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
	



}
