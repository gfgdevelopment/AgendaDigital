package br.com.iftm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.iftm.dao.PrestadorServicoDAO;
import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.PrestadorServico;

//CAMADA DE DADOS

@Repository
public class PrestadorServicoDAOImpl implements PrestadorServicoDAO {

	private List<PrestadorServico> listaPrestador = new ArrayList<>();
	private int indice = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.iftm.dao.PrestadorServicoDAO#create(br.com.iftm.entily.
	 * PrestadorServico)
	 */

	@Override
	public PrestadorServico create(PrestadorServico prestadorServ) {

		// numero do codigo em sequencia
		prestadorServ.setCodigo(indice++);

		// envia para a lista
		listaPrestador.add(prestadorServ);

		return prestadorServ;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public List<PrestadorServico> read() {

		return listaPrestador;
	}

	@Override
	public List<PrestadorServico> readByName(String nome) {

		List<PrestadorServico> listaRetorno = new ArrayList<>();
		// verifica na lista
		for (PrestadorServico prestadorServ : listaPrestador) {
			if (prestadorServ.getNome().toUpperCase().contains(nome.toUpperCase())) {
				listaRetorno.add(prestadorServ);
			}
		}

		return listaRetorno;
	}

	@Override
	public List<PrestadorServico> readByCidade(Cidade cidade) {

		List<PrestadorServico> listaRetorno = new ArrayList<>();
		// verifica na lista
		for (PrestadorServico prestadorServ : listaPrestador) {
			if (prestadorServ.getCidade().equals(cidade)) {
				listaRetorno.add(prestadorServ);
			}
		}

		return listaRetorno;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public PrestadorServico update(PrestadorServico prestadorServ) {

		for (PrestadorServico prestadorServico2 : listaPrestador) {
			if (prestadorServico2.getCodigo().equals(prestadorServ.getCodigo())) {
				prestadorServico2.setNome(prestadorServ.getNome());
				prestadorServico2.setBairro(prestadorServ.getBairro());
				prestadorServico2.setCep(prestadorServ.getCep());
				prestadorServico2.setCidade(prestadorServ.getCidade());
				prestadorServico2.setTipoLogradouro(prestadorServ.getTipoLogradouro());
				prestadorServico2.setLogradouro(prestadorServ.getLogradouro());
				prestadorServico2.setComplemento(prestadorServ.getComplemento());
				prestadorServico2.setNumero(prestadorServ.getNumero());
				prestadorServico2.setEmail(prestadorServ.getEmail());
				prestadorServico2.setTelefones(prestadorServ.getTelefones());
				prestadorServico2.setTipoServicos(prestadorServ.getTipoServicos());
			}
		}

		return prestadorServ;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void delete(Integer id) {

		for (PrestadorServico prestadorServico2 : listaPrestador) {

			if (prestadorServico2.getCodigo().equals(id)) {
				// remove da lista
				listaPrestador.remove(prestadorServico2);
				break;
			}
		}
	}

}
