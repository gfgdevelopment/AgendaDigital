package br.com.iftm.dao.impl;

//CAMADA DE DADOS

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.TipoServicoDAO;
import br.com.iftm.entily.TipoServico;

@Repository
public class TipoServicoDAOImpl implements TipoServicoDAO {

	private List<TipoServico> lista = new ArrayList<>();
	private int indice = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.TipoServicoDAO#create(br.com.iftm.entily.TipoServico)
	 */

	@Override
	public TipoServico create(TipoServico tipoServico) {

		// numero do codigo em sequencia
		tipoServico.setCodigo(indice++);

		// envia para a lista
		lista.add(tipoServico);

		return tipoServico;
	}

	@Override
	public List<TipoServico> read() {

		return lista;
	}

	@Override
	public List<TipoServico> readByName(String nome) {

		List<TipoServico> listaRetorno = new ArrayList<>();
		// verifica na lista
		for (TipoServico tipoServico : lista) {
			if (tipoServico.getNome().toUpperCase().contains(nome.toUpperCase())) {
				listaRetorno.add(tipoServico);
			}
		}

		return listaRetorno;
	}

	@Override
	public TipoServico update(TipoServico tipoServico) {

		for (TipoServico tipoServico2 : lista) {
			if (tipoServico2.getCodigo().equals(tipoServico.getCodigo())) {
				tipoServico2.setNome(tipoServico.getNome());
			}
		}

		return tipoServico;
	}

	@Override
	public void delete(Integer id) {

		for (TipoServico tipoServico2 : lista) {

			if (tipoServico2.getCodigo().equals(id)) {
				// remove da lista
				lista.remove(tipoServico2);
				break;
			}
		}
	}

}
