package br.com.botecoHaoba.model.entidades;

public class ConsumoTotal {
	private String descricao;
	private Integer quantidade;
	private Double preco;

	public ConsumoTotal(String descricao, Integer quantidade, Double preco) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
