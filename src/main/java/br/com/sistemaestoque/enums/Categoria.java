package br.com.sistemaestoque.enums;

public enum Categoria {

	INFORMATICA("Informática"),
	ELETRODOMESTICOS("Eletrodoméstico"),
	BRINQUEDOS("Brinquedos"),
	MOVEIS("Móveis");
	
	private String categoria;
	
	Categoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getCategoria() { 
		return categoria;
	}
}
