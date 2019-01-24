package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entily.PrestacaoServico;

public interface PrestacaoServicoDAO {

	/**
	 * Método responsável por persistir o objeto {@link PrestacaoServico} na base de
	 * dados.
	 * 
	 * @param prestacaoServico (Objeto a ser persistido)
	 * @return Objeto persistido
	 */
	PrestacaoServico create(PrestacaoServico prestacaoServico);

	/**
	 * Método responsavel por recuperar da base de dados todos os objetos
	 * {@link cidade}.
	 * 
	 * @return lista de {@link PrestacaoServico}
	 */
	List<PrestacaoServico> read();

	/**
	 * Método responsavel por persisitir (atualizar) na base de dados o objeto
	 * 
	 * @param prestacaoServico
	 * @return Objeto a ser persistido.
	 */
	PrestacaoServico update(PrestacaoServico prestacaoServico);

	/**
	 * Método responsavel por excluir da base de dados o objeto referente ao id
	 * informado.
	 * 
	 * @param id
	 */
	void delete(Integer id);

}
