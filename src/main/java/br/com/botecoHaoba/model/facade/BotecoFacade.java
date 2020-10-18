package br.com.botecoHaoba.model.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.botecoHaoba.model.entidades.Comanda;

public class BotecoFacade {

	private List<Comanda> comandas = new ArrayList<Comanda>();

	public void addComanda(Comanda comanda) {
		for (int i = 0; i > comandas.toArray().length; i++) {
			System.out.println((comandas.get(i).getMesa() * 2) / 2);
		}

		verificaMesa(comanda);
		calculaValorTotal(comanda);
		calculaValorComissao(comanda);
		this.comandas.add(comanda);
	}

	public List<Comanda> getComandas() {

		return new ArrayList<>(comandas);
	}

	public void remove(Comanda comanda) {

		comandas.remove(comanda);
	}

	public void calculaValorTotal(Comanda comanda) {

		comanda.setValorTotal(0);
	}

	public void calculaValorComissao(Comanda comanda) {

		comanda.setValorTotal(0);
	}

	@SuppressWarnings("unused")
	public boolean verificaMesa(Comanda comanda) {
		if (comandas.size() >= 0) {
			for (int i = 0; i < comandas.toArray().length; i++) {
				return comandas.get(i).getMesa() == comanda.getMesa();
			}
		}
		return false;
	}

	public int getQuantidadeItensConsumo() {
		int consumo = 0;
		if (comandas.size() >= 0) {
			for (int i = 0; i < comandas.toArray().length; i++) {
				for(int j = 0; j < comandas.get(i).getItensComanda().toArray().length; j++) {
					consumo = consumo + comandas.get(i).getItensComanda().get(j).getQuantidade();
				}
			}
		}
		return consumo;
	}

	public int getQuantidadeClientes() {
		int clientes = 0;
		if (comandas.size() >= 0) {
			for (int i = 0; i < comandas.toArray().length; i++) {
				clientes = clientes + comandas.get(i).getQuantidadePessoasMesa();
			}
		}
		return clientes;
	}

	public int getQuantidadeMesas() {
		return comandas.size();
	}

}
