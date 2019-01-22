package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entily.TipoServico;

public interface TipoServicoBusiness {

	/**
	 * Método responsavel por garantr os parametros obrigatórios, bem como solicitar
	 * a camada de acesso a dados que persista o objeto
	 * 
	 * @param tipoServico
	 * @return
	 */
	TipoServico create(TipoServico tipoServico) throws BusinessExecption;

	/**
	 * 
	 */
	List<TipoServico> read() throws BusinessExecption;

	/**
	 * 
	 */
	List<TipoServico> readByName(String nome) throws BusinessExecption;

	/**
	 * 
	 */
	TipoServico update(TipoServico tipoServico) throws BusinessExecption;

	/**
	 * 
	 */
	void delete(Integer id) throws BusinessExecption;
}
