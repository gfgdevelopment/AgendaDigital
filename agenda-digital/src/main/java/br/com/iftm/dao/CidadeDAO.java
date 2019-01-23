package br.com.iftm.dao;

import java.util.List;

import br.com.iftm.entily.Cidade;
import br.com.iftm.entily.enums.Estado;

public interface CidadeDAO {

	/**
	 * Método responsável por persistir o objeto {@link Cidade} na base de dados.
	 * 
	 * @param cidade (Objeto a ser persistido)
	 * @return Objeto persistido
	 */
	Cidade create(Cidade cidade);

	/**
	 * Método responsavel por recuperar da base de dados todos os objetos
	 * {@link cidade}.
	 * 
	 * @return lista de {@link Cidade}
	 */
	List<Cidade> read();

	List<Cidade> readByEstado(Estado estado);

	/**
	 * Método responsavel por persisitir (atualizar) na base de dados o objeto
	 * 
	 * @param cidade
	 * @return Objeto a ser persistido.
	 */
	Cidade update(Cidade cidade);

	/**
	 * Método responsavel por excluir da base de dados o objeto referente ao id
	 * informado.
	 * 
	 * @param id
	 */
	void delete(Integer id);

}
