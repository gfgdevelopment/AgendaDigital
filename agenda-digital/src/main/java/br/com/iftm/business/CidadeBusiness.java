package br.com.iftm.business;

import java.util.List;

import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.enums.Estado;

public interface CidadeBusiness {

	/**
	 * Método responsavel por garantr os parametros obrigatórios, bem como solicitar
	 * a camada de acesso a dados que persista o objeto
	 * 
	 * @param cidade
	 * @return
	 * @throws BusinessExecption
	 */
	Cidade create(Cidade cidade) throws BusinessExecption;

	List<Cidade> read() throws BusinessExecption;

	List<Cidade> readByEstado(Estado estado) throws BusinessExecption;

	Cidade update(Cidade cidade) throws BusinessExecption;

	void delete(Integer id) throws BusinessExecption;

}
