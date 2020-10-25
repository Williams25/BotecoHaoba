package br.com.botecoHaoba.model.facade;

import java.util.ArrayList;
import java.util.List;

import br.com.botecoHaoba.model.entidades.Comanda;
import br.com.botecoHaoba.model.entidades.ConsumoTotal;

public class BotecoFacade {

	private List<Comanda> comandas = new ArrayList<Comanda>();

	public void addComanda(Comanda comanda) {
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
		double valor = 0;
		if (comandas.size() >= 0) {
			for (int i = 0; i < comanda.getItensComanda().toArray().length; i++) {
				valor = valor + (comanda.getItensComanda().get(i).getItem().getPreco())
						* comanda.getItensComanda().get(i).getQuantidade();
			}
		}
		comanda.setValorTotal(valor);
	}

	public void calculaValorComissao(Comanda comanda) {
		double valor = 0;
		double percentual = 0;
		if (comandas.size() >= 0) {
			for (int i = 0; i < comanda.getItensComanda().toArray().length; i++) {
				switch (comanda.getItensComanda().get(i).getItem().getDescricao()) {
				case "Cerveja puro malte":
					percentual = 7.60;
					break;
				case "Cerveja puro milho":
					percentual = 6.50;
					break;
				case "Taça de vinho":
					percentual = 9.00;
					break;
				case "Refrigerante cola lata":
					percentual = 8.00;
					break;
				case "Água":
					percentual = 2.50;
					break;
				case "Bolinho de bacalhau":
					percentual = 9.50;
					break;
				case "Porção de batata frita":
					percentual = 6.50;
					break;
				case "Salada verde":
					percentual = 5.50;
					break;
				case "Frango a passarinho":
					percentual = 7.40;
					break;
				case "Sorvete palito":
					percentual = 3.20;
					break;
				default:
					break;
				}

				valor = valor + (((comanda.getItensComanda().get(i).getItem().getPreco())
						* comanda.getItensComanda().get(i).getQuantidade()) * (percentual / 100));
			}
		}
		comanda.setValorComissao(valor);
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
				for (int j = 0; j < comandas.get(i).getItensComanda().toArray().length; j++) {
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

	public String valorTotalPorPessoa(Comanda comanda) {
		double total = 0;
		total = comanda.getValorTotal() / comanda.getQuantidadePessoasMesa();
		String resultado = String.format("%.2f", total);
		return resultado;
	}

	public String mostraConsumo() {
		int quantidade = 0;
		String item = null;

		List<ConsumoTotal> consumo = new ArrayList<ConsumoTotal>();

		for (Comanda comanda : comandas) {
			boolean c = false;
			for (int i = 0; i < comanda.getItensComanda().toArray().length; i++) {
				for (ConsumoTotal consumoTotal : consumo) {
					if (consumoTotal.getDescricao().equals(comanda.getItensComanda().get(i).getItem().getDescricao())) {
						consumoTotal.setQuantidade(
								consumoTotal.getQuantidade() + comanda.getItensComanda().get(i).getQuantidade());
						c = true;
					}
				}
				if (!c) {
					consumo.add(new ConsumoTotal(comanda.getItensComanda().get(i).getItem().getDescricao(),
							comanda.getItensComanda().get(i).getQuantidade(),
							comanda.getItensComanda().get(i).getItem().getPreco()));
				}
			}
		}

		for (int j = 0; j < consumo.toArray().length; j++) {
			ConsumoTotal consumoTotal = (ConsumoTotal) consumo.get(j);
			for (ConsumoTotal consumoTotal2 : consumo) {
				if (consumoTotal2.getQuantidade() > quantidade) {
					quantidade = consumoTotal2.getQuantidade();
					item = consumoTotal2.getDescricao();
				} else if (consumoTotal2.getQuantidade().equals(consumoTotal.getQuantidade())
						&& consumoTotal2.getPreco() > consumoTotal.getPreco()) {
					quantidade = consumoTotal2.getQuantidade();
					item = consumoTotal2.getDescricao();
				}
			}
		}
		return item + " " + Integer.toString(quantidade);
	}
}
